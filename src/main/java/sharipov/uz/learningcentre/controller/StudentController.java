package sharipov.uz.learningcentre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sharipov.uz.learningcentre.dto.ApiResponse;
import sharipov.uz.learningcentre.dto.StudentDto;
import sharipov.uz.learningcentre.entity.Student;
import sharipov.uz.learningcentre.service.StudentService;

@RestController
@RequestMapping("/api/admin/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addEditStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.addStudent(studentDto);
        return ResponseEntity.ok(new ApiResponse(true, "Student added!", student));
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity getAllStudents() {
        studentService.getAllStudents();
        return ResponseEntity.ok(new ApiResponse(true, "All students", studentService.getAllStudents()));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {}
}
