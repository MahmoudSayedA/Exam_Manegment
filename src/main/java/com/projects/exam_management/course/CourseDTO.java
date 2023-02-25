package com.projects.exam_management.course;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import com.projects.exam_management.doctor.DoctorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private int courseId;
    private String courseName;
    private Date date;
    private DoctorDTO doctor;

    public static CourseDTO toDTO(Course course){
        return builder()
        .courseId(course.getCourseId())
        .courseName(course.getCourseName())
        .date(course.getDate())
        .doctor(DoctorDTO.toDTO(course.getDoctor()))
        .build();
    }

    public static  List<CourseDTO> toDTO(List<Course> courses){
        List<CourseDTO> dtos=new ArrayList<>();
        courses.forEach(course -> dtos.add(CourseDTO.toDTO(course)));
        return dtos;
    }



}
