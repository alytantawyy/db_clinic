package com.db_clinic.db_clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db_clinic.db_clinic.entity.Doctor;
import com.db_clinic.db_clinic.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            // Handle doctor not found
            return null;
        }

        if (updatedDoctor.getName() != null) {
            doctor.setName(updatedDoctor.getName());
        }
        if (updatedDoctor.getSpecialization() != null) {
            doctor.setSpecialization(updatedDoctor.getSpecialization());
        }
        if (updatedDoctor.getContactNumber() != null) {
            doctor.setContactNumber(updatedDoctor.getContactNumber());
        }

        return doctorService.saveDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
    
}