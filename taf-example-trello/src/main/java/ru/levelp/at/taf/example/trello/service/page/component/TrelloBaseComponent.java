package ru.levelp.at.taf.example.trello.service.page.component;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.taf.example.trello.configuration.ApplicationConfiguration;

public abstract class TrelloBaseComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected TrelloBaseComponent(WebDriver driver) {
        ApplicationConfiguration configuration = ApplicationConfiguration.createConfig();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(configuration.webDriverWaitTimeoutInSeconds()));
        PageFactory.initElements(this.driver, this);
    }

    void clickToWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    void sendKeysToWebElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    String getTextFromWebElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
}
