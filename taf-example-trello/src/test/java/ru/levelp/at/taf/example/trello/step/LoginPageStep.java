package ru.levelp.at.taf.example.trello.step;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.example.trello.model.TrelloUser;
import ru.levelp.at.taf.example.trello.service.page.TrelloLoginPage;

public class LoginPageStep extends BaseStep {

    TrelloLoginPage loginPage;

    public LoginPageStep(WebDriver driver) {
        this.loginPage = new TrelloLoginPage(driver);
    }

    public void openLoginPage() {
        loginPage.open();
    }

    public void loginToTrello(TrelloUser user) {
        loginPage.sendKeysToUsernameTextField(user.getUserEmail());
        loginPage.clickToLoginButton();
        loginPage.sendKeysToPasswordTextField(user.getUserPassword());
        loginPage.clickToLoginSubmitButton();
    }
}
