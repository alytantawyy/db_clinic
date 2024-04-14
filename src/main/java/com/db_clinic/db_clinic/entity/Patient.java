package com.db_clinic.db_clinic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;

    private int age;

    private String gender;

    @Column(name = "contact_number")
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    
}