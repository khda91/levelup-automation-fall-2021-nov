package ru.levelp.at.lesson05.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.util.SleepUtil;

public class SeleniumWebElementSample {

    private WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void webElementSampleTest() {
        driver.navigate().to(SeleniumSampleTest.SBERBANK_URL);
        SleepUtil.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("[aria-label='Кредиты']"));
        element.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
