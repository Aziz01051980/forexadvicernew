package myforexhelp.realtime.Controller;

import lombok.AllArgsConstructor;
import myforexhelp.realtime.Domain.Article;
import myforexhelp.realtime.Domain.User;
import myforexhelp.realtime.Repository.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@AllArgsConstructor
@Controller
public class ArticleController {


    private final ArticleRepository articleRepository;

//    @Autowired
//    public ArticleController(ArticleRepository articleRepository) {
//        this.articleRepository = articleRepository;
//    }

    @RequestMapping(value = "/articleadding", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getAll(){
        List<Article> list = articleRepository.findAll();
        return ResponseEntity.ok(list);
    }

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

    @RequestMapping (value = "/newarticleadding") //
    public String showArticleAddingForm() {
        return "newarticleadding";
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
    public String getCalculator(Model model){
        model.addAttribute("articles", articleRepository.findAll());
        return "calculator";
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }
}
