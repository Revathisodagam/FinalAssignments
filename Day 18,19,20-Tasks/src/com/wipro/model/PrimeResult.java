package com.wipro.model;
import java.util.List;

public class PrimeResult {
    private int upperLimit;
    private List<Integer> primes;

    public PrimeResult(int upperLimit, List<Integer> primes) {
        this.upperLimit = upperLimit;
        this.primes = primes;
    }

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public void setPrimes(List<Integer> primes) {
		this.primes = primes;
	}

   
}