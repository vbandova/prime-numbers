package com.infinite.lambda.primenumbers.service;

public interface PrimeNumberService {

    /**
     * Checks if given number is prime, works until Long.MAX_VALUE
     *
     * @param number - number to check if prime
     * @return true if input number is prime, false if number is composite
     */
    boolean isPrime(long number);

    /**
     * Finds the first prime number after given input (or the input itself, if prime)
     *
     * @param number - first number to start looking for prime
     * @return - first prime number after(including) number, or -1 if cannot find result < Long.MAX_VALUE
     */
    long getNextPrime(long number);
}
