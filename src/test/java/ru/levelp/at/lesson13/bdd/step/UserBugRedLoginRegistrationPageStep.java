package ru.levelp.at.lesson13.bdd.step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.Map;
import ru.levelp.at.lesson13.bdd.UserBugRedLoginRegistrationPage;
import ru.levelp.at.lesson13.bdd.converter.DynamicTestDataConverter;

public class UserBugRedLoginRegistrationPageStep extends UserBugRedBaseStep {

    private UserBugRedLoginRegistrationPage loginRegistrationPage;

    public UserBugRedLoginRegistrationPageStep() {
        loginRegistrationPage = new UserBugRedLoginRegistrationPage(driver);
    }

    @Given("I open Login Register page")
    public void openLoginRegisterPage() {
        loginRegistrationPage.open();
    }

    @When("I login with credentials {string} in Login section on Login-Register page")
    public void loginWithCredentialsInLoginSectionOnLoginRegistrationPage(final String credentials) {
        String[] creds = credentials.split(":");
        loginRegistrationPage.inputTextToLoginUserEmailTextField(creds[0]);
        loginRegistrationPage.inputTextToLoginUserPasswordTextField(creds[1]);
        loginRegistrationPage.clickToLoginButton();
    }

    @When("I register user in Registration section on Login-Register page with credentials")
    public void registerUserInRegistrationSectionOnLoginRegisterPageWithCredentials(DataTable userData) {
        Map<String, String> userMap = userData.asMap();
        loginRegistrationPage.inputTextToRegisterUsernameTextField(userMap.get("username"));
        loginRegistrationPage.inputTextToRegisterUserEmailTextField(userMap.get("email"));
        loginRegistrationPage.inputTextToRegisterUserPasswordTextField(userMap.get("password"));
        loginRegistrationPage.clickToRegisterButton();
    }

    @When("I register user in Registration section on Login-Register page with dynamic credentials")
    public void registerUserInRegistrationSectionOnLoginRegisterPageWithDynamicCredentials(DataTable userData) {
        Map<String, String> userMap = new DynamicTestDataConverter().convertUserTestData(userData);
        System.out.println(userMap);
        loginRegistrationPage.inputTextToRegisterUsernameTextField(userMap.get("username"));
        loginRegistrationPage.inputTextToRegisterUserEmailTextField(userMap.get("email"));
        loginRegistrationPage.inputTextToRegisterUserPasswordTextField(userMap.get("password"));
        loginRegistrationPage.clickToRegisterButton();
    }
}
