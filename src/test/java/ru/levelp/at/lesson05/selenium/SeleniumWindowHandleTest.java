package ru.levelp.at.lesson05.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.util.SleepUtil;

public class SeleniumWindowHandleTest {

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
    public void windowHandleTest() {
        driver.navigate().to(SeleniumSampleTest.SBERBANK_URL);
        SleepUtil.sleep(2000);
        var windowHandleSberbank = driver.getWindowHandle();
        System.out.println(String.format("Sber window handle %s", windowHandleSberbank));

        driver = driver.switchTo().newWindow(WindowType.TAB);
        SleepUtil.sleep(2000);

        driver.navigate().to("https://ozon.ru");
        SleepUtil.sleep(2000);

        System.out.println("Driver window handles -> " + driver.getWindowHandles());

        driver.switchTo().window(windowHandleSberbank);
        SleepUtil.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
