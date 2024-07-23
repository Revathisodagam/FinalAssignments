package com.wipro.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.wipro.model.PrimeResult;

public class PrimeService {
    private ExecutorService executor = Executors.newFixedThreadPool(5); 
    public CompletableFuture<PrimeResult> calculatePrimesAsync(int upperLimit, String outputFile) {
        return CompletableFuture.supplyAsync(() -> calculatePrimes(upperLimit), executor)
                .thenApplyAsync(primeResult -> writeToFileAsync(primeResult, outputFile), executor);
    }

    private PrimeResult calculatePrimes(int upperLimit) {
        List<Integer> primes = new ArrayList<>();
        // Logic to calculate primes up to upperLimit
        for (int num = 2; num <= upperLimit; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return new PrimeResult(upperLimit, primes);
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private PrimeResult writeToFileAsync(PrimeResult primeResult, String outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Upper Limit: " + primeResult.getUpperLimit() + "\n");
            writer.write("Prime Numbers: " + primeResult.getPrimes() + "\n");
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
        return primeResult;
    }

	public void shutdownExecutor() {
		// TODO Auto-generated method stub
		
	}
}

