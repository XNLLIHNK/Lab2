package com.example.lab2.controller;

import com.example.lab2.model.RecyclingType;
import com.example.lab2.service.RecyclingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-types")
public class RecyclingTypeController {

    @Autowired
    private RecyclingTypeService typeService;

    @GetMapping
    public ResponseEntity<List<RecyclingType>> getAll() {
        return ResponseEntity.ok(typeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingType> getById(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RecyclingType> create(@RequestBody RecyclingType type) {
        return ResponseEntity.status(HttpStatus.CREATED).body(typeService.create(type));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecyclingType> update(@PathVariable Long id, @RequestBody RecyclingType typeDetails) {
        return ResponseEntity.ok(typeService.update(id, typeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}