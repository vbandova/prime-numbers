package com.infinite.lambda.primenumbers.service;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

    @Override
    public boolean isPrime(long number) {
        //first prime number is 2
        if (number < 2) {
            return false;
        }
        if (number < 4) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        //all unique divisors of n are numbers less than or equal to √n
        //all primes greater than 3 are of the form 6k ± 1, where k is any integer greater than 0
        long divisor = 5;
        while (divisor * divisor <= number && divisor * divisor > 0) {
            if (number % divisor == 0 || number % (divisor + 2) == 0) {
                return false;
            }
            divisor += 6;
        }
        //no divisors are found == prime
        return true;
    }

    @Override
    public long getNextPrime(long number) {
        if (number < 2) {
            return 2;
        }
        if (number == Long.MAX_VALUE) {
            return -1;
        }
        if (isPrime(number)) {
            return number;
        }
        int increment = number % 2 == 0 ? 1 : 0;
        long nextPrimeNumber = number + increment;
        while (Long.MAX_VALUE > nextPrimeNumber && !isPrime(nextPrimeNumber)) {
            nextPrimeNumber += 2;
        }

        return Long.MAX_VALUE == nextPrimeNumber ? -1 : nextPrimeNumber;
    }
}
