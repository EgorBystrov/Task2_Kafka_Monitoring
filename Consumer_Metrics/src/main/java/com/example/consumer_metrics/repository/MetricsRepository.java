package com.example.consumer_metrics.repository;

import com.example.consumer_metrics.model.Metric;
import com.example.producer_metrics.dto.ProducerMetricsDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetricsRepository extends JpaRepository<Metric, Integer> {
    Optional<Metric> findByName(String name);
    @EntityGraph(attributePaths = {"measurementList"})
    Optional <Metric> findById(int id);

}
