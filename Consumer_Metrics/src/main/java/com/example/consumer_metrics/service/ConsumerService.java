package com.example.consumer_metrics.service;

import com.example.consumer_metrics.dto.MetricNameDto;
import com.example.consumer_metrics.model.Metric;
import com.example.producer_metrics.dto.ProducerMetricsDto;

import java.util.List;
import java.util.Optional;

public interface ConsumerService {
    void saveOrUpdateMetric(ProducerMetricsDto producerMetricsDto);
    List<MetricNameDto> getMetricNamesList();
    ProducerMetricsDto getMetricById(int id);
}
