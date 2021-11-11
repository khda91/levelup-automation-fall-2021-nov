package ru.levelp.at.lesson03.maven.unit.tests.junit.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags.NegativeTag;
import ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags.PositiveTag;

public class CalculatorPowerTest extends AbstractBaseCalculatorTest {

    @Test
    @PositiveTag
    public void positivePowerTest() {
        System.out.println(this.getClass().getSimpleName() + " positive power test");
        double actualResult = calculator.power(2.0, 10);
        double expectedResult = Math.pow(2.0, 10);
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @NegativeTag
    public void negativePowerTest() {
        System.out.println(this.getClass().getSimpleName() + " negative power test");
        assertThrows(IllegalArgumentException.class, () -> calculator.power(2.0, -10));
    }
}
