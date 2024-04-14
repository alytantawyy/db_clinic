package com.db_clinic.db_clinic.service;

import java.util.List;

import com.db_clinic.db_clinic.entity.Doctor;

public interface DoctorService {

        Doctor saveDoctor(Doctor doctor);
    
        List<Doctor> getAllDoctors();
    
        Doctor getDoctorById(Long id);
    
        void deleteDoctor(Long id);
}