package com.db_clinic.db_clinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db_clinic.db_clinic.entity.Appointment;
import com.db_clinic.db_clinic.entity.Doctor;
import com.db_clinic.db_clinic.entity.Patient;
import com.db_clinic.db_clinic.repository.AppointmentRepository;
import com.db_clinic.db_clinic.repository.DoctorRepository;
import com.db_clinic.db_clinic.repository.PatientRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        // Check if doctor with given ID exists
        Doctor doctor = appointment.getDoctor();
        if (doctor != null && doctor.getDoctorId() != null) {
            Optional<Doctor> existingDoctor = doctorRepository.findById(doctor.getDoctorId());
            if (existingDoctor.isEmpty()) {
                // Handle case where doctor does not exist
                throw new IllegalArgumentException("Doctor with ID " + doctor.getDoctorId() + " does not exist");
            }
        }

        // Check if patient with given ID exists
        Patient patient = appointment.getPatient();
        if (patient != null && patient.getPatientId() != null) {
            Optional<Patient> existingPatient = patientRepository.findById(patient.getPatientId());
            if (existingPatient.isEmpty()) {
                // Handle case where patient does not exist
                throw new IllegalArgumentException("Patient with ID " + patient.getPatientId() + " does not exist");
            }
        }

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    
}