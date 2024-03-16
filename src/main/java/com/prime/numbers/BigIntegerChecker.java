package com.prime.numbers;

import java.math.BigInteger;

public class BigIntegerChecker implements PrimeNumbChecker<BigInteger> {

    private final BigInteger number;

    public BigIntegerChecker(final BigInteger number) {
        this.number = number;
    }

    public static BigInteger sqrt(final BigInteger x) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = x;

        while (left.compareTo(right) <= 0) {
            final BigInteger mid = left.add(right).shiftRight(1);
            if (mid.multiply(mid).compareTo(x) <= 0) {
                left = mid.add(BigInteger.ONE);
            } else {
                right = mid.subtract(BigInteger.ONE);
            }
        }
        return left.subtract(BigInteger.ONE);
    }

    @Override
    public boolean isPrime() {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }

        final BigInteger sqrtNumber = sqrt(number);
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(sqrtNumber) <= 0; i = i.add(BigInteger.ONE)) {
            if (number.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public BigInteger getNumber() {
        return number;
    }
}