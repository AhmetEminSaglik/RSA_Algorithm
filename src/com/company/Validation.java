package com.company;

public class Validation {
    public boolean isPrimeNumber(int number) {

        for (int i = 2; i < number / 2; i++) {
            if (number % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
