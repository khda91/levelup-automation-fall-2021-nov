package ru.levelp.at.lesson03.maven.unit.tests.testng.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractBaseCalculatorTest {

    @Test
    public void sumTest() {
        System.out.println(this.getClass().getSimpleName() + " sum test");
        int actualResult = calculator.sum(2, 3);
        int expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
