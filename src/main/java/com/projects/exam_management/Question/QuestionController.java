package com.projects.exam_management.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/findAll")
    public List<Question> findAll(){
        return questionService.findAllQuestion();
    }
    @GetMapping("/countByCourse/{id}")
    public long countByCourseId(@PathVariable int id){
        return questionService.countByCourseId(id);
    }
    @GetMapping("/countByDoctor/{id}")
    public int countByDoctorId(@PathVariable int id){
        return questionService.countByDoctorId(id);
    }
    @GetMapping("/findQuestionBy/{id}")
    public QuestionDTO findQuestionById(@PathVariable int id){
        return questionService.findByQuestionId(id);
    }
    @GetMapping("/findByCourseId/{id}")
    public List<Question> findByCourseId(@PathVariable int id){
        return questionService.findAllByCourseId(id);
    }

    @PostMapping("/insert")
    public QuestionDTO insert(@RequestBody Question question) {
        return questionService.add(question);
    }

    @PostMapping("/updateQuestion")
    public QuestionDTO updateQuestion(@RequestBody Question question) {
        return questionService.update(question);
    }

    @PostMapping("/deleteByQuestion/{id}")
    public boolean deleteByQuestionId(@PathVariable int id){
        return questionService.deleteByQuestionId(id);
    }


//add option
    @PostMapping("/addOption/{id}")
    public List<String> addOption(@PathVariable List<String> options, @PathVariable int id){
        return questionService.addOptional(id,options);
    }

    @PostMapping("/deleteOption/{id}")
    public boolean deleteOption(@PathVariable List<String> options,@PathVariable int id){
        return questionService.deleteOption(id,options);
    }

    @PostMapping("/updateOption/{id}")
    public QuestionDTO updateOption(@PathVariable List<String>options ,@PathVariable int id){
        return questionService.updateOptional(id,options);
    }







}