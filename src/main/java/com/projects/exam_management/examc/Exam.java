package com.projects.exam_management.examc;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.course.CourseDTO;
import com.projects.exam_management.doctor.Doctor;
import com.projects.exam_management.doctor.DoctorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  examURL;
    private ExamType examType;
    private int grade;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Doctor doctor;



}
