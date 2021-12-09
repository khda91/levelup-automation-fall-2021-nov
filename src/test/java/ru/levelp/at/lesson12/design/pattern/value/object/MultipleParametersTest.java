package ru.levelp.at.lesson12.design.pattern.value.object;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleParametersTest {

    private static final Faker FAKER = new Faker();

    private UserBugRedRestClient client;

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password()},
            {FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password()},
            {FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password()},
            {FAKER.name().fullName(), FAKER.internet().emailAddress(), FAKER.internet().password()}
        };
    }

    @BeforeMethod
    public void setUp() {
        client = new UserBugRedRestClient();
    }

    @Test(dataProvider = "dataProvider")
    public void multipleParametersTest(String name, String email, String password) {
        client.registerUser(email, name, password)
            .then()
            .statusCode(HttpStatus.SC_OK);
    }
}
