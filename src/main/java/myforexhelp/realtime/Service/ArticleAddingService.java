package myforexhelp.realtime.Service;

import myforexhelp.realtime.Domain.Article;
import myforexhelp.realtime.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ArticleAddingService {

    public ArticleAddingService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Autowired
    private ArticleRepository articleRepository;

        public ResponseEntity<Article> createArticle(@RequestBody Article article){
            Article article1 = articleRepository.save(article);
            return ResponseEntity.ok(article1);

        }

}
