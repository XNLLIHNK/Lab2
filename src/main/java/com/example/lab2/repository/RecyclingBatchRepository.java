package com.example.lab2.repository;

import com.example.lab2.model.RecyclingBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingBatchRepository extends JpaRepository<RecyclingBatch, Long> {
}