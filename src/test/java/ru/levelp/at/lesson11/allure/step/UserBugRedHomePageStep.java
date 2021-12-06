package ru.levelp.at.lesson11.allure.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson11.allure.UserBugRedHomePage;

public class UserBugRedHomePageStep extends UserBugRedBaseStep {

    private UserBugRedHomePage homePage;

    public UserBugRedHomePageStep(WebDriver driver) {
        super(driver);
        this.homePage = new UserBugRedHomePage(driver);
    }

    @Step("Имя зарегистрированного пользователя должно совпадать с '{expectedUsername}'")
    public void checkRegisteredUsername(final String expectedUsername) {
        String actualUsername = homePage.getTextFromUsernameDropdown();

        assertThat(actualUsername)
            .as("Username was incorrect")
            .isEqualToIgnoringCase(expectedUsername);
    }
}
