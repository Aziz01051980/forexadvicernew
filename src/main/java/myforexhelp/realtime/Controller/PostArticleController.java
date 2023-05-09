package myforexhelp.realtime.Controller;

import lombok.AllArgsConstructor;
import myforexhelp.realtime.Domain.Article;
import myforexhelp.realtime.Domain.User;
import myforexhelp.realtime.Repository.ArticleRepository;
import myforexhelp.realtime.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
//@RequestMapping("/restservice")
public class PostArticleController {

    @Autowired
    private ArticleRepository articleRepository;
//
//    @Autowired
//    private AddArticleService addArticleService;

    @Autowired
    private User user;

    @Autowired
    private UserRepository userRepository;

//    @RequestMapping(value = "/getadminpanel", method = RequestMethod.GET)
//    public String getAdminPanel(Model model) {
//        model.addAttribute("articles", new Article());
//        return "adminPanel";
//    }

//    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
//    public String getCalculator(Model model){
//        model.addAttribute("articles", articleRepository.findAll());
//        return "calculator";
//    }


//    @RequestMapping(value = "/checkuser")
//    public String checkUser(Model model){
//        model.addAttribute("user", new User()
//        return "users";
//    }

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
}
