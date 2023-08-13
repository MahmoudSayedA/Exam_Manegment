package com.projects.exam_management.Question;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.doctor.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Long id;
    private String problem;
    private List<String> options=new ArrayList<>();
    private TypeQuestion typeQuestion;
    private int correctOption;
    private int courseId;
    private int doctorId;
    private LevelQuestion levelQuestion;
    public static QuestionDTO toDTO(Question question){
        return QuestionDTO.builder()
                .id(question.getId())
                .problem(question.getProblem())
                .options(question.getOptions())
                .typeQuestion(question.getTypeQuestion())
                .correctOption(question.getCorrectOption())
                .courseId(question.getCourse().getCourseId())
                .doctorId(question.getDoctor().getDoctorId())
                .levelQuestion(question.getLevelQuestion())
                .build();
    }
}