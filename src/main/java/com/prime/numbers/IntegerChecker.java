package com.prime.numbers;

public class IntegerChecker implements PrimeNumbChecker<Integer> {

    private final Integer number;

    public IntegerChecker(final Integer number) {
        this.number = number;
    }

    @Override
    public boolean isPrime() {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        final int sqrt = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer getNumber() {
        return number;
    }
}
