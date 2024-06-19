package com.example.consumer_metrics.controller.api;

import com.example.consumer_metrics.dto.MetricNameDto;
import com.example.consumer_metrics.exception.ServerException;
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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "consumer_metrics")
public interface ConsumerControllerApi {

    @Operation(summary = "Getting metrics")
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
    ResponseEntity<List<MetricNameDto>> getAllMetrics();

    @Operation(summary = "Getting metric info by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful completion"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ServerException.class))
            )
    })
    public ResponseEntity<ProducerMetricsDto> getMetricById(@PathVariable int id);
}
