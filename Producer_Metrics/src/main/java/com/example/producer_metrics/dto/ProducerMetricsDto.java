package com.example.producer_metrics.dto;


import java.util.List;

public record ProducerMetricsDto(
        String name,
        String description,
        String baseUnit,
        List<MeasurementsDto> measurements)
        {
}
