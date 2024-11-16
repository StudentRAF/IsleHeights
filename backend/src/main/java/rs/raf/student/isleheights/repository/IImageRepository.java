package rs.raf.student.isleheights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.raf.student.isleheights.entity.Image;

import java.util.Optional;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByName(String name);

}
