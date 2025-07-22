package sharipov.uz.learningcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sharipov.uz.learningcentre.entity.Student;
@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer> {

}
