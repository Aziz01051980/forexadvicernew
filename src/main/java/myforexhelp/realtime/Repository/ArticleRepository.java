package myforexhelp.realtime.Repository;
import myforexhelp.realtime.Domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    void findArticleById(Long id);

//    @Query(value = "SELECT t FROM Article where t.description IS NOT NULL")
//    String findOneArticleById();

}


