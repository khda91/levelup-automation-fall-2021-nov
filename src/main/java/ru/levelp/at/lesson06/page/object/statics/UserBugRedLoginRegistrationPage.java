package ru.levelp.at.lesson06.page.object.statics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;

public class UserBugRedLoginRegistrationPage {

    private static final String PAGE_RELATIVE_URL = "/user/login/index.html";

    private static WebDriver driver;

    @FindBy(xpath = "")
    private WebElement usernameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement userEmailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement userPasswordTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;

    public static void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public void open() {
        PageUtils.open(driver, PAGE_RELATIVE_URL);
    }

//    public static void inputTextToUsernameTextField(String username) {
//        driver.findElement(By.xpath("//form[contains(@action, 'register')]//input[@name='email']"));
//        PageUtils.sendKeysToWebElement(driver, usernameTextField, username);
//    }
//
//    public static void inputTextToUserEmailTextField(String email) {
//        PageUtils.sendKeysToWebElement(driver, userEmailTextField, email);
//    }
//
//    public static void inputTextToUserPasswordTextField(String password) {
//        PageUtils.sendKeysToWebElement(driver, userPasswordTextField, password);
//    }
//
//    public static void clickToRegisterButton() {
//        PageUtils.clickToWebElement(driver, registerButton);
//    }
}
