package ru.levelp.at.lesson03.maven.unit.tests.junit.functional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.levelp.at.lesson03.maven.unit.tests.Calculator;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class AbstractBaseCalculatorTest {

    protected Calculator calculator;

    // Поведение Junit 5 по умолчанию
    //    @BeforeAll
    //    public static void setUpClass() {
    //        System.out.println(this.getClass().getSimpleName() + " set up class");
    //        System.out.println();
    //    }

    @BeforeAll
    public void setUpClass() {
        System.out.println(this.getClass().getSimpleName() + " set up class");
        System.out.println();
    }

    @BeforeEach
    public void setUp() {
        System.out.println(this.getClass().getSimpleName() + " set up method");
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        System.out.println(this.getClass().getSimpleName() + " tear down method");
        System.out.println();
        calculator = null;
    }

    // Поведение Junit 5 по умолчанию
    //    @AfterAll
    //    public static void tearDownClass() {
    //        System.out.println(this.getClass().getSimpleName() + " tear down class");
    //        System.out.println("=======");
    //    }

    @AfterAll
    public void tearDownClass() {
        System.out.println(this.getClass().getSimpleName() + " tear down class");
        System.out.println("=======");
    }
}
