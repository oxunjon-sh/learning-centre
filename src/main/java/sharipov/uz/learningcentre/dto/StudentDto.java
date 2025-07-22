package sharipov.uz.learningcentre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;
@Data
public class StudentDto {

    private Integer id;

    @NotBlank(message = "F.I.O kiritilishi shart!")
    private String fullName;

    @Positive(message = "Sinf xato")
    private Integer clas;

    private Boolean isActive;

    @NotBlank(message = "Shart")
    private String parentPhone;

    @NotBlank(message = "Shart")
    private String phoneNumber;
    private List<Integer> groupIds;
}
