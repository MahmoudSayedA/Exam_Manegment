package com.projects.exam_management.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{id}")
    public DoctorDTO findByDoctorId(@PathVariable("id") int id) {
        return this.doctorService.findByDoctorId(id);
    }
    @PostMapping("/add")
    public DoctorDTO add(@RequestBody DoctorDTO doctorDTO) {
        return this.doctorService.add(doctorDTO);
    }
    @PostMapping("/update")
    public DoctorDTO udpdate(@RequestBody DoctorDTO doctorDTO) {
        return this.doctorService.udpdate(doctorDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        this.doctorService.deleteById(id);
    }
    @GetMapping("")
    public List<Doctor> findAll(){
        return this.doctorService.findAll();
    }
}
