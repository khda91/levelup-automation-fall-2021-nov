package ru.levelp.at.lesson03.maven.unit.tests.junit.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags.GroupNameConstant;
import ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags.GroupNameConstant.NestedGroupNameConstant;

public class CalculatorSubtractTest extends AbstractBaseCalculatorTest {

    @Test
    @Tags({@Tag(GroupNameConstant.POSITIVE_GROUP), @Tag(NestedGroupNameConstant.ONE_MORE_GROUP)})
    public void subtractTest() {
        System.out.println(this.getClass().getSimpleName() + " subtract test");
        double actualResult = calculator.subtract(2.0, -3.05);
        double expectedResult = 5.05;
        assertEquals(expectedResult, actualResult, 0.001);
    }
}
