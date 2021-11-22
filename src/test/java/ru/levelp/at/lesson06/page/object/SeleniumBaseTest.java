package ru.levelp.at.lesson06.page.object;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson05.selenium.SeleniumSampleTest;

public abstract class SeleniumBaseTest {

    protected static final Faker FAKER = new Faker();

    protected WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(SeleniumSampleTest.SBERBANK_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
