package com.projects.exam_management.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo doctorRepo;

    public Doctor findByEmail(String email) {
        return this.doctorRepo.findByEmail(email).orElse(null);
    }

    public DoctorDTO findByDoctorId(int id) {
        return DoctorDTO.toDTO(this.doctorRepo.findById(id).orElseThrow());
    }

    public DoctorDTO add(Doctor doctorDTO) {
        return DoctorDTO.toDTO(this.doctorRepo.save(doctorDTO));
    }

    public DoctorDTO udpdate(Doctor doctorDTO) {
        return DoctorDTO.toDTO(this.doctorRepo.save(doctorDTO));
    }

    public void deleteById(int id){
        this.doctorRepo.deleteById(id);
    }
    
    public boolean validToBeStored(Doctor doctor){
        if(doctor.getEmail() == null || !doctor.getEmail().contains("@"))
            return false;
        if(doctor.getPassword() == null || doctor.getPassword().length() < 3)
            return false;
        if(doctor.getFirstName()== null || doctor.getLastName()== null)
            return false;
        return true;
    }

    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }


}
