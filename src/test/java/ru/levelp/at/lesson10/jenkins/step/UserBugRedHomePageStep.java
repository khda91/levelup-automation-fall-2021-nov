package ru.levelp.at.lesson10.jenkins.step;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson10.jenkins.UserBugRedHomePage;

public class UserBugRedHomePageStep extends UserBugRedBaseStep {

    private UserBugRedHomePage homePage;

    public UserBugRedHomePageStep(WebDriver driver) {
        super(driver);
        this.homePage = new UserBugRedHomePage(driver);
    }

    public void checkRegisteredUsername(final String expectedUsername) {
        String actualUsername = homePage.getTextFromUsernameDropdown();

        assertThat(actualUsername)
            .as("Username was incorrect")
            .isEqualToIgnoringCase(expectedUsername);
    }
}
