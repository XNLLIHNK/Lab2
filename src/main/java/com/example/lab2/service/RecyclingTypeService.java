package com.example.lab2.service;

import com.example.lab2.model.RecyclingType;
import com.example.lab2.repository.RecyclingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTypeService {

    @Autowired
    private RecyclingTypeRepository typeRepository;

    public List<RecyclingType> findAll() {
        return typeRepository.findAll();
    }

    public RecyclingType findById(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RecyclingType not found with id: " + id));
    }

    public RecyclingType create(RecyclingType type) {
        return typeRepository.save(type);
    }

    public RecyclingType update(Long id, RecyclingType typeDetails) {
        RecyclingType type = findById(id);
        if (typeDetails.getName() != null) type.setName(typeDetails.getName());
        if (typeDetails.getUnit() != null) type.setUnit(typeDetails.getUnit());
        if (typeDetails.getPointsPerKg() != null) type.setPointsPerKg(typeDetails.getPointsPerKg());
        return typeRepository.save(type);
    }

    public void delete(Long id) {
        typeRepository.deleteById(id);
    }
}