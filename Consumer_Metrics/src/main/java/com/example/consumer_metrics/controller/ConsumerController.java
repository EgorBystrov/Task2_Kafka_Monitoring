package com.example.consumer_metrics.controller;

import com.example.consumer_metrics.controller.api.ConsumerControllerApi;
import com.example.consumer_metrics.dto.MetricNameDto;
import com.example.consumer_metrics.service.ConsumerService;
import com.example.producer_metrics.dto.ProducerMetricsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class ConsumerController implements ConsumerControllerApi {
    private final ConsumerService metricsService;


    @GetMapping
    public ResponseEntity<List<MetricNameDto>> getAllMetrics() {
        List<MetricNameDto> metrics = metricsService.getMetricNamesList();
        return ResponseEntity.ok(metrics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducerMetricsDto> getMetricById(@PathVariable int id) {
        ProducerMetricsDto metric = metricsService.getMetricById(id);
        return ResponseEntity.ok(metric);
    }
}
