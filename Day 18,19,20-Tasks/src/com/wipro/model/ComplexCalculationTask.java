package com.wipro.model;

public class ComplexCalculationTask implements Runnable {

    private int taskId;

    public ComplexCalculationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started: Performing complex calculations...");
        // Simulating complex calculations
        for (int i = 0; i < 5; i++) {
            // Simulate some work
            double result = Math.pow((double) taskId, (double) i);
            System.out.println("Task " + taskId + ": Result " + i + ": " + result);
        }
        System.out.println("Task " + taskId + " completed.");
    }
}
