package ru.levelp.at.lesson03.maven.unit.tests.testng.groups;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.tests.testng.groups.constants.GroupNameConstant;

public class CalculatorDivideTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.POSITIVE_GROUP})
    public void positiveDivideIntTest() {
        System.out.println(this.getClass().getSimpleName() + " positive divide int test");
        double actualResult = calculator.divide(10, 2);
        double expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class,
          groups = {GroupNameConstant.NEGATIVE_GROUP})
    public void negativeDivideIntTest() {
        System.out.println(this.getClass().getSimpleName() + " negative divide int test");
        calculator.divide(2, 0);
    }
}
