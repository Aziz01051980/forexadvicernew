package myforexhelp.realtime.repository;
import myforexhelp.realtime.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    void findArticleById(Long id);

    @Query(value = "SELECT t.id, t.title FROM Article t WHERE t.id IS NOT NULL")
    List<?> findTitleAndDescription();

    @Query("SELECT t.id, t.title FROM Article t WHERE t.id IS NOT NULL")
    List<Object[]> findTitleAndId();

    @Query("SELECT t.id, t.title, t.description,t.content FROM Article t WHERE t.id IS NOT NULL")
    List<Object[]> findTitleDescriptionAndTitle();

    @Query("SELECT t.content FROM Article t WHERE t.id IS NOT NULL")
    List<Article> findContentById();
}


