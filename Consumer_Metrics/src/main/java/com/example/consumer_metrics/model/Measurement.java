package com.example.consumer_metrics.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "measurements", schema = "public")
public class Measurement {

    public Measurement(String statistic, BigDecimal value) {
        this.statistic = statistic;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "statistic")
    private String statistic;
    @Column(name = "value")
    private BigDecimal value;
    @ManyToOne
    @JoinColumn(name = "metrics_id", referencedColumnName = "id")
    private Metric metric;
}

