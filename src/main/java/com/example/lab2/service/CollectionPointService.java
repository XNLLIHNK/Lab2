package com.example.lab2.service;

import com.example.lab2.model.CollectionPoint;
import com.example.lab2.repository.CollectionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionPointService {

    @Autowired
    private CollectionPointRepository pointRepository;

    public List<CollectionPoint> findAll() {
        return pointRepository.findAll();
    }

    public CollectionPoint findById(Long id) {
        return pointRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CollectionPoint not found with id: " + id));
    }

    public CollectionPoint create(CollectionPoint point) {
        return pointRepository.save(point);
    }

    public CollectionPoint update(Long id, CollectionPoint pointDetails) {
        CollectionPoint point = findById(id);
        if (pointDetails.getAddress() != null) point.setAddress(pointDetails.getAddress());
        if (pointDetails.getIsAvailable() != null) point.setIsAvailable(pointDetails.getIsAvailable());
        if (pointDetails.getDailyLimit() != null) point.setDailyLimit(pointDetails.getDailyLimit());
        if (pointDetails.getAcceptedTypes() != null) point.setAcceptedTypes(pointDetails.getAcceptedTypes());
        return pointRepository.save(point);
    }

    public void delete(Long id) {
        pointRepository.deleteById(id);
    }
}