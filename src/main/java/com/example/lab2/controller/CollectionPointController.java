package com.example.lab2.controller;

import com.example.lab2.model.CollectionPoint;
import com.example.lab2.service.CollectionPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collection-points")
public class CollectionPointController {

    @Autowired
    private CollectionPointService pointService;

    @GetMapping
    public ResponseEntity<List<CollectionPoint>> getAll() {
        return ResponseEntity.ok(pointService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionPoint> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pointService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CollectionPoint> create(@RequestBody CollectionPoint point) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pointService.create(point));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CollectionPoint> update(@PathVariable Long id, @RequestBody CollectionPoint pointDetails) {
        return ResponseEntity.ok(pointService.update(id, pointDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pointService.delete(id);
        return ResponseEntity.noContent().build();
    }
}