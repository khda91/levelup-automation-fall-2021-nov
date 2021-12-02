package ru.levelp.at.lesson03.maven.unit.tests.testng.data.provider;

import org.testng.annotations.DataProvider;

public class CalculatorExternalDataProvider {

    @DataProvider
    public Object[][] factorialDataProvider() {
        return new Object[][] {
            {3, 6},
            {4, 24},
            {5, 120}
        };
    }

    @DataProvider(name = "Fibonachi Data Provider")
    public Object[][] fibonachiDataProvider() {
        return new Object[][] {
            {3, new int[] {0, 1, 1}},
            {5, new int[] {0, 1, 1, 2, 3}},
            {8, new int[] {0, 1, 1, 2, 3, 5, 8, 13}},
        };
    }
}
