package com.projects.exam_management.Question;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
private QuestionRepo questionRepo;
private OptionalAnswerRepo optionalAnswerRepo;
    public int countByCourseId(int id){
        List<Question> filterExam=new ArrayList<>();
        filterExam=findAllQuestion();
        int count=0;
        for (Question exam : filterExam) {
            if(exam.getCourse().getCourseId()==id){
                count++;
            }
        }
        return count;
    }

    public int countByDoctorId(int id){
        List<Question> filterExam=new ArrayList<>();
        filterExam=findAllQuestion();
        int count=0;
        for (Question exam : filterExam) {
            if(exam.getDoctor().getDoctorId()==id){
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
        cur.setLevel(question.getLevel());
        cur.setDoctor(question.getDoctor());
        cur.setOptions(question.getOptions());
        cur.setType(question.getType());
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

    public QuestionDTO updateOptional(int id,OptionalAnswer old,OptionalAnswer news){
        Question optionalAnswer=new Question();
        optionalAnswer=questionRepo.findById(id).orElseThrow();
        optionalAnswer.setOptions(news.getQestion().getOptions());
       return QuestionDTO.toDTO(questionRepo.save(optionalAnswer));
    }
    public OptionalAnswer addOptional(int questionId,OptionalAnswer optionalAnswer){
        Optional<Question> optionals=questionRepo.findById(questionId);
        ArrayList<OptionalAnswer>listOptional= optionals.orElseThrow().getOptions();
        listOptional.add(optionalAnswer);
        optionals.orElseThrow().setOptions(listOptional);
        return optionalAnswer;

    }
    public boolean deleteOption(int questionId,OptionalAnswer optionalAnswer){
        Optional<Question> optionals=questionRepo.findById(questionId);
       List<OptionalAnswer>listOptional= optionals.orElseThrow().getOptions();
        for (OptionalAnswer answer : listOptional) {
            if(answer.getId()==questionId){
                optionalAnswerRepo.delete(answer);
                return true;
            }
        }
        return false;
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
