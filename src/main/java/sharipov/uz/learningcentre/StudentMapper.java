package sharipov.uz.learningcentre;

import org.springframework.stereotype.Component;
import sharipov.uz.learningcentre.dto.StudentDto;
import sharipov.uz.learningcentre.entity.Group;
import sharipov.uz.learningcentre.entity.Student;

import java.util.HashSet;
import java.util.List;

@Component
public class StudentMapper {

    public Student toStudent(StudentDto studentDto, List<Group> groups) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFullName(studentDto.getFullName());
        student.setIsActive(studentDto.getIsActive());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setParentPhone(studentDto.getParentPhone());
        student.setGroups(new HashSet<>(groups));
        return student;
    }

    public StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFullName(student.getFullName());
        studentDto.setIsActive(student.getIsActive());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setParentPhone(student.getParentPhone());
        studentDto.getGroupIds().forEach(id -> studentDto.getGroupIds().add(id));
        return studentDto;
    }
}
