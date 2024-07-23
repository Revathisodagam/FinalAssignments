package com.wipro.model;

import java.util.concurrent.TimeUnit;

public class IOOperationTask implements Runnable {

    private int taskId;

    public IOOperationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started: Performing I/O operations...");
        // Simulating I/O operations
        try {
            // Simulate some I/O work
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " completed.");
    }
}
