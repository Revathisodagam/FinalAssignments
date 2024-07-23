package com.wipro.app;

import com.wipro.model.NumberPrinter;
import com.wipro.service.ThreadService;

public class NumberPrinterDemo {
    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();

        // Create two instances of NumberPrinter
        NumberPrinter printer1 = new NumberPrinter("Thread 1");
        NumberPrinter printer2 = new NumberPrinter("Thread 2");

        // Start threads
        threadService.startThread(printer1);
        threadService.startThread(printer2);
    }
}
