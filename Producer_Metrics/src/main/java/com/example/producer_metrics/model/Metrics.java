package com.example.producer_metrics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;
@RequiredArgsConstructor
@Getter
public enum Metrics {
    APPLICATION_READY_TIME("application.ready.time"),
    APPLICATION_STARTED_TIME("application.started.time"),
    DISK_FREE("disk.free"),
    DISK_TOTAL("disk.total"),
    EXECUTOR_ACTIVE("executor.active"),
    EXECUTOR_COMPLETED("executor.completed"),
    EXECUTOR_POOL_CORE("executor.pool.core"),
    EXECUTOR_POOL_MAX("executor.pool.max"),
    EXECUTOR_POOL_SIZE("executor.pool.size"),
    EXECUTOR_QUEUE_REMAINING("executor.queue.remaining");

    private final String urlPart;
}
