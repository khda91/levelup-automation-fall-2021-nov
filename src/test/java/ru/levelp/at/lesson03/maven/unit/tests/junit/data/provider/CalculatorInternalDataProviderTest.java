package ru.levelp.at.lesson03.maven.unit.tests.junit.data.provider;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson03.maven.unit.tests.junit.functional.AbstractBaseCalculatorTest;

public class CalculatorInternalDataProviderTest extends AbstractBaseCalculatorTest {

    public Stream<Arguments> factorialDataProvider() {
        return Stream.of(
            Arguments.arguments(3, 6),
            Arguments.arguments(4, 24),
            Arguments.arguments(5, 120)
        );
    }

    @ParameterizedTest
    @MethodSource("factorialDataProvider")
    public void factorialTest(int factorialNumber, int expectedResult) {
        System.out.println(String.format("Factorial %d test", factorialNumber));
        int actualResult = calculator.factorial(factorialNumber);
        assertEquals(expectedResult, actualResult);
    }

    public Stream<Arguments> fibonachiDataProvider() {
        return
            Stream.of(
                Arguments.arguments(3, new int[] {0, 1, 1}),
                Arguments.arguments(5, new int[] {0, 1, 1, 2, 3}),
                Arguments.arguments(8, new int[] {0, 1, 1, 2, 3, 5, 8, 13})
            );
    }

    @ParameterizedTest
    @MethodSource("fibonachiDataProvider")
    public void fibonachiTest(int fibNumber, int[] expectedResult) {
        System.out.println(String.format("Fibonachi %d test", fibNumber));
        int[] actualResult = calculator.fibonachi(fibNumber);
        assertArrayEquals(actualResult, expectedResult);
    }
}
