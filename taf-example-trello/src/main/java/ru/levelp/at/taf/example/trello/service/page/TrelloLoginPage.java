package ru.levelp.at.taf.example.trello.service.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrelloLoginPage extends TrelloBasePage {

    private static final String PAGE_URL = "/login";

    @FindBy(xpath = "//*[@id='user']")
    private WebElement usernameTextField;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[@id='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement loginSubmitButton;

    public TrelloLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open(PAGE_URL);
    }

    public void sendKeysToUsernameTextField(final String username) {
        sendKeysToWebElement(usernameTextField, username);
    }

    public void sendKeysToPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(loginSubmitButton));
        sendKeysToWebElement(passwordTextField, password);
    }

    public void clickToLoginButton() {
        clickToWebElement(loginButton);
    }

    public void clickToLoginSubmitButton() {
        clickToWebElement(loginSubmitButton);
    }
}
