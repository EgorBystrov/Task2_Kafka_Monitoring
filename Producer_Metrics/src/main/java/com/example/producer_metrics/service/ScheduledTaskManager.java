package com.example.producer_metrics.service;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Service
public class ScheduledTaskManager {

    private final TaskScheduler scheduler;
    private ScheduledFuture<?> futureTask;

    public ScheduledTaskManager(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void startTask(Runnable task) {
        if (futureTask == null || futureTask.isCancelled()) {
            futureTask = scheduler.scheduleWithFixedDelay(task, 1000);
        }
    }

    public void stopTask() {
        if (futureTask != null && !futureTask.isCancelled()) {
            futureTask.cancel(true);
        }
    }
}
