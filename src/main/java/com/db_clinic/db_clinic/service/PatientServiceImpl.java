package com.db_clinic.db_clinic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db_clinic.db_clinic.entity.Patient;
import com.db_clinic.db_clinic.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
    
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}