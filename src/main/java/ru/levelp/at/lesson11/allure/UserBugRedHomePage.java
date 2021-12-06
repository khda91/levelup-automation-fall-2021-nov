package ru.levelp.at.lesson11.allure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedHomePage extends UserBugRedBasePage {

    private static final String PAGE_RELATIVE_URL = "/";

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement usernameDropdown;

    public UserBugRedHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open(PAGE_RELATIVE_URL);
    }

    public String getTextFromUsernameDropdown() {
        return getTextFromWebElement(usernameDropdown);
    }
}
