package com.projects.exam_management.exam;

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
    private CourseRepo courseRepo;
    @Autowired
    private DoctorRepo doctorRepo;


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
    public ExamDTO addExam(Exam exam){
        return ExamDTO.toDTO(examRepo.save(exam));

    }


    public Boolean deleteByQuestionId(long id){

                if(examRepo.findById(id).orElseThrow()==null){
                    return false;
                }else {
                    return true;
                }
    }




    public List<Exam> findAllExam(){
        return examRepo.findAll();
    }

}
