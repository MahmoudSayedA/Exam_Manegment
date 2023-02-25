package com.projects.exam_management.doctor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "doctor")
class Doctor {
    @Id
    @SequenceGenerator(
        name = "Doctor_sequence",
        sequenceName = "Doctor_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "Doctor_sequence"
        )
    @Column(
        name = "doctor_id",
        updatable = false
    )
    private Integer doctorId;
    @Column(
        name = "email", 
        nullable = false, 
        unique = true
        )
    private String email;
    @Column(
        name = "password", 
        nullable = false
        )
    private String password;
    @Column(
        name = "first_name", 
        nullable = false
        )
    private String firstName;
    @Column(
        name = "last_name", 
        nullable = false
        )
    private String lastName;

    public static Doctor toEntity(DoctorDTO doctor) {
        return doctor == null ? null
                : builder().doctorId(doctor.getDoctorId()).email(doctor.getEmail()).password(doctor.getPassword())
                        .firstName(doctor.getFirstName()).lastName(doctor.getLastName()).build();
    }
}
