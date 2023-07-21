package myforexhelp.realtime.controller;

import lombok.AllArgsConstructor;
import myforexhelp.realtime.domain.Article;
import myforexhelp.realtime.domain.NameAndEmail;
import myforexhelp.realtime.domain.User;
import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.service.SearchingService;
import myforexhelp.realtime.service.SendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
@RequestMapping("/managing")
public class ArticleController {


    private ArticleRepository articleRepository;

    private SendingService sendingService;

    public ArticleController(SendingService sendingService, ArticleRepository articleRepository) {
        this.sendingService = sendingService;
        this.articleRepository = articleRepository;
    }

    @RequestMapping(value = "/getadminpanel", method = RequestMethod.GET)
    public String getAdminPanel(Model model) {
        model.addAttribute("article", new Article());
        return "adminPanel";
    }



    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String addNameAndEmail(@RequestParam("subject") String subject,
                                  @RequestParam("textOfTheMail") String textOfTheMail) {
        sendingService.sendMailToRecipient(subject, textOfTheMail);
        return "allArticles";
    }

    @RequestMapping(value = "/createArticleForSend", method = RequestMethod.GET)
    public String createArticleForSend(){
        return "createArticleForSend";
    }
}
