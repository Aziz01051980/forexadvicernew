package myforexhelp.realtime.controller;

import myforexhelp.realtime.domain.NameAndEmail;
import myforexhelp.realtime.repository.NameAndEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    @Autowired
    private NameAndEmailRepository nameAndEmailRepository;


    @Autowired
    public void setNameAndEmailRepository(NameAndEmailRepository nameAndEmailRepository) {
        this.nameAndEmailRepository = nameAndEmailRepository;
    }

    @GetMapping(value = "/")
    public String getHomePage(){
        return "homepage";
    }

    @GetMapping(value = "/about")
    public String getAboutPage(){
        return "about";
    }

    @PostMapping(value = "/addNameandEmail")
    public String addNameAndEmail(
                                  @RequestParam("email") String email) {
        NameAndEmail nameAndEmail = new NameAndEmail();
        nameAndEmail.setEmail(email);
        nameAndEmailRepository.save(nameAndEmail);
        return "homepage";
    }
}
