package ru.levelp.at.lesson03.maven.unit.tests.testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.tests.Calculator;

public class CalculatorSimpleWithHooksTest {

    private Calculator calculator;

    // @BeforeClass     -> JUnit 4 must have static access modifier
    // @BeforeAll       -> JUnit 5
    @BeforeClass
    public void setUpClass() {
        System.out.println(this.getClass().getSimpleName() + " set up class");
        System.out.println();
    }

    // @Before      -> Junit 4
    // @BeforeEach  -> Junit 5
    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getSimpleName() + " set up method");
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        System.out.println(this.getClass().getSimpleName() + " sum test");
        int actualResult = calculator.sum(2, 3);
        int expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subtractTest() {
        System.out.println(this.getClass().getSimpleName() + " subtract test");
        double actualResult = calculator.subtract(2.0, -3.05);
        double expectedResult = 5.05;
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }

    // @After      -> Junit 4
    // @AfterEach  -> Junit 5
    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getSimpleName() + " tear down method");
        System.out.println();
        calculator = null;
    }

    // @AfterClass     -> JUnit 4 must have static access modifier
    // @AfterAll       -> JUnit 5
    @AfterClass
    public void tearDownClass() {
        System.out.println(this.getClass().getSimpleName() + " tear down class");
        System.out.println("=======");
    }
}
