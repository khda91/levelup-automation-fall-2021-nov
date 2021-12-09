package ru.levelp.at.lesson12.design.pattern.singleton;

import org.testng.annotations.Test;

public class SingletonSecondTest {

    @Test
    public void test1() {
        System.out.println(this.getClass().getCanonicalName() + "#test1 method");
        System.out.println(StringSingleton.getInstance().getValue());
    }
}
