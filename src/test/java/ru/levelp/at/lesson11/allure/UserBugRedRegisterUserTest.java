package ru.levelp.at.lesson11.allure;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.levelp.at.lesson11.allure.listener.AllureListener;

@Epic("Тестовый эпик")
@Listeners(AllureListener.class)
public class UserBugRedRegisterUserTest extends SeleniumBaseTest {

    @Test(description = "Positive registration user test")
    @Description("Проверка что пользователь может зарегистрироваться в системе")
    @Link(name = "env.url", url = "http://users.bugred.ru/user/login/index.html")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Позитивная регистрация")
    @Story("Пользователь может зарегистрироваться")
    public void registerUserTest() {
        String expectedUsername = FAKER.name().username();
        String userEmail = FAKER.internet().emailAddress();
        String userPassword = FAKER.internet().password();

        loginRegistrationStep.openLoginRegistrationPage();
        loginRegistrationStep.registerUser(expectedUsername, userEmail, userPassword);

        homePageStep.checkRegisteredUsername(expectedUsername);
    }

    @Test(description = "Failed registration user test")
    @Description("Падающий тест что пользователь может зарегистрироваться в системе")
    @TmsLink("QATC-1")
    @Issue("PRBUG-2")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Падающая регистрация")
    @Story("Падающий тест при регистрации")
    public void failedRegisterUserTest() {
        String expectedUsername = FAKER.name().username();
        String userPassword = FAKER.internet().password();

        loginRegistrationStep.openLoginRegistrationPage();
        loginRegistrationStep.registerUser(expectedUsername, StringUtils.EMPTY, userPassword);

        homePageStep.checkRegisteredUsername(expectedUsername);
    }

    @Test(description = "Assetion Failed registration user test")
    @Description("Проверка что пользователь может зарегистрироваться в системе")
    @Severity(SeverityLevel.MINOR)
    @Feature("Падающая регистрация")
    @Story("Падающая регистрация по ассёрту")
    public void assertionFailedRegisterUserTest() {
        String expectedUsername = FAKER.name().username();
        String userEmail = FAKER.internet().emailAddress();
        String userPassword = FAKER.internet().password();

        loginRegistrationStep.openLoginRegistrationPage();
        loginRegistrationStep.registerUser(expectedUsername, userEmail, userPassword);

        homePageStep.checkRegisteredUsername(FAKER.internet().domainName());
    }
}
