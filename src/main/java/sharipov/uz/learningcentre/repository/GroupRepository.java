package sharipov.uz.learningcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sharipov.uz.learningcentre.entity.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
