package ru.levelp.at.lesson12.design.pattern.factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.levelp.at.util.SleepUtil;

public class DriverFactoryTest {

    @Test
    public void chromeTest() {
        DriverManager instance = DriverFactory.valueOf("chrome".toUpperCase()).createInstance();
        WebDriver driver = instance.getDriver();
        driver.navigate().to("https://ya.ru");
        SleepUtil.sleep(2000);
        instance.quit();
    }
}
