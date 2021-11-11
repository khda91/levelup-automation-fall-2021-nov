package ru.levelp.at.lesson03.maven.unit.tests.testng.data.provider;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorExternalDataProviderTest extends AbstractBaseCalculatorTest {

    @Test(dataProviderClass = CalculatorExternalDataProvider.class,
          dataProvider = "factorialDataProvider")
    public void factorialTest(int factorialNumber, int expectedResult) {
        System.out.println(String.format("Factorial %d test", factorialNumber));
        int actualResult = calculator.factorial(factorialNumber);
        assertEquals(actualResult, expectedResult);
    }

    @Test(dataProviderClass = CalculatorExternalDataProvider.class,
          dataProvider = "Fibonachi Data Provider")
    public void fibonachiTest(int fibNumber, int[] expectedResult) {
        System.out.println(String.format("Fibonachi %d test", fibNumber));
        int[] actualResult = calculator.fibonachi(fibNumber);
        assertEquals(actualResult, expectedResult);
    }
}
