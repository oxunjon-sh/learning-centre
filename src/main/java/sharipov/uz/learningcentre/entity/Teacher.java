package sharipov.uz.learningcentre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sharipov.uz.learningcentre.enums.RoleEnum;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String phoneNumber;

    private Double salary;

    @Enumerated(EnumType.STRING)
    private RoleEnum rol=RoleEnum.TEACHER;

    @OneToMany(mappedBy = "teachers",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Group> groups;

    @OneToMany(mappedBy = "teachers")
    private List<Homework> teachingHomeworks;
}
