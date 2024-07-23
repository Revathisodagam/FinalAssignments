package com.wipro.model;

public class NumberPrinter implements Runnable {

    private String threadName;

    public NumberPrinter(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000); // Delay of 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
