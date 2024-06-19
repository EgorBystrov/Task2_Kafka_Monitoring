package com.example.consumer_metrics.mapper;

import com.example.consumer_metrics.model.Measurement;
import com.example.consumer_metrics.model.Metric;
import com.example.producer_metrics.dto.MeasurementsDto;
import com.example.producer_metrics.dto.ProducerMetricsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProducerMetricsDtoMapper {
    Metric producerMetricsDtoToMetric(ProducerMetricsDto producerMetricsDto);
    Measurement measurementsDtoToMeasurement(MeasurementsDto measurementsDTO);
}
