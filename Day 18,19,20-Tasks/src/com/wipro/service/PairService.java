package com.wipro.service;

	import com.wipro.model.Pair;

	public class PairService {
	    public static void main(String[] args) {
	       
	        Pair<Integer, String> pair = new Pair<>(1, "One");

	        System.out.println("Original Pair:");
	        printPair(pair);

	        Pair<String, Integer> reversedPair = pair.reverse();

	        System.out.println("\nReversed Pair:");
	        printPair(reversedPair);
	    }

	    public static <T, U> void printPair(Pair<T, U> pair) {
	        System.out.println("(" + pair.getFirst() + ", " + pair.getSecond() + ")");
	    }
	}


