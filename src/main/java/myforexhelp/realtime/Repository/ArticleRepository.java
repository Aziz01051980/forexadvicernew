package myforexhelp.realtime.Repository;
import myforexhelp.realtime.Domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    void findArticleById(Long id);

//    @Query(value = "SELECT t FROM Article where t.id IS NOT NULL AND t.title IS NOT NULL t.description AND t.article IS NOT NULL")
//    List<Article> findOneArticleById();

}


