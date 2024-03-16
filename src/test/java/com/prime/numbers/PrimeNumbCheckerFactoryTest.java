package com.prime.numbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class PrimeNumbCheckerFactoryTest {

    @Test
    public void testCheckWithInteger() {
        PrimeNumbChecker<?> checker = PrimeNumbCheckerFactory.check(7.0);
        assertTrue(checker instanceof IntegerChecker);

        checker = PrimeNumbCheckerFactory.check(15.0);
        assertTrue(checker instanceof IntegerChecker);
        checker = PrimeNumbCheckerFactory.check(255.0);
        assertTrue(checker instanceof IntegerChecker);
        checker = PrimeNumbCheckerFactory.check(9050.0);
        assertTrue(checker instanceof IntegerChecker);
        checker = PrimeNumbCheckerFactory.check(1120.0);
        assertTrue(checker instanceof IntegerChecker);
    }

    @Test
    public void testCheckWithBigInteger() {
        PrimeNumbChecker<?> checker = PrimeNumbCheckerFactory.check(12345678901234567890.0);
        assertTrue(checker instanceof BigIntegerChecker);

        checker = PrimeNumbCheckerFactory.check(1234.0);
        assertTrue(checker instanceof IntegerChecker);
        checker = PrimeNumbCheckerFactory.check(-5678.0);
        assertTrue(checker instanceof IntegerChecker);
        checker = PrimeNumbCheckerFactory.check(0.0);
        assertTrue(checker instanceof IntegerChecker);
        checker = PrimeNumbCheckerFactory.check(-0.0);
        assertTrue(checker instanceof IntegerChecker);

    }

    @Test
    public void testParseNumberWithInteger() {
        final Number number = PrimeNumbCheckerFactory.parseNumber(7.0);
        assertTrue(number instanceof Integer);
        assertEquals(7, number);
    }

    @Test
    public void testParseNumberWithDouble() {
        final double value = 1234567890123456.0;
        final Number result = PrimeNumbCheckerFactory.parseNumber(value);
        assertEquals(new BigInteger("1234567890123456"), result);
    }

    @Test
    public void testParseNumberWithDoubleConvertedToBigInteger() {
        final double value = 1234567890123456.0;
        final Number result = PrimeNumbCheckerFactory.parseNumber(value);
        assertEquals(new BigInteger("1234567890123456"), result);
    }
}