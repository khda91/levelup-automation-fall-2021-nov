package ru.levelp.at.lesson03.maven.unit.tests.testng.groups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.lesson03.maven.unit.tests.Calculator;
import ru.levelp.at.lesson03.maven.unit.tests.testng.groups.constants.GroupNameConstant;

public abstract class AbstractBaseCalculatorTest {

    protected Calculator calculator;

    @BeforeGroups
    public void setUpGroup() {
        System.out.println(this.getClass().getSimpleName() + " set up all groups");
        System.out.println();
    }

    @BeforeGroups(groups = GroupNameConstant.POSITIVE_GROUP)
    public void setUpPositiveGroup() {
        System.out.println(this.getClass().getSimpleName() + " set up positive groups");
        System.out.println();
    }

    @BeforeClass(groups = GroupNameConstant.NEGATIVE_GROUP)
    public void setUpClass() {
        System.out.println(this.getClass().getSimpleName() + " set up class");
        System.out.println();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(this.getClass().getSimpleName() + " set up method");
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println(this.getClass().getSimpleName() + " tear down method");
        System.out.println();
        calculator = null;
    }

    @AfterClass(groups = GroupNameConstant.POSITIVE_GROUP)
    public void tearDownClass() {
        System.out.println(this.getClass().getSimpleName() + " tear down class");
        System.out.println("=======");
    }

    @AfterGroups(groups = {GroupNameConstant.NEGATIVE_GROUP})
    public void tearDownNegativeGroup() {
        System.out.println(this.getClass().getSimpleName() + " tear down negative groups");
        System.out.println();
    }

    @AfterGroups
    public void tearDownGroup() {
        System.out.println(this.getClass().getSimpleName() + " tear down all groups");
        System.out.println();
    }
}
