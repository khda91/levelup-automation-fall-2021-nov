package ru.levelp.at.lesson02.git;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(String.format("2 + 4 = %d", calculator.sum(2, 4)));
        System.out.println(String.format("6 - 8 = %f", calculator.subtract(6, 8)));
        System.out.println(String.format("2 ^ 10 = %f", calculator.power(2, 10)));
        System.out.println(String.format("6 * 8 = %f", calculator.multiply(6.0, 8.0)));
        System.out.println(String.format("6 / 8 = %f", calculator.divide(6.0, 8.0)));
        System.out.println(String.format("6 / 0 = %f", calculator.divide(6.0, 0.0)));
        System.out.println(String.format("6 / 0 = %f", calculator.divide(6, 0)));
        System.out.println(String.format("6 / 3 = %f", calculator.divide(6, 3)));
    }
}
