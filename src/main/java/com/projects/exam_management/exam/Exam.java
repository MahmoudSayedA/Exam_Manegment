package com.projects.exam_management.exam;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.doctor.Doctor;
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
    private Long id;
    private String  examURL;
    private ExamType examType;
    private int grade;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Doctor doctor;
}
