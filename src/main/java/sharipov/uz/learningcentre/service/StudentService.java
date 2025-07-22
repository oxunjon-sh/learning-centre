package sharipov.uz.learningcentre.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sharipov.uz.learningcentre.StudentMapper;
import sharipov.uz.learningcentre.dto.StudentDto;
import sharipov.uz.learningcentre.entity.Group;
import sharipov.uz.learningcentre.entity.Student;
import sharipov.uz.learningcentre.repository.GroupRepository;
import sharipov.uz.learningcentre.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final StudentMapper studentMapper;


    public Student addStudent(StudentDto studentDto) {

        List<Group> groups = groupRepository.findAll();
         Student student = studentMapper.toStudent(studentDto,groups);
        studentRepository.save(student);
        return student;
    }

    public List<StudentDto> getAllStudents() {
       return studentRepository.findAll()
               .stream()
               .map(studentMapper::toStudentDto)
               .toList();
    }
}

