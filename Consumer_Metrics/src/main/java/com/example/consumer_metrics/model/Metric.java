package com.example.consumer_metrics.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "metrics", schema = "public")
public class Metric {
    public Metric(String name, String description, String baseUnit) {
        this.name = name;
        this.description = description;
        this.baseUnit = baseUnit;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "base_unit")
    private String baseUnit;
    @OneToMany(mappedBy = "metric", cascade = CascadeType.ALL)
    private List<Measurement> measurementList;
}
