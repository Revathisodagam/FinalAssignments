package com.wipro.app;

import java.util.concurrent.ExecutionException;

import com.wipro.service.PrimeService;

public class PrimeApp {
    public static void main(String[] args) {
        PrimeService primeService = new PrimeService();
        int upperLimit = 100;
        String outputFile = "prime_numbers.txt";

        primeService.calculatePrimesAsync(upperLimit, outputFile)
            .thenAcceptAsync(primeResult -> System.out.println("Prime numbers up to " + primeResult.getUpperLimit() + " written to " + outputFile))
            .exceptionally(ex -> {
                System.err.println("Failed to calculate and write prime numbers: " + ex.getMessage());
                return null;
            });

        // Ensure the executor shuts down properly
        primeService.shutdownExecutor();
    }
}
