package myforexhelp.realtime.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "my_all_articles")
public class ArticleTransferObject {
    @Id
    private Long id;
    private String title;
    private String description;
    }

