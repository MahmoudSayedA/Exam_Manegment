package com.projects.exam_management.examc;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.doctor.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {
    private int exam_id;
    private String exam_URL;
    private int grade;
    private Doctor doctor;
    private Course course;
    private ExamType examType;
    public static ExamDTO toDTO(Exam exam){
     return builder().exam_id(Math.toIntExact(exam.getId())).grade(exam.getGrade()).exam_URL(exam.getExamURL()).examType(exam.getExamType()).build();
    }

}
