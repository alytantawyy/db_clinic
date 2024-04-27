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

import com.db_clinic.db_clinic.entity.Appointment;
import com.db_clinic.db_clinic.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AppointmentController {
    
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        // Check appointment availability before creating
        

        return appointmentService.saveAppointment(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) {
            // Handle appointment not found
            return null;
        }

        // Update appointment attributes if provided in updatedAppointment
        if (updatedAppointment.getDoctor() != null) {
            appointment.setDoctor(updatedAppointment.getDoctor());
        }
        if (updatedAppointment.getPatient() != null) {
            appointment.setPatient(updatedAppointment.getPatient());
        }
        if (updatedAppointment.getDateTime() != null) {
            appointment.setDateTime(updatedAppointment.getDateTime());
        }
        if (updatedAppointment.getNotes() != null) {
            appointment.setNotes(updatedAppointment.getNotes());
        }

        return appointmentService.saveAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
