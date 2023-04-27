package myforexhelp.realtime.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import myforexhelp.realtime.Domain.Article;
import myforexhelp.realtime.Repository.ArticleRepository;
import myforexhelp.realtime.Service.ArticleAddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Data
@AllArgsConstructor
@Controller
public class ArticleController {

    private final ArticleRepository articleRepository;

    @RequestMapping(value = "/articleadding", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getAll(){
        List<Article> list = articleRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @RequestMapping (value = "/", method = RequestMethod.GET) //
    public String showArticleAddingForm() {
        return "articleadding";
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public ResponseEntity<Article> create(@RequestBody Article article){
        Article article1 = articleRepository.save(article);
        return ResponseEntity.ok(article1);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }
}
