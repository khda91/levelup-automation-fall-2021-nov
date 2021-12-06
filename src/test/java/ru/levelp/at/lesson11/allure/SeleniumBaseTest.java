package ru.levelp.at.lesson11.allure;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson11.allure.step.UserBugRedHomePageStep;
import ru.levelp.at.lesson11.allure.step.UserBugRedLoginRegistrationStep;

public abstract class SeleniumBaseTest {

    protected static final Faker FAKER = new Faker();

    // public static WebDriver driver; так делать не надо!!!
    protected WebDriver driver;
    protected UserBugRedLoginRegistrationStep loginRegistrationStep;
    protected UserBugRedHomePageStep homePageStep;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        boolean headless = Boolean.parseBoolean(System.getenv("BROWSER_HEADLESS_MODE"));
        var chromeOptions = new ChromeOptions()
            .setHeadless(headless);
        driver = new ChromeDriver(chromeOptions);
        context.setAttribute("web.driver", driver);
        loginRegistrationStep = new UserBugRedLoginRegistrationStep(driver);
        homePageStep = new UserBugRedHomePageStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
