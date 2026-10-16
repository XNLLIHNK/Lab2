package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BonusEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "batch_id")
    private RecyclingBatch batch;

    private Integer points; // количество баллов
    private String status;  // статус начисления
}