package com.projects.exam_management.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public CourseDTO findById(int id) {
        return CourseDTO.toDTO(this.courseRepo.findById(id).orElseThrow());
    }

    public List<CourseDTO> findAll() {
        return CourseDTO.toDTO(this.courseRepo.findAll());
    }

    public CourseDTO update(Course course) {
        return CourseDTO.toDTO(this.courseRepo.save(course));
    }

    public CourseDTO add(Course course) {
        return goodToBeSaved(course) ? CourseDTO.toDTO(this.courseRepo
                .save(course)) : null;
    }

    public String deleteById(int id) {
        this.courseRepo.deleteById(id);
        return "deleted";
    }
    public String deleteByDoctorId(int id) {
        this.courseRepo.deleteByDoctorId(id);
        return "deleted";
    }


    private boolean goodToBeSaved(Course courseDTO) {
        if (courseDTO.getCourseName().length() < 2)
            return false;
        return true;
    }
}
