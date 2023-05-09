package com.projects.exam_management.Question;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.doctor.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

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
    private questionLevel level;
    private QuestionType type;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Doctor doctor;
    @OneToMany
    private ArrayList<OptionalAnswer> options;




}
