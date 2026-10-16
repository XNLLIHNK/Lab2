package com.example.lab2.controller;

import com.example.lab2.model.BonusEntry;
import com.example.lab2.service.BonusEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bonus-entries")
public class BonusEntryController {

    @Autowired
    private BonusEntryService bonusEntryService;

    @GetMapping
    public ResponseEntity<List<BonusEntry>> getAll() {
        return ResponseEntity.ok(bonusEntryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonusEntry> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bonusEntryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BonusEntry> create(@RequestBody BonusEntry entry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bonusEntryService.create(entry));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BonusEntry> update(@PathVariable Long id, @RequestBody BonusEntry entryDetails) {
        return ResponseEntity.ok(bonusEntryService.update(id, entryDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bonusEntryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}