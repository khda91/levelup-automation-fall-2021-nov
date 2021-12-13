package ru.levelp.at.lesson13.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    private static final String PAGE_RELATIVE_URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement registrationUsernameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement registrationUserEmailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement registrationUserPasswordTextField;

    @FindBy(xpath = "//*[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[contains(@action, 'login')]//input[@name='login']")
    private WebElement loginUserEmailTextField;

    @FindBy(xpath = "//form[contains(@action, 'login')]//input[@name='password']")
    private WebElement loginUserPasswordTextField;

    @FindBy(xpath = "//*[contains(@action, 'login')]//input[@value='Авторизоваться']")
    private WebElement loginButton;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open(PAGE_RELATIVE_URL);
    }

    public void inputTextToRegisterUsernameTextField(String username) {
        sendKeysToWebElement(registrationUsernameTextField, username);
    }

    public void inputTextToRegisterUserEmailTextField(String email) {
        sendKeysToWebElement(registrationUserEmailTextField, email);
    }

    public void inputTextToRegisterUserPasswordTextField(String password) {
        sendKeysToWebElement(registrationUserPasswordTextField, password);
    }

    public void clickToRegisterButton() {
        clickToWebElement(registerButton);
    }

    public void inputTextToLoginUserEmailTextField(String email) {
        sendKeysToWebElement(loginUserEmailTextField, email);
    }

    public void inputTextToLoginUserPasswordTextField(String password) {
        sendKeysToWebElement(loginUserPasswordTextField, password);
    }

    public void clickToLoginButton() {
        clickToWebElement(loginButton);
    }
}
