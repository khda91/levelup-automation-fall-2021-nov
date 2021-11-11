package ru.levelp.at.lesson03.maven.unit.tests.testng.groups;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorFibonachiTestCase extends AbstractBaseCalculatorTest {

    @Test(groups = "GROUP")
    public void fibsTest() {
        int[] actualResult = calculator.fibonachi(5);
        int[] expectedResult = {0, 1, 1, 2, 3};
        assertEquals(actualResult, expectedResult);
    }
}
