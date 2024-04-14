package com.db_clinic.db_clinic.service;

import java.util.List;

import com.db_clinic.db_clinic.entity.Appointment;

public interface AppointmentService {
    
    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    void deleteAppointment(Long id);
}