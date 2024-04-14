package com.db_clinic.db_clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.db_clinic.db_clinic.entity.Medicine;
import com.db_clinic.db_clinic.service.MedicineService;

public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable Long id) {
        return medicineService.getMedicineById(id);
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.saveMedicine(medicine);
    }

    @PutMapping("/{id}")
    public Medicine updateMedicine(@PathVariable Long id, @RequestBody Medicine updatedMedicine) {
        Medicine medicine = medicineService.getMedicineById(id);
        if (medicine == null) {
            // Handle medicine not found
            return null;
        }

        // Update medicine attributes if provided in updatedMedicine
        if (updatedMedicine.getName() != null) {
            medicine.setName(updatedMedicine.getName());
        }
        if (updatedMedicine.getManufacturer() != null) {
            medicine.setManufacturer(updatedMedicine.getManufacturer());
        }
        if (updatedMedicine.getPrice() != 0) {
            medicine.setPrice(updatedMedicine.getPrice());
        }
        if (updatedMedicine.getQuantity() != 0) {
            medicine.setQuantity(updatedMedicine.getQuantity());
        }

        return medicineService.saveMedicine(medicine);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
    }
    
}