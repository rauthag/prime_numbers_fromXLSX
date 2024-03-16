package com.prime.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.apache.commons.math3.primes.Primes.isPrime;
import static org.junit.jupiter.api.Assertions.*;

class IntegerCheckerTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    public void testIsPrimeMethodComparison() {
        final int[] primeArray = generatePrimeArray();
        for (final int prime : primeArray) {
            final PrimeNumbChecker<?> primeCheck = PrimeNumbCheckerFactory.check(prime);
            assertTrue(primeCheck.isPrime());
        }

        final int[] notPrimeArray = generateNotPrimeArray();
        for (final int notPrime : notPrimeArray) {
            final PrimeNumbChecker<?> primeCheck = PrimeNumbCheckerFactory.check(notPrime);
            assertFalse(primeCheck.isPrime());
        }

    }

    private int[] generatePrimeArray() {
        final int[] primes = new int[25];
        int count = 0;
        int num = 2;
        while (count < 25) {
            if (isPrime(num)) {
                primes[count++] = num;
            }
            num++;
        }
        return primes;
    }

    private int[] generateNotPrimeArray() {
        final int[] notPrimes = new int[25];
        int count = 0;
        int num = 2;
        while (count < 25) {
            if (!isPrime(num)) {
                notPrimes[count++] = num;
            }
            num++;
        }
        return notPrimes;
    }

}