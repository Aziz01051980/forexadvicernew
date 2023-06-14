package myforexhelp.realtime.controller;

import lombok.AllArgsConstructor;
import myforexhelp.realtime.domain.Article;
import myforexhelp.realtime.domain.User;
import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.service.SearchingService;
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
    public String getCalculator(){
        return "calculator";
    }
}
