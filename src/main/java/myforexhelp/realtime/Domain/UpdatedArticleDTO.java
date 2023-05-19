package myforexhelp.realtime.Domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
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

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle(){
//        return title;
//    }
//
//    public String getDescription(){
//        return description;
//    }
//
//    public String getContent(){
//        return content;
//    }


}
