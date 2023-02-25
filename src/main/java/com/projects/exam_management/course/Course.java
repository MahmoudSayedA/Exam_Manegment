package com.projects.exam_management.course;

import java.util.Date;

import com.projects.exam_management.doctor.Doctor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @SequenceGenerator(
        name = "course_sequence",
        sequenceName = "course_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "course_sequence",
        strategy = GenerationType.SEQUENCE
    )
    @Column(
        name = "course_id",
        updatable = false
    )
    private int courseId;
    @Column(
        name = "name",
        nullable = false
    )
    private String courseName;
    @Column(
        name = "date",
        nullable = false
    )
    private Date date;
    @ManyToOne
    @JoinColumn(
        name = "doctor_id"
    )
    // @Cascade(
    //     CascadeType.PERSIST
    // )
    private Doctor doctor;

    public static Course toEntity(CourseDTO course){
        return builder()
        .courseId(course.getCourseId())
        .courseName(course.getCourseName())
        .date(course.getDate())
        .doctor(Doctor.toEntity(course.getDoctor()))
        .build();
    }
}
