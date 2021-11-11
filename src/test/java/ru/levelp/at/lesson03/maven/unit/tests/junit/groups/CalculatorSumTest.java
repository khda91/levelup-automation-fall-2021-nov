package ru.levelp.at.lesson03.maven.unit.tests.junit.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags.PositiveTag;

public class CalculatorSumTest extends AbstractBaseCalculatorTest {

    @Test
    @PositiveTag
    public void sumTest() {
        System.out.println(this.getClass().getSimpleName() + " sum test");
        int actualResult = calculator.sum(2, 3);
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
