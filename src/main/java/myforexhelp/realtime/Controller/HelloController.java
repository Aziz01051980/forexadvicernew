package myforexhelp.realtime.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }

//    @GetMapping("/articles/{id}")
//    public String getArticle(@PathVariable long id, Model model) throws IOException {
//        List<String> article = Collections.singletonList(ArticleService.getArticleById(id));
//        model.addAttribute("article", article);
//        return "article-details.html";
    }
