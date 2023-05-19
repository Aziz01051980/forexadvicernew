package myforexhelp.realtime.Domain;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "email_and_nane")
public class NameAndEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
}
