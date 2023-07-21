package myforexhelp.realtime.domain;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "email_and_name")
public class NameAndEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
}
