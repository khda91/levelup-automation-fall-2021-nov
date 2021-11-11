package ru.levelp.at.lesson03.maven.unit.tests.junit.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorSumTest extends AbstractBaseCalculatorTest {

    @Test
    public void sumTest() {
        System.out.println(this.getClass().getSimpleName() + " sum test");
        int actualResult = calculator.sum(2, 3);
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
