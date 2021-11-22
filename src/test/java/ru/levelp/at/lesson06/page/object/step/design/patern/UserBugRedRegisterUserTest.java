package ru.levelp.at.lesson06.page.object.step.design.patern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson06.page.object.SeleniumBaseTest;
import ru.levelp.at.lesson06.page.object.step.design.patern.step.UserBugRedHomePageStep;
import ru.levelp.at.lesson06.page.object.step.design.patern.step.UserBugRedLoginRegistrationStep;

public class UserBugRedRegisterUserTest extends SeleniumBaseTest {

    private UserBugRedLoginRegistrationStep loginRegistrationStep;
    private UserBugRedHomePageStep homePageStep;

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        loginRegistrationStep = new UserBugRedLoginRegistrationStep(driver);
        homePageStep = new UserBugRedHomePageStep(driver);
    }

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
