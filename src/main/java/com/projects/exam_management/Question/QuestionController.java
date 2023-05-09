package com.projects.exam_management.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/countByCourseId")
    public long countByCourseId(@PathVariable int id){
        return questionService.countByCourseId(id);
    }
    @GetMapping("/countByDoctorId")
    public int countByDoctorId(@PathVariable int id){
        return questionService.countByDoctorId(id);
    }
    @GetMapping("findQuestionById")
    public QuestionDTO findQuestionById(@PathVariable int id){
        return questionService.findByQuestionId(id);
    }


}
