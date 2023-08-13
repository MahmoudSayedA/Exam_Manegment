package com.projects.exam_management.exam;

import com.projects.exam_management.Question.Question;
import com.projects.exam_management.Question.QuestionRepo;
import com.projects.exam_management.course.Course;
import com.projects.exam_management.course.CourseRepo;
import com.projects.exam_management.course.CourseService;
import com.projects.exam_management.doctor.Doctor;
import com.projects.exam_management.doctor.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepo examRepo;
    @Autowired
    private QuestionRepo questionRepo;


    public int countByCourseId(int id){
        List<Exam> filterExam=new ArrayList<>();
        filterExam=findAllExam();
        int count=0;
        for (Exam exam : filterExam) {
            if(exam.getCourse().getCourseId()==id){
                count++;
            }
        }
        return count;
    }

    public int countByDoctorId(int id){
        List<Exam> filterExam=new ArrayList<>();
        filterExam=findAllExam();
        int count=0;
        for (Exam exam : filterExam) {
            if(exam.getDoctor().getDoctorId()==id){
                count++;
            }
        }
        return count;
    }
    public Exam findByExamUrl(Long id){
        return examRepo.findById(id).orElseThrow();
    }
    public Exam findExamById(long id){
        return examRepo.findById(id).orElseThrow();
    }
    public Exam findByCourseId(long id){
        for (Exam exam : examRepo.findAll()) {
            if(exam.getCourse().getCourseId()==id){
                return exam;
            }
        }

        return null;
    }
    public Exam addExam(Exam exam){
        List<Question> listQuestion=exam.getQuestions();
        List<Question> NewList=new ArrayList<>();
        for (Question question : listQuestion) {
            NewList.add(questionRepo.findById(Math.toIntExact(question.getId())).orElseThrow());
        }
        exam.setQuestions(NewList);
        examRepo.save(exam);
        return exam;

    }


    public Boolean deleteByQuestionId(long id){

                if(examRepo.findById(id).orElseThrow()==null){
                    return false;
                }else {
                    return true;
                }
    }

    public List<Exam> findAllExamByExamType(String examType){
        List<Exam> listExam=new ArrayList<>();
        List<Exam> allExam=this.findAllExam();
        for (Exam exam : allExam) {
            if(exam.getExamType().toString().equals(examType.toUpperCase())){
                listExam.add(exam);
            }
        }
        return listExam;
    }

    public Exam createExam(Exam exam,int NumberOfEasyQuestion,int NumberOfMediumQuestion,int NumberOfHardQuestion){
        List<Question> listQuestion=new ArrayList<>();
        List<Question> allQuestion=questionRepo.findAll();
        for (Question question : allQuestion) {
            if(question.getLevelQuestion().toString().equals("EASY")){
                listQuestion.add(question);
                NumberOfEasyQuestion--;
            }
            if(question.getLevelQuestion().toString().equals("MEDIUM")){
                listQuestion.add(question);
                NumberOfMediumQuestion--;
            }
            if(question.getLevelQuestion().toString().equals("HARD")){
                listQuestion.add(question);
                NumberOfHardQuestion--;
            }
            if(NumberOfEasyQuestion==0 && NumberOfMediumQuestion==0 && NumberOfHardQuestion==0){
                break;
            }
        }
        exam.setQuestions(listQuestion);
        examRepo.save(exam);
        return exam;
    }





    public List<Exam> findAllExam(){
        return examRepo.findAll();
    }

}
