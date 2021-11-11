package ru.levelp.at.lesson03.maven.unit.tests.junit.groups;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags.GroupNameConstant;

public class CalculatorFibonachiTestCase extends AbstractBaseCalculatorTest {

    @Test
    @Tag(GroupNameConstant.POSITIVE_GROUP)
    public void fibsTest() {
        int[] actualResult = calculator.fibonachi(5);
        int[] expectedResult = {0, 1, 1, 2, 3};
        assertArrayEquals(expectedResult, actualResult);
    }
}
