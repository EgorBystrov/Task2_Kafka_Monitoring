package com.example.producer_metrics.controller.api;

import com.example.producer_metrics.dto.ProducerMetricsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.rmi.ServerException;

@Tag(name = "producer_metrics")
public interface ProducerControllerApi {
    @Operation(summary = "Sending metrics to kafka",
    description = "When used, the method starts sending random metrics to kafka. " +
            "To stop sending metrics, you need to call this method again.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful completion"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Client error",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ServerException.class))
            )
    })
    ResponseEntity<String> toggleMetricsSending();
}
