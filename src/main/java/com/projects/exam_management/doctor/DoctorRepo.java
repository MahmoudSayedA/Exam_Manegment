package com.projects.exam_management.doctor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DoctorRepo extends JpaRepository<Doctor,Integer>{
    Optional<Doctor> findByEmail(String email);
}
