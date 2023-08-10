package com.projects.exam_management.Question;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionRepo questionRepo;

    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public long countByCourseId(int id){
        List<Question> questions=new ArrayList<>();
        questions=findAllQuestion();
        long count=0;
        for (Question question : questions) {
            if(question.getCourse().getCourseId()==id){
                count++;
            }
        }
        return count;
    }

    public int countByDoctorId(int id){
        List<Question> questions=new ArrayList<>();
        questions=findAllQuestion();
        int count=0;
        for (Question question : questions) {
            if(question.getDoctor().getDoctorId()==id){
                count++;
            }
        }
        return count;
    }
    public QuestionDTO findByQuestionId(int id){
        return QuestionDTO.toDTO(questionRepo.findById(id).orElseThrow());
    }

    public QuestionDTO add(Question question){
        return QuestionDTO.toDTO(questionRepo.save(question));
    }

    public QuestionDTO update(Question question){
        Question cur=new Question();
        cur.setId(question.getId());
        cur.setCourse(question.getCourse());
        cur.setAnswer(question.getAnswer());
        cur.setOption1(question.getOption1());
        cur.setOption2(question.getOption2());
        cur.setOption3(question.getOption3());
        cur.setOption4(question.getOption4());
        cur.setDoctor(question.getDoctor());
        cur.setProblem(question.getProblem());
        return QuestionDTO.toDTO(questionRepo.save(cur));
    }
    public boolean deleteByQuestionId(int id){
        questionRepo.deleteById(id);
        if(questionRepo.findById(id)==null){
            return true;
        }else {

            return false;
        }
    }

    public QuestionDTO updateOptional(int id,List<String> options){
        Question optionalAnswer=new Question();
        optionalAnswer=questionRepo.findById(id).orElseThrow();
        optionalAnswer.setOption1(options.get(0));
        optionalAnswer.setOption2(options.get(1));
        optionalAnswer.setOption3(options.get(2));
        optionalAnswer.setOption4(options.get(3));
        return QuestionDTO.toDTO(questionRepo.save(optionalAnswer));
    }
    public List<String> addOptional(int questionId,List<String> options){
           Question optionalAnswer=new Question();
            optionalAnswer=questionRepo.findById(questionId).orElseThrow();
            optionalAnswer.setOption1(options.get(0));
            optionalAnswer.setOption2(options.get(1));
            optionalAnswer.setOption3(options.get(2));
            optionalAnswer.setOption4(options.get(3));
            questionRepo.save(optionalAnswer);
            return options;
    }
    public boolean deleteOption(int questionId,List<String> options){
        Question optionalAnswer=new Question();
        optionalAnswer=questionRepo.findById(questionId).orElseThrow();
        optionalAnswer.setOption1(null);
        optionalAnswer.setOption2(null);
        optionalAnswer.setOption3(null);
        optionalAnswer.setOption4(null);
        questionRepo.save(optionalAnswer);
        return true;
    }
    public List<Question> findAllByCourseId(int id){
        List<Question> listCourses=new ArrayList<>();
        List<Question> allQuestions=this.findAllQuestion();
        for (Question allQuestion : allQuestions) {
            if(allQuestion.getCourse().getCourseId()==id){
                listCourses.add(allQuestion);
            }
        }
        return listCourses;
    }


    public List<Question> findAllQuestion(){
        return questionRepo.findAll();
    }


}