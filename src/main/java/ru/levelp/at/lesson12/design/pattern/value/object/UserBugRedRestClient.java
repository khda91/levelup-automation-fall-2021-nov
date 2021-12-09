package ru.levelp.at.lesson12.design.pattern.value.object;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UserBugRedRestClient {

    private static final String DO_REGISTER = "/tasks/rest/doregister";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    public UserBugRedRestClient() {
        requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://users.bugred.ru")
            .setAccept(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    public Response registerUser(final String email, final String name, final String password) {
        return given()
            .spec(requestSpecification)
            .body(new UserRequest(email, name, password))
            .when()
            .post(DO_REGISTER)
            .andReturn();
    }

    public Response registerUser(final UserRequest requestBody) {
        return given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post(DO_REGISTER)
            .andReturn();
    }
}
