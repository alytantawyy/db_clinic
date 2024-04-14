package com.db_clinic.db_clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.db_clinic.db_clinic.entity.Appointment;
import com.db_clinic.db_clinic.repository.AppointmentRepository;

public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
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