package sharipov.uz.learningcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sharipov.uz.learningcentre.entity.Teacher;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("select distinct t from Teacher t " +
            "JOIN FETCH t.groups g " +
            "JOIN FETCH g.students " +
            "where t.id = :id")
    Optional<Teacher> findTeacherById(@Param("id") Integer id);
}
