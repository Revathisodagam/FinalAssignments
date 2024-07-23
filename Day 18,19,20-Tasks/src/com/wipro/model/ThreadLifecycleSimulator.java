package com.wipro.model;

public class ThreadLifecycleSimulator implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Thread starting in NEW state");

            // Simulate some work in NEW state
            Thread.sleep(1000);

            // Transition to RUNNABLE state
            System.out.println("Thread transitioning to RUNNABLE state");
            Thread.sleep(1000);

            // Simulate some work in RUNNABLE state
            System.out.println("Thread performing some task in RUNNABLE state");
            Thread.sleep(1000);

            // Simulate WAITING state using wait() and notify()
            synchronized (this) {
                System.out.println("Thread transitioning to WAITING state (waiting for notify)");
                wait();
            }

            // Simulate TIMED_WAITING state using sleep()
            System.out.println("Thread transitioning to TIMED_WAITING state (sleeping for 2 seconds)");
            Thread.sleep(2000);

            // Simulate BLOCKED state by acquiring a lock on an object
            synchronized (this) {
                System.out.println("Thread transitioning to BLOCKED state (holding lock)");
                Thread.sleep(1000);
            }

            // Simulate TERMINATED state
            System.out.println("Thread finishing execution in TERMINATED state");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void notifyThread() {
        notify();
    }
}
