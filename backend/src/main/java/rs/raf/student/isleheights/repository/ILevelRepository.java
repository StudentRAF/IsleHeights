package rs.raf.student.isleheights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.raf.student.isleheights.entity.Level;

import java.util.Optional;

@Repository
public interface ILevelRepository extends JpaRepository<Level, Long> {

    Optional<Level> findByName(String name);

}
