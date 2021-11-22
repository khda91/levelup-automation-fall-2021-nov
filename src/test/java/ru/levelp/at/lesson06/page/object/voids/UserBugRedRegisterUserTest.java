package ru.levelp.at.lesson06.page.object.voids;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson06.page.object.SeleniumBaseTest;

public class UserBugRedRegisterUserTest extends SeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void registerUserTest() {
        String expectedUsername = FAKER.name().username();

        var userBugRedLoginRegistrationPage = new UserBugRedLoginRegistrationPage(driver);
        userBugRedLoginRegistrationPage.open();

        userBugRedLoginRegistrationPage.inputTextToUsernameTextField(expectedUsername);
        userBugRedLoginRegistrationPage.inputTextToUserEmailTextField(FAKER.internet().emailAddress());
        userBugRedLoginRegistrationPage.inputTextToUserPasswordTextField(FAKER.internet().password());
        userBugRedLoginRegistrationPage.clickToRegisterButton();

        var userBugRedHomePage = new UserBugRedHomePage(driver);
        String actualUsername = userBugRedHomePage.getTextFromUsernameDropdown();

        assertThat(actualUsername)
            .as("Username was incorrect")
            .isEqualToIgnoringCase(expectedUsername);
    }
}
