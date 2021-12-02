package ru.levelp.at.lesson10.jenkins;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson10.jenkins.step.UserBugRedHomePageStep;
import ru.levelp.at.lesson10.jenkins.step.UserBugRedLoginRegistrationStep;

public abstract class SeleniumBaseTest {

    protected static final Faker FAKER = new Faker();

    protected WebDriver driver;
    protected UserBugRedLoginRegistrationStep loginRegistrationStep;
    protected UserBugRedHomePageStep homePageStep;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        boolean headless = Boolean.parseBoolean(System.getenv("BROWSER_HEADLESS_MODE"));
        var chromeOptions = new ChromeOptions()
            .setHeadless(headless);
        driver = new ChromeDriver(chromeOptions);
        loginRegistrationStep = new UserBugRedLoginRegistrationStep(driver);
        homePageStep = new UserBugRedHomePageStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
