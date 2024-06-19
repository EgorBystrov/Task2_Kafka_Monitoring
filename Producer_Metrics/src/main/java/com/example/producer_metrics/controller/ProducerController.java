package com.example.producer_metrics.controller;

import com.example.producer_metrics.controller.api.ProducerControllerApi;
import com.example.producer_metrics.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ProducerController implements ProducerControllerApi {

    private final ProducerService producerService;


    @PostMapping("/metrics")
    public ResponseEntity<String> toggleMetricsSending(){
        producerService.toggleSendMetrics();
        return ResponseEntity.ok("Metrics sending is " +
                (producerService.isSendMetricsEnabled() ? "enabled" : "disabled"));
    }
}
