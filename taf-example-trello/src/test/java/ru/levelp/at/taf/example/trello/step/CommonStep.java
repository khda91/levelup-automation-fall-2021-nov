package ru.levelp.at.taf.example.trello.step;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.example.trello.service.page.TrelloLoginPage;

public class CommonStep extends BaseStep {

    TrelloLoginPage loginPage;

    public CommonStep(WebDriver driver) {
        loginPage = new TrelloLoginPage(driver);
    }

    public void checkThatUserIconIsDisplayed() {
        assertThat(loginPage.header().isHeaderMemberMenuButtonDisplayed())
            .as("User was not log in")
            .isTrue();
    }
}
