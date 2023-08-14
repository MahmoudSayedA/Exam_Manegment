package com.projects.exam_management.doctor;

import java.util.List;
import java.util.Optional;

import com.projects.exam_management.Error.RecordNotFondException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam_management.course.CourseService;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    CourseService courseService;

    public Doctor findByEmail(String email) {
        return this.doctorRepo.findByEmail(email).orElse(null);
    }

    public DoctorDTO findByDoctorId(int id) {
        Optional<Doctor> entity= this.doctorRepo.findById(id);
        if(entity.isPresent())
            return DoctorDTO.toDTO(entity.get());
        else throw new RecordNotFondException("Doctor with id: "+id+" not found");
    }

    public DoctorDTO add(Doctor doctorDTO) {
        return DoctorDTO.toDTO(this.doctorRepo.save(doctorDTO));
    }

    public DoctorDTO udpdate(Doctor doctorDTO) {
        return DoctorDTO.toDTO(this.doctorRepo.save(doctorDTO));
    }

    public void deleteById(int id){

        if(!this.doctorRepo.existsById(id))
            throw new RecordNotFondException("Doctor with id: "+id+" not found");
        this.doctorRepo.deleteById(id);
        courseService.deleteByDoctorId(id);
    }
    
    public boolean validToBeStored(Doctor doctor){
        if(countByEmail(doctor.getEmail())>0){
           throw  new RecordNotFondException("Doctor with email: "+doctor.getEmail()+" already exists");
        }
        if(doctor.getEmail() == null || !doctor.getEmail().contains("@"))
            return false;
        if(doctor.getPassword() == null || doctor.getPassword().length() < 3)
            return false;
        if(doctor.getFirstName()== null || doctor.getLastName()== null)
            return false;

        return true;

    }

    public int countByEmail(String email){
        List<Doctor> doctor = this.doctorRepo.findAll();
        int count = 0;
        for(Doctor d: doctor){
            if(d.getEmail().equals(email))
                count++;
        }
        return count;

    }


    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }


}
