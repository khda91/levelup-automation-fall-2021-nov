package ru.levelp.at.lesson03.maven.unit.tests.testng.groups;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.tests.testng.groups.constants.GroupNameConstant;

public class TestCalculatorSubtract extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.POSITIVE_GROUP})
    public void subtractTest() {
        System.out.println(this.getClass().getSimpleName() + " subtract test");
        double actualResult = calculator.subtract(2.0, -3.05);
        double expectedResult = 5.05;
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
}
