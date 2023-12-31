package myforexhelp.realtime.controller;

import myforexhelp.realtime.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
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

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String getCalculator(){
        return "calculator";
    }
}
