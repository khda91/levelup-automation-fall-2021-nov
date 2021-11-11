package ru.levelp.at.lesson03.maven.unit.tests.junit.data.provider;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class CalculatorExternalDataProvider {

    public static Stream<Arguments> factorialDataProvider() {
        return Stream.of(
            Arguments.arguments(3, 6),
            Arguments.arguments(4, 24),
            Arguments.arguments(5, 120)
        );
    }

    public static Stream<Arguments> fibonachiDataProvider() {
        return
            Stream.of(
                Arguments.arguments(3, new int[] {0, 1, 1}),
                Arguments.arguments(5, new int[] {0, 1, 1, 2, 3}),
                Arguments.arguments(8, new int[] {0, 1, 1, 2, 3, 5, 8, 13})
            );
    }
}
