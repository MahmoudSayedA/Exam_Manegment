package com.projects.exam_management.exam;

import com.projects.exam_management.Question.Question;
import com.projects.exam_management.Question.QuestionDTO;
import com.projects.exam_management.course.Course;
import com.projects.exam_management.course.CourseDTO;
import com.projects.exam_management.doctor.Doctor;
import com.projects.exam_management.doctor.DoctorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {
    private Long examId;
    private String examUrl;
    private int grade;
    private ExamType examType;
    private CourseDTO course;
    private DoctorDTO doctor;
    private List<Question> questions;

    public static ExamDTO toDTO(Exam exam){
        return ExamDTO.builder()
                .examId(exam.getId())
                .examUrl(exam.getExamURL())
                .grade(exam.getGrade())
                .examType(exam.getExamType())
                .course(CourseDTO.toDTO(exam.getCourse()))
                .doctor(DoctorDTO.toDTO(exam.getDoctor()))

                .build();
    }




}
