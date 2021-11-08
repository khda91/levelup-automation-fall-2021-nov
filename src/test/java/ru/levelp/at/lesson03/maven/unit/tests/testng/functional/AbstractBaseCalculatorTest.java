package ru.levelp.at.lesson03.maven.unit.tests.testng.functional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.levelp.at.lesson03.maven.unit.tests.Calculator;

public abstract class AbstractBaseCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void setUpSuite() {
        System.out.println(this.getClass().getSimpleName() + " set up suite");
        System.out.println();
    }

    @BeforeTest
    public void setUpTest() {
        System.out.println(this.getClass().getSimpleName() + " set up test");
        System.out.println();
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println(this.getClass().getSimpleName() + " set up class");
        System.out.println();
    }

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

    @AfterClass
    public void tearDownClass() {
        System.out.println(this.getClass().getSimpleName() + " tear down class");
        System.out.println("=======");
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println(this.getClass().getSimpleName() + " tear down test");
        System.out.println();
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println(this.getClass().getSimpleName() + " tear down suite");
        System.out.println();
    }
}
