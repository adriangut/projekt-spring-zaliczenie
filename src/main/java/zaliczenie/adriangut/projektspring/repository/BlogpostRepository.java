package zaliczenie.adriangut.projektspring.repository;

import jakarta.transaction.Transactional;
import zaliczenie.adriangut.projektspring.model.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BlogpostRepository extends JpaRepository<Blogpost, Long> {
}