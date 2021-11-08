package ru.levelp.at.lesson03.maven.unit.tests.testng.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubtractTest extends AbstractBaseCalculatorTest {

    @Test
    public void subtractTest() {
        System.out.println(this.getClass().getSimpleName() + " subtract test");
        double actualResult = calculator.subtract(2.0, -3.05);
        double expectedResult = 5.05;
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
}
