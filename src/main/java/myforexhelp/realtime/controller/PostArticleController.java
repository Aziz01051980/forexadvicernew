package myforexhelp.realtime.controller;

import lombok.AllArgsConstructor;
import myforexhelp.realtime.domain.*;
import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.repository.NameAndEmailRepository;
import myforexhelp.realtime.repository.UserRepository;
import myforexhelp.realtime.service.SearchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
//@RequestMapping("/restservice")
public class PostArticleController {

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

    @PostMapping(value = "/getAuthentification")
    public String getAuthentification(@RequestParam String userName, @RequestParam String password){
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            return "userNotFound";
        } else if (user.getPassword().equals(password)) {
            return "adminPanel";
        } else {
            return "entryForbidden";
        }
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
        return "allArticles";
    }

    @PostMapping(value = "/addNameandEmail")
    public String addNameAndEmail(@RequestParam("name") String name,
                             @RequestParam("email") String email) {
        NameAndEmail nameAndEmail = new NameAndEmail();
        nameAndEmail.setName(name);
        nameAndEmail.setEmail(email);
        nameAndEmailRepository.save(nameAndEmail);
        return "allArticles";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteArticle(@PathVariable("id") Long id) {
        articleRepository.deleteById(id);
        return "addedarticle";
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
            return "addedarticle";
        } else {
            // Article with the specified ID was not found
            throw new RuntimeException("Article not found");
        }
    }

    @RequestMapping(value = "/addedarticle", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Object[]> allArticles = searchingService.articleConverter();

        List<Object[]> articleDataList = (List<Object[]>) allArticles;
        List<ArticleDTO> articles = new ArrayList<>();

        for (Object[] articleData : articleDataList) {
            Long id = (Long) articleData[0];
            String title = (String) articleData[1];

            ArticleDTO articleDTO = new ArticleDTO(id, title);
            articles.add(articleDTO);
        }

        model.addAttribute("articles", articles);
        return "addedarticle";
    }
}
