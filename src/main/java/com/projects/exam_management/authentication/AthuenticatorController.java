package com.projects.exam_management.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.exam_management.doctor.DoctorDTO;

@RestController
public class AthuenticatorController {
    @Autowired
    private AuthenticatorService authenticator;

    @PostMapping("/login")
    public Boolean signIn(@RequestParam("email")String email,@RequestParam("password") String password){
        return this.authenticator.signIn(email, password);
    }
    @PostMapping("/register")
    public boolean register(@RequestBody DoctorDTO doctorDTO){
        return this.authenticator.register(doctorDTO);
    }
}
