package ru.levelp.at.lesson03.maven.unit.tests.testng.groups;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.tests.testng.groups.constants.GroupEnum;
import ru.levelp.at.lesson03.maven.unit.tests.testng.groups.constants.GroupNameConstant;

public class CalculatorSumTest extends AbstractBaseCalculatorTest {

    @Test(groups = {GroupNameConstant.POSITIVE_GROUP})
    public void sumTest() {
        System.out.println(this.getClass().getSimpleName() + " sum test");
        int actualResult = calculator.sum(2, 3);
        int expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
