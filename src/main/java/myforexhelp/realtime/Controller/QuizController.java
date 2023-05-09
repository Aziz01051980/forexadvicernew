package myforexhelp.realtime.Controller;

import myforexhelp.realtime.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quiz")
public class QuizController{

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/mainquiz", method = RequestMethod.GET)
    public String getMainQuiz(Model model){
        model.addAttribute("articles", articleRepository.findAll());
        return "mainquiz";
    }


    @RequestMapping(value = "/candlestick", method = RequestMethod.GET)
    public String getCandlestickQuiz(Model model){
        model.addAttribute("articles", articleRepository.findAll());
        return "candlestick";
    }

    @RequestMapping(value = "/elliotwaves", method = RequestMethod.GET)
    public String getElliotWaveQuiz(Model model){
        model.addAttribute("articles", articleRepository.findAll());
        return "elliotwaves";
    }

    @RequestMapping(value = "/moneymanagement", method = RequestMethod.GET)
    public String getMoneyManagementQuiz(Model model){
        model.addAttribute("articles", articleRepository.findAll());
        return "moneymanagement";
    }



}
