package myforexhelp.realtime.controller;


import myforexhelp.realtime.domain.Article;
import myforexhelp.realtime.domain.ArticleDTO;
import myforexhelp.realtime.domain.NameAndEmail;
import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.repository.NameAndEmailRepository;
import myforexhelp.realtime.service.SearchingService;
import myforexhelp.realtime.service.SendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ContentController {

    private ArticleRepository articleRepository;

    private NameAndEmailRepository nameAndEmailRepository;

    private SendingService sendingService;

    @Autowired
    private SearchingService searchingService;


    public ContentController(ArticleRepository articleRepository, NameAndEmailRepository nameAndEmailRepository,
                             SendingService sendingService, SearchingService searchingService) {
        this.articleRepository = articleRepository;
        this.searchingService = searchingService;
    }

    @Autowired
    public void setNameAndEmailRepository(NameAndEmailRepository nameAndEmailRepository) {
        this.nameAndEmailRepository = nameAndEmailRepository;
    }

    @Autowired
    public void setSendingService(SendingService sendingService) {
        this.sendingService = sendingService;
    }


    @RequestMapping(value = "/allArticles", method = RequestMethod.GET)
    public String getAllArticles(Model model) {
        List<Object[]> allArticles = searchingService.articleConverter();

        List<Object[]> articleDataList = (List<Object[]>) allArticles;
        List<ArticleDTO> articles = new ArrayList<>();

        for (Object[] articleData : articleDataList) {
            Long id = (Long) articleData[0];
            String title = (String) articleData[1];
            String description = (String) articleData[2];

            ArticleDTO articleDTO = new ArticleDTO(id, title, description);
            articles.add(articleDTO);
        }

        model.addAttribute("articles", articles);
        return "allArticles";
    }
    @RequestMapping(value = "/getselectedarticle/{id}", method = RequestMethod.GET)
    public String getSelectedArticle(@PathVariable Long id, Model model) {
        Object[] article = new List[]{List.of(searchingService.getContentOfArticleById(id))};
        model.addAttribute("article", article);
        return "selectedArticle";
    }
    @RequestMapping(value = "/formForClientMessage", method = RequestMethod.GET)
    public String getFormForClientMessage(Model model) {
        model.addAttribute("article", new Article());
        return "mailFromClient";
    }

    @RequestMapping(value = "/sendingClientMail", method = RequestMethod.POST)
    public String sendingClienMail(@RequestParam("mail") String mail,
                                  @RequestParam("subject") String subject,
                                  @RequestParam("textOfTheMail") String textOfTheMail
                                  ) {
        NameAndEmail nameAndEmail = new NameAndEmail();
        nameAndEmail.setEmail(mail);
        nameAndEmailRepository.save(nameAndEmail);
        sendingService.gettingMailFromClient(mail, subject, textOfTheMail);
        return "homepage";
    }
}
