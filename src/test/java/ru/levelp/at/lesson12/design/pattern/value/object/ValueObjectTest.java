package ru.levelp.at.lesson12.design.pattern.value.object;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValueObjectTest {

    private static final Faker FAKER = new Faker();

    private UserBugRedRestClient client;

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {new UserRequest(FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password())},
            {new UserRequest(FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password())},
            {new UserRequest(FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password())},
            {new UserRequest(FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password())},
            {new UserRequest(FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password())}
        };
    }

    @BeforeMethod
    public void setUp() {
        client = new UserBugRedRestClient();
    }

    @Test(dataProvider = "dataProvider")
    public void multipleParametersTest(UserRequest userRequest) {
        client.registerUser(userRequest)
            .then()
            .statusCode(HttpStatus.SC_OK);
    }
}
