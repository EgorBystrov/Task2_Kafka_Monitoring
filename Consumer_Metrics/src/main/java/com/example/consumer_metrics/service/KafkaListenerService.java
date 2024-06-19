package com.example.consumer_metrics.service;

import com.example.producer_metrics.dto.ProducerMetricsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerService {

    @Autowired
    private final ConsumerService consumerService;

    @KafkaListener(id = "metricsGroup", topics = "metrics")
    public void listen(ProducerMetricsDto producerMetricsDto){
        log.info("Received: " + producerMetricsDto);
//        if (producerMetricsDto.name().startsWith("fail")){
//            throw new RuntimeException("failed");
//        }
        consumerService.saveOrUpdateMetric(producerMetricsDto);
    }

    @KafkaListener(id = "dltGroup", topics = "metrics.DLT")
    public void dltListen(byte[] in){
        log.info("Received from DLT " + new String(in));
    }

}
