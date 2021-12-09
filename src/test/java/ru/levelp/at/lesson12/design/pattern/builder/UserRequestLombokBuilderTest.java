package ru.levelp.at.lesson12.design.pattern.builder;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRequestLombokBuilderTest {

    private static final Faker FAKER = new Faker();

    private UserBugRedRestClient client;

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {UserRequestLombok.builder().email(FAKER.internet().emailAddress())
                .name(FAKER.name().fullName())
                .password(FAKER.internet().password())
                .build()},
            {UserRequestLombok.builder().email(FAKER.internet().emailAddress())
                        .name(FAKER.name().fullName())
                        .password(FAKER.internet().password())
                .build()},
            {UserRequestLombok.builder().email(FAKER.internet().emailAddress())
                        .name(FAKER.name().fullName())
                        .password(FAKER.internet().password())
                .build()}
        };
    }

    @BeforeMethod
    public void setUp() {
        client = new UserBugRedRestClient();
    }

    @Test(dataProvider = "dataProvider")
    public void builderTest(UserRequestLombok userRequest) {
        client.registerUser(userRequest)
              .then()
              .statusCode(HttpStatus.SC_OK);
    }

    @DataProvider
    public Object[][] negativeDataProvider() {
        return new Object[][] {
            {UserRequestLombok.builder()
                        .email(FAKER.internet().emailAddress())
                .build()},
            {UserRequestLombok.builder()
                        .name(FAKER.name().fullName())
                .build()},
            {UserRequestLombok.builder()
                        .password(FAKER.internet().password())
                .build()}
        };
    }

    @Test(dataProvider = "negativeDataProvider")
    public void negativeBuilderTest(UserRequestLombok userRequest) {
        client.registerUser(userRequest)
              .then()
              .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
