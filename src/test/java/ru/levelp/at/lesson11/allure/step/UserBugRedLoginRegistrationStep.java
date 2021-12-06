package ru.levelp.at.lesson11.allure.step;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson11.allure.UserBugRedLoginRegistrationPage;

public class UserBugRedLoginRegistrationStep extends UserBugRedBaseStep {

    private UserBugRedLoginRegistrationPage loginRegistrationPage;

    public UserBugRedLoginRegistrationStep(WebDriver driver) {
        super(driver);
        this.loginRegistrationPage = new UserBugRedLoginRegistrationPage(driver);
    }

    @Step("Окрываем страницу регистрации users.bugred")
    public void openLoginRegistrationPage() {
        loginRegistrationPage.open();
        Allure.addAttachment("Step Attachment", "application/json", "{\"value\":10}", ".json");
    }

    @Step("Регистрируем пользователя с username: {username}, email: {1}, password: {userPassword}")
    public void registerUser(final String username, final String userEmail, final String userPassword) {
        loginRegistrationPage.inputTextToUsernameTextField(username);
        loginRegistrationPage.inputTextToUserEmailTextField(userEmail);
        loginRegistrationPage.inputTextToUserPasswordTextField(userPassword);
        loginRegistrationPage.clickToRegisterButton();
    }
}
