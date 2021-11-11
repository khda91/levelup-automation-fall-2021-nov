package ru.levelp.at.lesson03.maven.unit.tests.junit.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags.GroupNameConstant;

public class CalculatorDivideTest extends AbstractBaseCalculatorTest {

    @Test
    @Tag(GroupNameConstant.POSITIVE_GROUP)
    public void positiveDivideIntTest() {
        System.out.println(this.getClass().getSimpleName() + " positive divide int test");
        double actualResult = calculator.divide(10, 2);
        double expectedResult = 5;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @Tag(GroupNameConstant.NEGATIVE_GROUP)
    public void negativeDivideIntTest() {
        System.out.println(this.getClass().getSimpleName() + " negative divide int test");
        assertThrows(ArithmeticException.class, () -> calculator.divide(2, 0));
    }
}
