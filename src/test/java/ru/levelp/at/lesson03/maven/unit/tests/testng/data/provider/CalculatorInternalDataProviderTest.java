package ru.levelp.at.lesson03.maven.unit.tests.testng.data.provider;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorInternalDataProviderTest extends AbstractBaseCalculatorTest {

    @DataProvider
    public Object[][] factorialDataProvider() {
        return new Object[][] {
            {3, 6},
            {4, 24},
            {5, 120}
        };
    }

    @Test(dataProvider = "factorialDataProvider")
    public void factorialTest(int factorialNumber, int expectedResult) {
        System.out.println(String.format("Factorial %d test", factorialNumber));
        int actualResult = calculator.factorial(factorialNumber);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "Fibonachi Data Provider")
    public Object[][] fibonachiDataProvider() {
        return new Object[][] {
            {3, new int[]{0, 1, 1}},
            {5, new int[]{0, 1, 1, 2, 3}},
            {8, new int[]{0, 1, 1, 2, 3, 5, 8, 13}},
        };
    }


    @Test(dataProvider = "Fibonachi Data Provider")
    public void fibonachiTest(int fibNumber, int[] expectedResult) {
        System.out.println(String.format("Fibonachi %d test", fibNumber));
        int[] actualResult = calculator.fibonachi(fibNumber);
        assertEquals(actualResult, expectedResult);
    }
}
