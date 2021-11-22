package ru.levelp.at.lesson06.page.object.fluent;

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

        var userBugRedHomePage = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .inputTextToUsernameTextField(expectedUsername)
            .inputTextToUserEmailTextField(FAKER.internet().emailAddress())
            .inputTextToUserPasswordTextField(FAKER.internet().password())
            .successClickToRegisterButton();

        String actualUsername = userBugRedHomePage.getTextFromUsernameDropdown();

        assertThat(actualUsername)
            .as("Username was incorrect")
            .isEqualToIgnoringCase(expectedUsername);
    }

    @Test
    public void registerUserNegativeTest() {
        String expectedUsername = FAKER.name().username();

        var actualErrorText = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .inputTextToUsernameTextField(expectedUsername)
            .inputTextToUserEmailTextField(FAKER.name().fullName())
            .inputTextToUserPasswordTextField(FAKER.internet().password())
            .failedClickToRegisterButton()
            .getTextFromErrorMessageLabel();

        assertThat(actualErrorText)
            .as("Error message was incorrect")
            .isEqualToIgnoringCase("register_not_correct_field (email)");
    }

    @Test
    public void registerUserNegativeExampleTest() {
        String expectedUsername = FAKER.name().username();

        var userBugRedLoginRegistrationPage = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .inputTextToUsernameTextField(expectedUsername)
            .inputTextToUserEmailTextField(FAKER.name().fullName())
            .inputTextToUserPasswordTextField(FAKER.internet().password());

        userBugRedLoginRegistrationPage.clickToRegisterButton();
        var actualErrorText = userBugRedLoginRegistrationPage.getTextFromErrorMessageLabel();

        assertThat(actualErrorText)
            .as("Error message was incorrect")
            .isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
