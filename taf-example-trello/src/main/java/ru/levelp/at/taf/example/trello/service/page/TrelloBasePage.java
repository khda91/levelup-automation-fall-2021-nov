package ru.levelp.at.taf.example.trello.service.page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.taf.example.trello.configuration.ApplicationConfiguration;
import ru.levelp.at.taf.example.trello.service.page.component.TrelloHeaderComponent;

public abstract class TrelloBasePage {

    private final String baseUrl;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TrelloHeaderComponent header;

    protected TrelloBasePage(WebDriver driver) {
        ApplicationConfiguration configuration = ApplicationConfiguration.createConfig();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(configuration.webDriverWaitTimeoutInSeconds()));
        PageFactory.initElements(this.driver, this);
        this.baseUrl = configuration.baseUrl();
        header = new TrelloHeaderComponent(driver);
    }

    protected void open(String relativeUrl) {
        driver.navigate().to(baseUrl + relativeUrl);
    }

    public abstract void open();

    void clickToWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    void sendKeysToWebElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    String getTextFromWebElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public TrelloHeaderComponent header() {
        return header;
    }
}
