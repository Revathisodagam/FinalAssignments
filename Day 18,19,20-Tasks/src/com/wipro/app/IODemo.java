package com.wipro.app;

import com.wipro.model.ComplexCalculationTask;
import com.wipro.model.IOOperationTask;
import com.wipro.service.TaskExecutorService;

public class IODemo {
    public static void main(String[] args) {
        TaskExecutorService taskExecutor = new TaskExecutorService(3); // Fixed-size thread pool with 3 threads

        // Submit complex calculation tasks
        for (int i = 1; i <= 5; i++) {
            taskExecutor.submitTask(new ComplexCalculationTask(i));
        }

        // Submit I/O operation tasks
        for (int i = 1; i <= 3; i++) {
            taskExecutor.submitTask(new IOOperationTask(i));
        }

        // Shutdown the executor after all tasks are submitted
        taskExecutor.shutdown();
    }
}
