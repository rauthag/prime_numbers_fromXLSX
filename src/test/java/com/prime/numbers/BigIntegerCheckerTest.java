package com.prime.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static com.prime.numbers.BigIntegerChecker.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class BigIntegerCheckerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testBigIntegerSqrt() {
        assertEquals(BigInteger.ZERO, sqrt(BigInteger.ZERO));
        assertEquals(BigInteger.ONE, sqrt(BigInteger.ONE));
        assertEquals(BigInteger.ONE, sqrt(BigInteger.valueOf(2)));
        assertEquals(BigInteger.valueOf(2), sqrt(BigInteger.valueOf(4)));
        assertEquals(BigInteger.valueOf(1000), sqrt(BigInteger.valueOf(1000000)));
        assertEquals(BigInteger.valueOf(3162), sqrt(BigInteger.valueOf(10000000)));
        assertEquals(BigInteger.valueOf(10000), sqrt(BigInteger.valueOf(100000000)));

        final BigInteger number = new BigInteger("900000000013");
        final BigInteger sqrt = sqrt(number);
        assertEquals(new BigInteger("948683"), sqrt);

        final BigInteger biggestNumber = new BigInteger("9223372036854775807");
        final BigInteger biggestSqrt = sqrt(biggestNumber);
        assertEquals(new BigInteger("3037000499"), biggestSqrt);
    }

    @Test
    void testIsPrime_SmallNumber() {

        final BigIntegerChecker checker = new BigIntegerChecker(BigInteger.valueOf(7));
        final boolean result = checker.isPrime();

        assertTrue(result);
    }

    @Test
    void testIsPrime_SmallNonPrimeNumber() {

        final BigIntegerChecker checker = new BigIntegerChecker(BigInteger.valueOf(9));
        final boolean result = checker.isPrime();

        assertFalse(result);
    }

    @Test
    void testIsPrime_LessOrEqualOne() {

        final BigIntegerChecker checker1 = new BigIntegerChecker(BigInteger.ONE);
        final BigIntegerChecker checker2 = new BigIntegerChecker(BigInteger.ZERO);
        final boolean result1 = checker1.isPrime();
        final boolean result2 = checker2.isPrime();

        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void testIsPrime_NegativeNumber() {

        final BigIntegerChecker checker = new BigIntegerChecker(BigInteger.valueOf(-5));
        final boolean result = checker.isPrime();

        assertFalse(result);
    }

    @Test
    void testIsPrime_LargeNonPrime() {

        final BigInteger nonPrimeNumber = new BigInteger("1000000000000066600000000000003");
        final BigIntegerChecker checker = new BigIntegerChecker(nonPrimeNumber);
        final boolean result = checker.isPrime();

        assertFalse(result);
    }

    @Test
    void testIsPrime_LargePrimeNumber() {

        final BigInteger primeNumber = new BigInteger("982451653");
        final BigIntegerChecker checker = new BigIntegerChecker(primeNumber);
        final boolean result = checker.isPrime();

        assertTrue(result);
    }


}