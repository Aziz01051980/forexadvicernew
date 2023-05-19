package myforexhelp.realtime.Controller;

import lombok.AllArgsConstructor;
import myforexhelp.realtime.Domain.Article;
import myforexhelp.realtime.Domain.User;
import myforexhelp.realtime.Repository.ArticleRepository;
import myforexhelp.realtime.Service.SearchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@AllArgsConstructor
@Controller
public class ArticleController {

    @Autowired
    private SearchingService searchingService;

    private final ArticleRepository articleRepository;

//    @Autowired
//    public ArticleController(ArticleRepository articleRepository) {
//        this.articleRepository = articleRepository;
//    }

//    @RequestMapping(value = "/articleadding", method = RequestMethod.GET)
//    public String getAll(Model model) {
//        Object allArticles = searchingService.articleConverter();
//        model.addAttribute("articles", allArticles);
//        return "articles";
//    }

    @RequestMapping(value = "/getadminpanel", method = RequestMethod.GET)
    public String getAdminPanel(Model model) {
        model.addAttribute("article", new Article());
        return "adminPanel";
    }


    @RequestMapping(value = "/checkuser")
    public String checkUser(Model model){
        model.addAttribute("user", new User());
        return "users";
    }

//    @PostMapping(value = "/searchingData")
//    public Article checkUser(@RequestParam String searchValue){
//        ArrayList<String> myString = new ArrayList<>();
//        List<Article> contents = searchingService.allArticles();
//        for(Article content : contents) {
//            String allWords = content.toString();
//            String[] word = allWords.split(" ");
//            for (int i = 0; i < word.length; i++) {
//                String contentWord = word[i];
//                myString.addAll(Collections.singleton(contentWord));
//                if (myString.contains(searchValue)) {
//                    return content;
//                }
//            }
//        }
//        return null;
//    }

    @RequestMapping(value = "/articlesall", method = RequestMethod.GET)
    public String getArticles(Model model){
        model.addAttribute("articles", articleRepository.findAll());
        return "allArticles";
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String create(@RequestBody Article article){
        List <Article> article1 = articleRepository.findAll();
        if(article1.isEmpty()){
            return "object is empty";
        } else {
            return "object is not empty";
        }
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String getCalculator(Model model){
        model.addAttribute("articles", articleRepository.findAll());
        return "calculator";
    }
}
