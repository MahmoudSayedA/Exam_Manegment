package com.projects.exam_management.Question;

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
    private String problem;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private Course course;
    private Doctor doctor;
    public static QuestionDTO toDTO(Question question){
        return builder().answer(question.getAnswer()).course(question.getCourse()).doctor(question.getDoctor()).problem(question.getProblem()).option1(question.getOption1()).option2(question.getOption2()).option3(question.getOption3()).option4(question.getOption4()).build();
    }
}