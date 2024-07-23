package com.wipro.app;

import com.wipro.model.ThreadLifecycleSimulator;
import com.wipro.service.ThreadService;

public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycleSimulator simulator = new ThreadLifecycleSimulator();
        ThreadService threadService = new ThreadService();

        // Start the thread simulation
        threadService.startThread(simulator);

        // Simulate transition from WAITING to TIMED_WAITING
        threadService.notifyThread(simulator);

        // Simulate thread joining to wait for completion
        threadService.joinThread(simulator);
    }
}
