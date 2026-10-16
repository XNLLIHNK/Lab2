package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class CollectionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;      // адрес
    private Boolean isAvailable; // доступность
    private Double dailyLimit;   // суточный лимит массы

    @ManyToMany
    @JoinTable(
            name = "point_accepted_types",
            joinColumns = @JoinColumn(name = "point_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private List<RecyclingType> acceptedTypes; // принимаемые виды
}