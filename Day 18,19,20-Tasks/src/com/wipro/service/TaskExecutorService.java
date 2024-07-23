package com.wipro.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutorService {

    private ExecutorService executor;

    public TaskExecutorService(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public void submitTask(Runnable task) {
        executor.submit(task);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
