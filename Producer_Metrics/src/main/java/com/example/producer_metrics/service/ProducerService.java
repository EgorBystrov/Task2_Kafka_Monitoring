package com.example.producer_metrics.service;

import com.example.producer_metrics.dto.ProducerMetricsDto;
import com.example.producer_metrics.model.Metrics;

import java.util.concurrent.ThreadLocalRandom;

public interface ProducerService {
    public boolean isSendMetricsEnabled();
    public void toggleSendMetrics();
}
