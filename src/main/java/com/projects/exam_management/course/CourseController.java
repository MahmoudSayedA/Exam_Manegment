package com.projects.exam_management.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public CourseDTO findByID(@PathVariable("id")int id) {
        return this.courseService.findById(id);
    }
    @GetMapping("")
    public List<CourseDTO> findAll() {
        return this.courseService.findAll();
    }
    @PutMapping("/update")
    public CourseDTO update(@RequestBody Course course) {
        return this.courseService.update(course);
    }
    @PostMapping("/add")
    public CourseDTO add(@RequestBody Course course) {
        return this.courseService.add(course);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id")int id) {
        return this.courseService.deleteById(id);
    }

}
