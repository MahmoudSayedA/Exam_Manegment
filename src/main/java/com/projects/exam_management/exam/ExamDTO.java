package com.projects.exam_management.exam;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.course.CourseDTO;
import com.projects.exam_management.doctor.Doctor;
import com.projects.exam_management.doctor.DoctorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {
    private Long examId;
    private String examUrl;
    private int grade;
    private ExamType examType;
    private int courseId;
    private int doctorId;

    public static ExamDTO toDTO(Exam exam){
        return ExamDTO.builder()
                .examId(exam.getId())
                .examUrl(exam.getExamURL())
                .grade(exam.getGrade())
                .examType(exam.getExamType())
                .courseId(exam.getCourse().getCourseId())  // Set courseId here
                .doctorId(exam.getDoctor().getDoctorId())  // Set doctorId here
                .build();
    }



}
