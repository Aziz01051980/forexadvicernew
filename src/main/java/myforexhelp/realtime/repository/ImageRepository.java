package myforexhelp.realtime.repository;

import myforexhelp.realtime.domain.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {

    default Optional<Images> findByName(String fileName) {
        return null;
    }
}



