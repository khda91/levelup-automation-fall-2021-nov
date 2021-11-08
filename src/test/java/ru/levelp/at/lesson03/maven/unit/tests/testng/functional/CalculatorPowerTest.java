package ru.levelp.at.lesson03.maven.unit.tests.testng.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPowerTest extends AbstractBaseCalculatorTest {

    @Test
    public void positivePowerTest() {
        System.out.println(this.getClass().getSimpleName() + " positive power test");
        double actualResult = calculator.power(2.0, 10);
        double expectedResult = Math.pow(2.0, 10);
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativePowerTest() {
        System.out.println(this.getClass().getSimpleName() + " negative power test");
        calculator.power(2.0, -10);
    }
}
