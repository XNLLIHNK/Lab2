package com.example.lab2.service;

import com.example.lab2.model.RecyclingBatch;
import com.example.lab2.repository.RecyclingBatchRepository;
import com.example.lab2.repository.BonusEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecyclingBatchService {

    @Autowired
    private RecyclingBatchRepository batchRepository;

    @Autowired
    private BonusEntryRepository bonusEntryRepository;

    public List<RecyclingBatch> findAll() {
        return batchRepository.findAll();
    }

    public RecyclingBatch findById(Long id) {
        return batchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RecyclingBatch not found with id: " + id));
    }

    public RecyclingBatch create(RecyclingBatch batch) {
        // Дата приёма устанавливается в @PrePersist самой сущности
        return batchRepository.save(batch);
    }

    public RecyclingBatch update(Long id, RecyclingBatch batchDetails) {
        RecyclingBatch batch = findById(id);
        if (batchDetails.getMass() != null) batch.setMass(batchDetails.getMass());
        if (batchDetails.getStatus() != null) batch.setStatus(batchDetails.getStatus());
        if (batchDetails.getUser() != null) batch.setUser(batchDetails.getUser());
        if (batchDetails.getPoint() != null) batch.setPoint(batchDetails.getPoint());
        if (batchDetails.getType() != null) batch.setType(batchDetails.getType());
        // Дату менять нельзя
        return batchRepository.save(batch);
    }

    @Transactional
    public void delete(Long id) {
        // Удаляем связанные бонусные записи, чтобы не осталось "висячих" ссылок
        bonusEntryRepository.findAll().stream()
                .filter(entry -> entry.getBatch() != null && entry.getBatch().getId().equals(id))
                .forEach(entry -> bonusEntryRepository.delete(entry));

        batchRepository.deleteById(id);
    }
}