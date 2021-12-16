package ru.levelp.at.taf.example.trello.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.example.trello.configuration.ApplicationConfiguration;
import ru.levelp.at.taf.example.trello.service.webdriver.DriverFactory;
import ru.levelp.at.taf.example.trello.service.webdriver.DriverManager;
import ru.levelp.at.taf.example.trello.step.CommonStep;
import ru.levelp.at.taf.example.trello.step.LoginPageStep;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class TrelloBaseTest {

    private ApplicationConfiguration configuration;
    protected LoginPageStep loginPageStep;
    protected CommonStep commonStep;
    private DriverManager driverManager;

    @BeforeAll
    void beforeAll() {
        configuration = ApplicationConfiguration.createConfig();
    }

    @BeforeEach
    void setUp() {
        driverManager = DriverFactory.valueOf(configuration.browserName().toUpperCase()).createInstance();
        WebDriver driver = driverManager.getDriver();
        loginPageStep = new LoginPageStep(driver);
        commonStep = new CommonStep(driver);
    }

    @AfterEach
    void tearDown() {
        driverManager.quit();
    }
}
