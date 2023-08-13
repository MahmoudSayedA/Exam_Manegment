package com.projects.exam_management.exam;

import com.projects.exam_management.Question.Question;
import com.projects.exam_management.Question.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExamService examService;
    @Autowired
    private QuestionRepo questionRepo;

    public ExamController(ExamService examService){
        this.examService = examService;
    }
    @GetMapping("/findAll")
    public List<Exam> findAll(){
        return examService.findAllExam();
    }
    @GetMapping("/countByCourseId/{id}")
    public int countByCourseId(@PathVariable int id){
        return examService.countByCourseId(id);
    }

    @GetMapping("/countByDoctorId/{id}")

    public int countByDoctorId(@PathVariable int id){
        return examService.countByDoctorId(id);
    }

    @GetMapping("/findByExamUrl/{id}")

    public Exam findByExamUrl(@PathVariable long id){
        return examService.findByExamUrl(id);
    }

    @GetMapping("/findExamId/{id}")
    public Exam findExamId(@PathVariable int id ){
        return examService.findExamById(id);
    }

    @GetMapping("/findByCourseId/{id}")
    public Exam findByCourseId(@PathVariable long id){
        return examService.findByCourseId(id);
    }
    @GetMapping("/findAllExamByExamType/{examType}")
    public List<Exam> findAllExamByExamType(@PathVariable String examType){
        return examService.findAllExamByExamType(examType);
    }
    @PostMapping("/insert")
    public Exam insert(@RequestBody Exam exam) {
        return examService.addExam(exam);
    }
    @PostMapping("/deleteByQuestionId")
    public boolean deleteByQuestionId(@PathVariable int id){
        return examService.deleteByQuestionId(id);
    }



}
