package com.wipro.app;


	import com.wipro.model.CounterValue;
	import com.wipro.service.Counter;

	public class CounterApp {
	    public static void main(String[] args) throws InterruptedException {
	        Counter counter = new Counter();

	        Thread incrementThread = new Thread(() -> {
	            for (int i = 0; i < 1000; i++) {
	                counter.increment();
	            }
	        });

	        Thread decrementThread = new Thread(() -> {
	            for (int i = 0; i < 1000; i++) {
	                counter.decrement();
	            }
	        });

	        incrementThread.start();
	        decrementThread.start();

	    
	        incrementThread.join();
	        decrementThread.join();

	        System.out.println("Final count: " + counter.getCount());

	       
	        CounterValue immutableCounterValue = new CounterValue(counter.getCount());
	        System.out.println("Immutable Counter Value: " + immutableCounterValue.getValue());
	    }
	}
