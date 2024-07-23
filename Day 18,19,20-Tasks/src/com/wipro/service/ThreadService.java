package com.wipro.service;

import com.wipro.model.NumberPrinter;
import com.wipro.model.ThreadLifecycleSimulator;

public class ThreadService {

    public void startThread(ThreadLifecycleSimulator simulator) {
        Thread thread = new Thread(simulator);
        thread.start();
    }

    public void notifyThread(ThreadLifecycleSimulator simulator) {
        simulator.notifyThread();
    }

    public void joinThread(ThreadLifecycleSimulator simulator) throws InterruptedException {
        Thread thread = new Thread(simulator);
        thread.start();
        thread.join();
    }
    public void startThread(NumberPrinter numberPrinter) {
        Thread thread = new Thread(numberPrinter);
        thread.start();
    }
}
