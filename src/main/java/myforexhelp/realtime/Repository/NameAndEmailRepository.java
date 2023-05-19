package myforexhelp.realtime.Repository;

import myforexhelp.realtime.Domain.NameAndEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameAndEmailRepository extends JpaRepository<NameAndEmail, Long> {
}
