package com.db_clinic.db_clinic.service;

import java.util.List;

import com.db_clinic.db_clinic.entity.Medicine;
import com.db_clinic.db_clinic.repository.MedicineRepository;

public class MedicineServiceImpl implements MedicineService{
   
    private MedicineRepository medicineRepository;

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
}