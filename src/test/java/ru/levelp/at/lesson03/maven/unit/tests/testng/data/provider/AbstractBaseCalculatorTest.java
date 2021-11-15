package ru.levelp.at.lesson03.maven.unit.tests.testng.data.provider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.lesson03.maven.unit.tests.Calculator;

public abstract class AbstractBaseCalculatorTest {

    protected Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getSimpleName() + " set up method");
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getSimpleName() + " tear down method");
        System.out.println();
        calculator = null;
    }
}
