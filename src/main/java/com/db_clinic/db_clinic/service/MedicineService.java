package com.db_clinic.db_clinic.service;

import java.util.List;

import com.db_clinic.db_clinic.entity.Medicine;

public interface MedicineService {
    
    Medicine saveMedicine(Medicine medicine);

    List<Medicine> getAllMedicines();

    Medicine getMedicineById(Long id);

    void deleteMedicine(Long id);
}