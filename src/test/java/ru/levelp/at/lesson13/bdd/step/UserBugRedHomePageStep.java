package ru.levelp.at.lesson13.bdd.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import ru.levelp.at.lesson13.bdd.UserBugRedHomePage;

public class UserBugRedHomePageStep extends UserBugRedBaseStep {

    private UserBugRedHomePage homePage;

    public UserBugRedHomePageStep() {
        this.homePage = new UserBugRedHomePage(driver);
    }

    @Then("^profile button should contain '([^\"].+)' on Main page$")
    public void profileButtonShouldContainTextOnMainPage(final String expectedUsername) {
        String actualUsername = homePage.getTextFromUsernameDropdown();

        assertThat(actualUsername)
            .as("Username was incorrect")
            .isEqualToIgnoringCase(expectedUsername);
    }
}
