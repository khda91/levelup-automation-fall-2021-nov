package ru.levelp.at.lesson12.design.pattern.builder;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRequestBuilderTest {

    private static final Faker FAKER = new Faker();

    private UserBugRedRestClient client;

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {UserRequest.builder().email(FAKER.internet().emailAddress())
                .name(FAKER.name().fullName())
                .password(FAKER.internet().password())
                .build()},
            {UserRequest.builder().email(FAKER.internet().emailAddress())
                        .name(FAKER.name().fullName())
                        .password(FAKER.internet().password())
                .build()},
            {UserRequest.builder().email(FAKER.internet().emailAddress())
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
    public void builderTest(UserRequest userRequest) {
        client.registerUser(userRequest)
              .then()
              .statusCode(HttpStatus.SC_OK);
    }

    @DataProvider
    public Object[][] negativeDataProvider() {
        return new Object[][] {
            {UserRequest.builder()
                        .email(FAKER.internet().emailAddress())
                .build()},
            {UserRequest.builder()
                        .name(FAKER.name().fullName())
                .build()},
            {UserRequest.builder()
                        .password(FAKER.internet().password())
                .build()}
        };
    }

    @Test(dataProvider = "negativeDataProvider")
    public void negativeBuilderTest(UserRequest userRequest) {
        client.registerUser(userRequest)
              .then()
              .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
