package myforexhelp.realtime.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String user;
    private String password;

    public Admin() {
    }

    public Admin(Admin admin) {
        this.user = admin.getUser();
        this.password = admin.getPassword();
    }
}
