package com.db_clinic.db_clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db_clinic.db_clinic.entity.Medicine;
import com.db_clinic.db_clinic.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService{
   
    @Autowired
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