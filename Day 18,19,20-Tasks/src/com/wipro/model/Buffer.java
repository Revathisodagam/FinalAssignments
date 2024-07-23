package com.wipro.model;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> queue;
    private int maxSize;

    public Buffer(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == maxSize) {
            // Buffer full, wait for consumer to consume
            wait();
        }
        queue.offer(item);
        System.out.println("Produced: " + item);
        notify(); // Notify consumer that a new item is produced
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            // Buffer empty, wait for producer to produce
            wait();
        }
        int item = queue.poll();
        System.out.println("Consumed: " + item);
        notify(); // Notify producer that an item is consumed
        return item;
    }
}