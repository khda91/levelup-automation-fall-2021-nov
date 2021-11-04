package ru.levelp.at.lesson02.git;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double power(double a, int p) {
        double res = 1.0;

        if (p < 0) {
            throw new IllegalArgumentException("power should be positive");
        }

        for (int i = 0; i < p; i++) {
            res *= a;
        }
        return res;
    }
}
