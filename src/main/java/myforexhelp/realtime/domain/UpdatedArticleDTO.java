package myforexhelp.realtime.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "my_all_articles")
public class UpdatedArticleDTO {

    public UpdatedArticleDTO(Long id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    @Id
    private Long id;
    private String title;
    private String description;
    private String content;

    public UpdatedArticleDTO() {

    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getFormattedData() {
        return id;
    }

    public String getFormattedData1() {
        return title;
    }
}
