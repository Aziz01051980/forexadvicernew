package myforexhelp.realtime.controller;

import myforexhelp.realtime.domain.*;
import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.repository.NameAndEmailRepository;
import myforexhelp.realtime.repository.UserRepository;
import myforexhelp.realtime.service.SearchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Controller
@Component
@RequestMapping("/admin")
public class PostArticleController {

    private Authentication authentication;

    private RestTemplate restTemplate;

//    private WebClient webClient;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private NameAndEmailRepository nameAndEmailRepository;

    @Autowired
    private User user;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SearchingService searchingService;

    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

    @PostMapping("/logout")
    public String performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        // .. perform logout
        this.logoutHandler.logout(request, response, authentication);
        return "homepage";
    }

    @GetMapping(value = "/userNotFound")
    public String userNotFound(){
        return "userNotFound";
    }

    @GetMapping(value = "/entryForbidden")
    public String entryForbidden(){
        return "entryForbidden";
    }

    @PostMapping(value = "/addArticle")
    public String addArticle(@RequestParam("title") String title,
                             @RequestParam("description") String description,
                             @RequestParam("content") String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setContent(content);
        articleRepository.save(article);
        return "pageForManaging";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteArticle(@PathVariable("id") Long id) {
        articleRepository.deleteById(id);
        return "pageForManaging";
    }

    @GetMapping(value = "/getForUpdate/{id}")
    public String getForUpdate(@PathVariable("id") Long id, Model model) {
        List<Object[]> allArticles = searchingService.getTitleDescriptionAndContentByid();

        List<Object[]> articleDataList = (List<Object[]>) allArticles;
        List<UpdatedArticleDTO> articles = new ArrayList<>();

        for (Object[] articleData : articleDataList) {
            Long myId = (Long) articleData[0];
            String title = (String) articleData[1];
            String description = (String) articleData[2];
            String content = (String) articleData[3];

            UpdatedArticleDTO updatedArticleDTO = new UpdatedArticleDTO(myId, title, description, content);
            articles.add(updatedArticleDTO);

            if (id.equals(myId)) {
                model.addAttribute("articles", updatedArticleDTO);
                return "templateForOneArticle";
            }
        }

        return "articleDoesNotExists";
    }

    @PutMapping(value = "/update/{id}")
    public String updateArticle(@PathVariable("id") Long id, @RequestBody UpdatedArticleDTO updatedArticle) {
        // Retrieve the existing article from the database
        Optional<Article> existingArticleOptional = articleRepository.findById(id);

        if (existingArticleOptional.isPresent()) {
            Article existingArticle = existingArticleOptional.get();

            // Update the fields of the existing article with the edited values
            existingArticle.setTitle(updatedArticle.getTitle());
            existingArticle.setDescription(updatedArticle.getDescription());
            existingArticle.setContent(updatedArticle.getContent());

            // Save the updated article in the database
            articleRepository.save(existingArticle);
            return "pageForManaging";
        } else {
            // Article with the specified ID was not found
            throw new RuntimeException("Article not found");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Object[]> allArticles = searchingService.articleConverter();

        List<Object[]> articleDataList = (List<Object[]>) allArticles;
        List<ArticleDTO> articles = new ArrayList<>();

        for (Object[] articleData : articleDataList) {
            Long id = (Long) articleData[0];
            String title = (String) articleData[1];

            ArticleDTO articleDTO = new ArticleDTO(id, title, null);
            articles.add(articleDTO);
        }

        model.addAttribute("articles", articles);
        return "pageForManaging";
    }
}
