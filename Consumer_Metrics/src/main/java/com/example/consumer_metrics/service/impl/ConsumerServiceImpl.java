package com.example.consumer_metrics.service.impl;

import com.example.consumer_metrics.dto.MetricNameDto;
import com.example.consumer_metrics.mapper.ConsumerMetricsDtoMapper;
import com.example.consumer_metrics.mapper.ProducerMetricsDtoMapper;
import com.example.consumer_metrics.model.Measurement;
import com.example.consumer_metrics.model.Metric;
import com.example.consumer_metrics.repository.MetricsRepository;
import com.example.consumer_metrics.service.ConsumerService;
import com.example.producer_metrics.dto.ProducerMetricsDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

    private final MetricsRepository metricsRepository;
    private final ProducerMetricsDtoMapper producerMetricsDtoMapper;
    private final ConsumerMetricsDtoMapper consumerMetricsDtoMapper;

    @Override
    @Transactional
    public void saveOrUpdateMetric(ProducerMetricsDto producerMetricsDto) {
        Metric metric = metricsRepository.findByName(producerMetricsDto.name())
                .orElse(producerMetricsDtoMapper.producerMetricsDtoToMetric(producerMetricsDto));

        metric.setDescription(producerMetricsDto.description());
        metric.setBaseUnit(producerMetricsDto.baseUnit());

        List<Measurement> measurementList = producerMetricsDto.measurements().stream()
                .map(producerMetricsDtoMapper::measurementsDtoToMeasurement)
                .peek(measurement -> measurement.setMetric(metric))
                .toList();

        if (metric.getMeasurementList() == null) {
            metric.setMeasurementList(new ArrayList<>());
        }
        metric.getMeasurementList().addAll(measurementList);

        metricsRepository.save(metric);
    }

    @Override
    public List<MetricNameDto> getMetricNamesList() {
        return consumerMetricsDtoMapper.metricToMetricNameDto(metricsRepository.findAll());
    }

    @Override
    public ProducerMetricsDto getMetricById(int id) {
        log.info("Метод getMetricById возвращает: " + metricsRepository.findById(id).isEmpty());
        Optional<Metric> metricOptional = metricsRepository.findById(id);
        if (metricOptional.isPresent()) {
            return consumerMetricsDtoMapper.metricToProducerMetricsDto(metricOptional.get());
        }
        throw new EntityNotFoundException("Metric not found for id: " + id);
    }

}
