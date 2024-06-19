package com.example.consumer_metrics.mapper;

import com.example.consumer_metrics.dto.MetricNameDto;
import com.example.consumer_metrics.model.Measurement;
import com.example.consumer_metrics.model.Metric;
import com.example.producer_metrics.dto.MeasurementsDto;
import com.example.producer_metrics.dto.ProducerMetricsDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ConsumerMetricsDtoMapper {
    List<MetricNameDto> metricToMetricNameDto (List<Metric> metricList);

    @Mapping(source = "measurementList", target = "measurements")
    ProducerMetricsDto metricToProducerMetricsDto (Metric metric);

    @IterableMapping(elementTargetType = MeasurementsDto.class)
    List<MeasurementsDto> measurementsToMeasurementsDto(List<Measurement> measurements);
}
