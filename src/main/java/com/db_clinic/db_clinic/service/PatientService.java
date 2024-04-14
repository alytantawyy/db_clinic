package com.db_clinic.db_clinic.service;

import java.util.List;

import com.db_clinic.db_clinic.entity.Patient;

public interface PatientService {

    Patient savePatient(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    void deletePatient(Long id);
    
}