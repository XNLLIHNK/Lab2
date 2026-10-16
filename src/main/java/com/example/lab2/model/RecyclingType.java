package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RecyclingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;        // название
    private String unit;        // единица учёта
    private Double pointsPerKg; // баллы за килограмм
}