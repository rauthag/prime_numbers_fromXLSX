package com.prime.numbers;

public interface PrimeNumbChecker<T extends Number> {

    boolean isPrime();

    T getNumber();
}
