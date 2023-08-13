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
    public QuestionDTO findByQuestionId(int id){
        return QuestionDTO.toDTO(questionRepo.findById(id).orElseThrow());
    }

    public QuestionDTO add(QuestionDTO questionDTO){
            // Fetch Course and Doctor entities by their IDs

        Course course = courseRepo.findById(questionDTO.getCourseId()).orElseThrow(/* handle not found */);
            Doctor doctor = doctorRepo.findById(questionDTO.getDoctorId()).orElseThrow(/* handle not found */);

            // Create and populate the Question entity
            Question question = Question.builder()
                    .id(questionDTO.getId())
                    .problem(questionDTO.getProblem())
                    .correctOption(questionDTO.getCorrectOption())
                    .course(course) // Associate the fetched Course entity
                    .doctor(doctor) // Associate the fetched Doctor entity
                    .options(questionDTO.getOptions())
                    .typeQuestion(questionDTO.getTypeQuestion())
                    .build();

            questionRepo.save(question); // Save the Question entity
            return QuestionDTO.toDTO(question);
    }

        public QuestionDTO update(Question question){
        Question cur=new Question();
        cur.setId(question.getId());
        cur.setCourse(question.getCourse());
        cur.setOptions(question.getOptions());
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