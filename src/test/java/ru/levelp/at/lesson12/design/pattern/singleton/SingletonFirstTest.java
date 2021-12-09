package ru.levelp.at.lesson12.design.pattern.singleton;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonFirstTest {

    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getCanonicalName() + "#setUp method");
        System.out.println(StringSingleton.getInstance().getValue());
    }

    @Test
    public void test1() {
        System.out.println(this.getClass().getCanonicalName() + "#test1 method");
        System.out.println(StringSingleton.getInstance().getValue());
    }
}
