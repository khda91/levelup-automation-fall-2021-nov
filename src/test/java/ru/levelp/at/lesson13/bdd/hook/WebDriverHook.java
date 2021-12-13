package ru.levelp.at.lesson13.bdd.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;

public class WebDriverHook {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        TestContext.getInstance().setObject("webDriver", driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getInstance().cleanUp();
    }
}
