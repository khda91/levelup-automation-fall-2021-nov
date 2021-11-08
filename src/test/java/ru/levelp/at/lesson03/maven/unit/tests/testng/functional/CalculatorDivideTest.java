package ru.levelp.at.lesson03.maven.unit.tests.testng.functional;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends AbstractBaseCalculatorTest {

    @Test
    public void positiveDivideIntTest() {
        System.out.println(this.getClass().getSimpleName() + " positive divide int test");
        double actualResult = calculator.divide(10, 2);
        double expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void negativeDivideIntTest() {
        System.out.println(this.getClass().getSimpleName() + " negative divide int test");
        calculator.divide(2, 0);
    }
}
