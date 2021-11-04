package ru.levelp.at.lesson02.git;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(String.format("2 + 4 = %d", calculator.sum(2, 4)));
        System.out.println(String.format("6 - 8 = %d", calculator.subtract(6, 8)));
    }
}
