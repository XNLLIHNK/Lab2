package com.example.lab2.service;

import com.example.lab2.model.BonusEntry;
import com.example.lab2.repository.BonusEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusEntryService {

    @Autowired
    private BonusEntryRepository bonusEntryRepository;

    public List<BonusEntry> findAll() {
        return bonusEntryRepository.findAll();
    }

    public BonusEntry findById(Long id) {
        return bonusEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BonusEntry not found with id: " + id));
    }

    public BonusEntry create(BonusEntry entry) {
        return bonusEntryRepository.save(entry);
    }

    public BonusEntry update(Long id, BonusEntry entryDetails) {
        BonusEntry entry = findById(id);
        if (entryDetails.getPoints() != null) entry.setPoints(entryDetails.getPoints());
        if (entryDetails.getStatus() != null) entry.setStatus(entryDetails.getStatus());
        return bonusEntryRepository.save(entry);
    }

    public void delete(Long id) {
        bonusEntryRepository.deleteById(id);
    }
}