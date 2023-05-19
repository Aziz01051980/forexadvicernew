package myforexhelp.realtime.Domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class Article<L extends Number, S> {

//        @Override
//        public boolean equals(Object o) {
//                if (this == o) return true;
//                if (o == null || getClass() != o.getClass()) return false;
//                Article article = (Article) o;
//                return Objects.equals(id, article.id);
//        }
//
//        @Override
//        public int hashCode() {
//                return Objects.hash(id);
//        }

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        private String title;
        private String description;
        private String content;
}








