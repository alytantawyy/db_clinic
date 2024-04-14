package com.db_clinic.db_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db_clinic.db_clinic.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
}