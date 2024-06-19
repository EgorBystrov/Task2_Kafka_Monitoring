package com.example.producer_metrics.service.impl;

import com.example.producer_metrics.dto.ProducerMetricsDto;
import com.example.producer_metrics.model.Metrics;
import com.example.producer_metrics.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerServiceImpl implements ProducerService{

    private final KafkaTemplate<Object, Object> kafkaTemplate;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private volatile boolean sendMetricsEnabled = false;

    public boolean isSendMetricsEnabled() {
        return sendMetricsEnabled;
    }

    @Scheduled(fixedRate = 1000L)
    private void scheduledSendMetrics() {
        if (sendMetricsEnabled) {
            sendMetrics();
        }
    }

    @Override
    public void toggleSendMetrics() {
        this.sendMetricsEnabled = !this.sendMetricsEnabled;
    }

    private void sendMetrics() {
        ProducerMetricsDto producerMetricsDto = getMetrics();
        kafkaTemplate.send("metrics", producerMetricsDto);
        log.info("Producer_Metrics send: " + producerMetricsDto);
    }

    private ProducerMetricsDto getMetrics(){
        String url = "http://localhost:8081/actuator/metrics/" + createMetric();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        try {
            return objectMapper.readValue(responseEntity.getBody(), ProducerMetricsDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String createMetric(){
        return Metrics.values()[ThreadLocalRandom.current().nextInt(Metrics.values().length)].getUrlPart();
    }
}
