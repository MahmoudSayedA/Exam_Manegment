package com.projects.exam_management.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("")
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
    @GetMapping("/{id}")
    public QuestionDTO findQuestionById(@PathVariable int id){
        return questionService.findByQuestionId(id);
    }
    @GetMapping("/findByCourseId/{id}")
    public List<Question> findByCourseId(@PathVariable int id){
        return questionService.findAllByCourseId(id);
    }
    @GetMapping("/{levelQuestion}")
    public List<Question> listQuestionByLevel(@PathVariable String levelQuestion){
        return questionService.findAllByLevelQuestion(levelQuestion);
    }

    @PostMapping("/insert")
    public QuestionDTO insert(@RequestBody QuestionDTO question) {
        return questionService.add(question);
    }

    @PutMapping("/updateQuestion")
    public QuestionDTO updateQuestion(@RequestBody Question question) {
        return questionService.update(question);
    }

    @DeleteMapping("/{id}")
    public boolean deleteByQuestionId(@PathVariable int id){
        return questionService.deleteByQuestionId(id);
    }


    @PostMapping("/addOption/{id}")
    public List<String> addOption(@PathVariable List<String> options, @PathVariable int id){
        return questionService.addOptional(id,options);
    }

    @DeleteMapping("/deleteOption/{id}")
    public boolean deleteOption(@PathVariable int id){
        return questionService.deleteOptional(id);
    }

    @PutMapping("/{id}")
    public QuestionDTO updateOption(@PathVariable List<String>options ,@PathVariable int id){
        return questionService.updateOptional(id,options);
    }







}