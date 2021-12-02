package ru.levelp.at.lesson10.jenkins;

import org.testng.annotations.Test;

public class UserBugRedRegisterUserTest extends SeleniumBaseTest {

    @Test
    public void registerUserTest() {
        String expectedUsername = FAKER.name().username();
        String userEmail = FAKER.internet().emailAddress();
        String userPassword = FAKER.internet().password();

        loginRegistrationStep.openLoginRegistrationPage();
        loginRegistrationStep.registerUser(expectedUsername, userEmail, userPassword);

        homePageStep.checkRegisteredUsername(expectedUsername);
    }
}
