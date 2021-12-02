package ru.levelp.at.lesson10.jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    private static final String PAGE_RELATIVE_URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement usernameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement userEmailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement userPasswordTextField;

    @FindBy(xpath = "//*[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open(PAGE_RELATIVE_URL);
    }

    public void inputTextToUsernameTextField(String username) {
        sendKeysToWebElement(usernameTextField, username);
    }

    public void inputTextToUserEmailTextField(String email) {
        sendKeysToWebElement(userEmailTextField, email);
    }

    public void inputTextToUserPasswordTextField(String password) {
        sendKeysToWebElement(userPasswordTextField, password);
    }

    public void clickToRegisterButton() {
        clickToWebElement(registerButton);
    }
}
