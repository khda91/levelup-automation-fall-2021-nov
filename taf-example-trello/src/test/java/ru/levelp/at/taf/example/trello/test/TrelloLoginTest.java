package ru.levelp.at.taf.example.trello.test;

import org.junit.jupiter.api.Test;
import ru.levelp.at.taf.example.trello.data.TrelloUserDataProvider;

class TrelloLoginTest extends TrelloBaseTest {

    @Test
    void loginTest() {
        loginPageStep.openLoginPage();
        loginPageStep.loginToTrello(TrelloUserDataProvider.getDefaultTrelloUser());

        commonStep.checkThatUserIconIsDisplayed();
    }
}
