package ru.levelp.at.lesson03.maven.unit.tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgExample {

    @Test
    public void test1() {
        Assert.assertEquals(2 + 2, 4);
    }
}
