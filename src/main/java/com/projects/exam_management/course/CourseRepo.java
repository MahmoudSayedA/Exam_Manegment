package com.projects.exam_management.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer>{
    List<Course> findByDoctorDoctorId(int id);
}
