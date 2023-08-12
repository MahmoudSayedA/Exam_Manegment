package com.projects.exam_management.Question;

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
@Table(name = "question")
public class Question {
    @Id
    private Long id;
    private String problem;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @OneToOne
    private Course course;
    @OneToOne
    private Doctor doctor;





}