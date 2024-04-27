package com.db_clinic.db_clinic.service;

import java.time.LocalDateTime;
import java.util.List;

import com.db_clinic.db_clinic.entity.Appointment;
import com.db_clinic.db_clinic.entity.Doctor;

public interface AppointmentService {
    
    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    void deleteAppointment(Long id);

   

}