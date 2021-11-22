package ru.levelp.at.lesson06.page.object.statics;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {

    private static final String BASE_URL = "http://users.bugred.ru";

    public static void open(WebDriver driver, String relativeUrl) {
        driver.navigate().to(BASE_URL + relativeUrl);
    }

    static void clickToWebElement(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    static void sendKeysToWebElement(WebDriver driver, WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    static String getTextFromWebElement(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element)).getText();
    }
}
