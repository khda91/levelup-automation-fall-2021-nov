package ru.levelp.at.lesson03.maven.unit.tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.tests.Calculator;

public class CalculatorSimpleTest {

    @Test
    public void sumTest() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.sum(2, 3);
        int expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subtractTest() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.subtract(2.0, -3.05);
        double expectedResult = 5.05;
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
}
