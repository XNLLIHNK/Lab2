package com.example.lab2.controller;

import com.example.lab2.model.RecyclingBatch;
import com.example.lab2.service.RecyclingBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-batches")
public class RecyclingBatchController {

    @Autowired
    private RecyclingBatchService batchService;

    @GetMapping
    public ResponseEntity<List<RecyclingBatch>> getAll() {
        return ResponseEntity.ok(batchService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingBatch> getById(@PathVariable Long id) {
        return ResponseEntity.ok(batchService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RecyclingBatch> create(@RequestBody RecyclingBatch batch) {
        // Время приёма будет установлено автоматически в сущности
        return ResponseEntity.status(HttpStatus.CREATED).body(batchService.create(batch));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecyclingBatch> update(@PathVariable Long id, @RequestBody RecyclingBatch batchDetails) {
        return ResponseEntity.ok(batchService.update(id, batchDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        batchService.delete(id);
        return ResponseEntity.noContent().build();
    }
}