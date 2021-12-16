package ru.levelp.at.taf.example.trello.service.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeDriverManager extends DriverManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChromeDriverManager.class);

    @Override
    protected WebDriver createDriver() {
        LOGGER.info("Initialize Chrome browser");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
