package ru.levelp.at.lesson06.page.object.step.design.patern.step;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson06.page.object.step.design.pattern.UserBugRedHomePage;

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
