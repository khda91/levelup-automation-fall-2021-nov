package ru.levelp.at.lesson03.maven.unit.tests;

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

    public double divide(double a, double b) {
        return a / b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divide to zero is prohibited");
        }
        return divide((double) a, (double) b);
    }

    public int factorial(int a) {
        int res = 1;

        for (int i = 1; i <= a; i++) {
            res *= i;
        }

        return res;
    }

    public int[] fibonachi(int a) {
        if (a < 2) {
            throw new IllegalArgumentException(String.format("a should greater than 2"));
        }
        int[] fibs = new int[a];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i < a; i++) {
            int res = fibs[i - 2] + fibs[i - 1];
            fibs[i] = res;
        }
        return fibs;
    }
}
