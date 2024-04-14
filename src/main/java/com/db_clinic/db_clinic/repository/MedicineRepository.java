package com.db_clinic.db_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db_clinic.db_clinic.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    
}