package ru.levelp.at.lesson10.jenkins.step;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson10.jenkins.UserBugRedLoginRegistrationPage;

public class UserBugRedLoginRegistrationStep extends UserBugRedBaseStep {

    private UserBugRedLoginRegistrationPage loginRegistrationPage;

    public UserBugRedLoginRegistrationStep(WebDriver driver) {
        super(driver);
        this.loginRegistrationPage = new UserBugRedLoginRegistrationPage(driver);
    }

    public void openLoginRegistrationPage() {
        loginRegistrationPage.open();
    }

    public void registerUser(final String username, final String userEmail, final String userPassword) {
        loginRegistrationPage.inputTextToUsernameTextField(username);
        loginRegistrationPage.inputTextToUserEmailTextField(userEmail);
        loginRegistrationPage.inputTextToUserPasswordTextField(userPassword);
        loginRegistrationPage.clickToRegisterButton();
    }
}
