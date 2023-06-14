package myforexhelp.realtime.domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class Article<L extends Number, S> {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        private String title;
        private String description;
        private String content;
}








