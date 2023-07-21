package myforexhelp.realtime.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "my_all_articles")
public class Article<L extends Number, S> {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String description;
        private String content;
}








