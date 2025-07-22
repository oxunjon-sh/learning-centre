package sharipov.uz.learningcentre.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sharipov.uz.learningcentre.entity.Homework;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {

    @Query("select h from Homework h where h.teacher.id= :teacherId and h.student.id = :studentId")
    List<Homework> findByTeacherIdAndStudentId(Integer teacherId, Integer studentId);


    @EntityGraph(attributePaths = {"group","teacher"})
    List<Homework> findByStudentId(Integer studentId);

    @EntityGraph(attributePaths = {"group","teacher"})
    List<Homework> findByGroupId(Integer groupId);
}
