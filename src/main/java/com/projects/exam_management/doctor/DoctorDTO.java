package com.projects.exam_management.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String email;

    public static DoctorDTO toDTO(Doctor doctor) {
        return doctor == null ? null
                : builder().doctorId(doctor.getDoctorId()).email(doctor.getEmail())
                        .firstName(doctor.getFirstName()).lastName(doctor.getLastName()).build();
    }


}
