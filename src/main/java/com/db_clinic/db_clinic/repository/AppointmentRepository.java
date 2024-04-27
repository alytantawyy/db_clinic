package com.db_clinic.db_clinic.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db_clinic.db_clinic.entity.Appointment;
import com.db_clinic.db_clinic.entity.Doctor;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    

    
    
}