package com.db_clinic.db_clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db_clinic.db_clinic.entity.Patient;
import com.db_clinic.db_clinic.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            // Handle patient not found
            return null;
        }

        // Update patient attributes if provided in updatedPatient
        if (updatedPatient.getName() != null) {
            patient.setName(updatedPatient.getName());
        }
        if (updatedPatient.getAge() != null) {
            patient.setAge(updatedPatient.getAge());
        }
        if (updatedPatient.getGender() != null) {
            patient.setGender(updatedPatient.getGender());
        }
        if (updatedPatient.getContactNumber() != null) {
            patient.setContactNumber(updatedPatient.getContactNumber());
        }
        if (updatedPatient.getDoctor() != null) {
            patient.setDoctor(updatedPatient.getDoctor());
        }

        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
    
}