package ru.levelp.at.lesson08.rest.assured;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GlobalConfigurationReqResTest {

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectContentType(ContentType.JSON)
            .build();

        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.requestSpecification = this.requestSpecification;
        RestAssured.responseSpecification = this.responseSpecification;
    }

    @Test
    public void getUserSimpleTest() {
        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/users/2")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.id", Matchers.equalTo(2))
            .body("data.email", Matchers.equalTo("janet.weaver@reqres.in"))
            .body("data.first_name", Matchers.equalTo("Janet"))
            .body("data.last_name", Matchers.equalTo("Weaver"));
    }

    @Test
    public void createUserSimpleTest() {
        Faker faker = new Faker();
        String name = faker.name().name();
        String job = faker.job().title();
        RestAssured
            .given()
            .spec(requestSpecification)
            .body("{\n"
                + "    \"name\": \"" + name + "\",\n"
                + "    \"job\": \"" + job + "\"\n"
                + "}")
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(201)
            .body("id", Matchers.matchesRegex("\\d+"))
            .body("name", Matchers.equalTo(name))
            .body("job", Matchers.equalTo(job))
            .body("createdAt", Matchers.not(Matchers.emptyString()));
    }

    @Test
    public void getUsersSimpleTest() {
        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.first_name", Matchers
                // .containsInAnyOrder("George", "Janet", "Emma", "Eve", "Charles", "Tracey")); так тоже можно
                .containsInAnyOrder(List.of("George", "Janet", "Emma", "Eve", "Charles", "Tracey")
                                        .toArray(new String[] {})));
    }

    @Test
    public void getSecondUsersSimpleTest() {
        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            // json path индексы начинаются с 0
            .body("data.first_name[1]", Matchers.equalTo("Janet"));
    }

    @Test
    public void getUsersSimpleWithAssertJTest() {
        JsonPath actualBodyJsonPath = RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .extract()
            .body()
            .jsonPath();

        List<String> actualNamesList = actualBodyJsonPath.getList("data.first_name", String.class);

        assertThat(actualNamesList)
            .containsExactlyInAnyOrderElementsOf(List.of("George", "Janet", "Emma", "Eve", "Charles", "Tracey"));
    }
}
