package com.prime.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PrimeNumbCheckerFactory {

    public static PrimeNumbChecker<?> check(final double value) {
        final Number number = parseNumber(value);
        if (number instanceof Integer) {
            return new IntegerChecker((Integer) number);
        } else if (number instanceof BigInteger) {
            return new BigIntegerChecker((BigInteger) number);
        } else {
            throw new IllegalArgumentException("Unsupported number type: " + number.getClass().getSimpleName());
        }
    }

    public static Number parseNumber(final double value) {
        final BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        if (bigDecimal.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
            return bigDecimal.toBigInteger();
        } else {
            return bigDecimal.intValue();
        }
    }

    public static boolean isNumeric(final String str) {
        return str.matches("-?\\d+(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
