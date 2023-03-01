package Question;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.doctor.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Long id;
    private String problem;
    private String answer;
    private questionLevel level;
    private QuestionType type;
    private Course course;
    private Doctor doctor;
    private ArrayList<OptionalAnswer> options;
    public static QuestionDTO toDTO(Question question){
        return builder().answer(question.getAnswer()).id(question.getId()).level(question.getLevel()).course(question.getCourse()).doctor(question.getDoctor()).options(question.getOptions()).problem(question.getProblem()).type(question.getType()).build();
    }
}
