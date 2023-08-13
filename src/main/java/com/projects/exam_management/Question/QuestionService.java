package com.projects.exam_management.Question;

import com.projects.exam_management.course.Course;
import com.projects.exam_management.course.CourseRepo;
import com.projects.exam_management.course.CourseService;
import com.projects.exam_management.doctor.Doctor;
import com.projects.exam_management.doctor.DoctorDTO;
import com.projects.exam_management.doctor.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    DoctorRepo doctorRepo;



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

    public List<Question> findAllByLevelQuestion(String levelQuestion){
        List<Question> listQuestion=new ArrayList<>();
        List<Question> allQuestion=this.findAllQuestion();
        for (Question question : allQuestion) {
            if(question.getLevelQuestion().toString().equals(levelQuestion)){
                listQuestion.add(question);
            }
        }
        return listQuestion;
    }

    public QuestionDTO findByQuestionId(int id){
        return QuestionDTO.toDTO(questionRepo.findById(id).orElseThrow());
    }

    public QuestionDTO add(QuestionDTO questionDTO){
        Course course = courseRepo.findById(questionDTO.getCourseId()).orElseThrow(/* handle not found */);
            Doctor doctor = doctorRepo.findById(questionDTO.getDoctorId()).orElseThrow(/* handle not found */);
            Question question = Question.builder()
                    .id(questionDTO.getId())
                    .problem(questionDTO.getProblem())
                    .correctOption(questionDTO.getCorrectOption())
                    .course(course)
                    .doctor(doctor)
                    .options(questionDTO.getOptions())
                    .typeQuestion(questionDTO.getTypeQuestion())
                    .levelQuestion(questionDTO.getLevelQuestion())
                    .build();

            questionRepo.save(question);
            return QuestionDTO.toDTO(question);
    }

        public QuestionDTO update(Question question){
        Question cur=new Question();
        cur.setId(question.getId());
        cur.setCourse(question.getCourse());
        cur.setOptions(question.getOptions());
        cur.setDoctor(question.getDoctor());
        cur.setProblem(question.getProblem());
        cur.setTypeQuestion(question.getTypeQuestion());
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
        optionalAnswer.setOptions(options);
        return QuestionDTO.toDTO(questionRepo.save(optionalAnswer));
    }
    public List<String> addOptional(int questionId,List<String> options){
        Question optionalAnswer=new Question();
        optionalAnswer=questionRepo.findById(questionId).orElseThrow();
        optionalAnswer.setOptions(options);
        questionRepo.save(optionalAnswer);
        return options;
    }
    public boolean deleteOption(int questionId,List<String> options){
        Question optionalAnswer=new Question();
        optionalAnswer=questionRepo.findById(questionId).orElseThrow();
        optionalAnswer.setOptions(null);
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


    public boolean deleteOptional(int id) {
        Question optionalAnswer=new Question();
        optionalAnswer=questionRepo.findById(id).orElseThrow();
        optionalAnswer.setOptions(null);
        questionRepo.save(optionalAnswer);
        return true;
    }
}