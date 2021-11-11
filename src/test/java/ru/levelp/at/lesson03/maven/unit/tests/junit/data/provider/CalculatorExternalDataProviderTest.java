package ru.levelp.at.lesson03.maven.unit.tests.junit.data.provider;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson03.maven.unit.tests.junit.functional.AbstractBaseCalculatorTest;

public class CalculatorExternalDataProviderTest extends AbstractBaseCalculatorTest {

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson03.maven.unit.tests.junit.data.provider"
        + ".CalculatorExternalDataProvider#factorialDataProvider")
    public void factorialTest(int factorialNumber, int expectedResult) {
        System.out.println(String.format("Factorial %d test", factorialNumber));
        int actualResult = calculator.factorial(factorialNumber);
        assertEquals(actualResult, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson03.maven.unit.tests.junit.data.provider"
        + ".CalculatorExternalDataProvider#fibonachiDataProvider")
    public void fibonachiTest(int fibNumber, int[] expectedResult) {
        System.out.println(String.format("Fibonachi %d test", fibNumber));
        int[] actualResult = calculator.fibonachi(fibNumber);
        assertArrayEquals(actualResult, expectedResult);
    }
}
