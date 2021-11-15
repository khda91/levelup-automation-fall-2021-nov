package ru.levelp.at.lesson05.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.util.SleepUtil;

public abstract class SeleniumBaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(SeleniumSampleTest.SBERBANK_URL);
        SleepUtil.sleep(1500);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
