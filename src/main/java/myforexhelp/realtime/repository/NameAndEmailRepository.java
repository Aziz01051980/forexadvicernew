package myforexhelp.realtime.repository;

import myforexhelp.realtime.domain.NameAndEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameAndEmailRepository extends JpaRepository<NameAndEmail, Long> {
}
