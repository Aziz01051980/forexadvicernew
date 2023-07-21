package myforexhelp.realtime.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "my_all_articles")
public class ArticleDTO {
    @Id
    private Long id;
    private String title;

    private String description;

    public ArticleDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public ArticleDTO() {

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

    public String getFormattedData2() {
        return description;
    }
}

