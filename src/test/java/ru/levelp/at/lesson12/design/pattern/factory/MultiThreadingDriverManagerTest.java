package ru.levelp.at.lesson12.design.pattern.factory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.util.SleepUtil;

public class MultiThreadingDriverManagerTest {

    DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        driverManager = DriverFactory.valueOf("EDGE").createInstance();
    }

    @Test(invocationCount = 3, threadPoolSize = 3)
    public void multiThreadingTest() {
        driverManager.getDriver().navigate().to("https://ya.ru");
        SleepUtil.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quit();
    }
}
