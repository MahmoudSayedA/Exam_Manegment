package com.projects.exam_management.Question;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.doctor.Doctor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


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
    private  TypeQuestion typeQuestion;
    private int correctOption;
    @OneToOne(cascade = CascadeType.ALL)
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @ElementCollection
    private List<String> options;





}