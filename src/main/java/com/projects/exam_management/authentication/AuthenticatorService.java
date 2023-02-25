package com.projects.exam_management.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam_management.doctor.Doctor;
import com.projects.exam_management.doctor.DoctorDTO;
import com.projects.exam_management.doctor.DoctorService;

@Service
public class AuthenticatorService {
    @Autowired
    DoctorService doctorService;
    
    public boolean signIn(String email, String password){
        Doctor doctorDTO =doctorService.findByEmail(email);
        if(doctorDTO==null)
            return false;
        if(!doctorDTO.getPassword().equals(password))
            return false;

        return true;
    }
    
    public boolean register(Doctor doctor){
        if(this.doctorService.validToBeStored(doctor)){
            if(!(this.doctorService.add(doctor) == null))
                return true;
        }
        return false;
    }

}