package ru.levelp.at.lesson08.rest.assured;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class SimpleReqResTest {

    @Test
    public void getUserSimpleTest() {
        RestAssured
            .when()
            .get("https://reqres.in/api/users/2")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
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
            .log().all()
            .contentType(ContentType.JSON)
            .body("{\n"
                + "    \"name\": \"" + name + "\",\n"
                + "    \"job\": \"" + job + "\"\n"
                + "}")
            .when()
            .post("https://reqres.in/api/users")
            .then()
            .log().all()
            .statusCode(201)
            .contentType("application/json")
            .body("id", Matchers.matchesRegex("\\d+"))
            .body("name", Matchers.equalTo(name))
            .body("job", Matchers.equalTo(job))
            .body("createdAt", Matchers.not(Matchers.emptyString()));
    }

    @Test
    public void getUsersSimpleTest() {
        RestAssured
            .given()
            .log().all()
            .when()
            .get("https://reqres.in/api/users")
            .then()
            .log().all()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("data.first_name", Matchers
                // .containsInAnyOrder("George", "Janet", "Emma", "Eve", "Charles", "Tracey")); так тоже можно
                .containsInAnyOrder(List.of("George", "Janet", "Emma", "Eve", "Charles", "Tracey")
                                        .toArray(new String[] {})));
    }

    @Test
    public void getSecondUsersSimpleTest() {
        RestAssured
            .given()
            .log().all()
            .when()
            .get("https://reqres.in/api/users")
            .then()
            .log().all()
            .statusCode(200)
            .contentType(ContentType.JSON)
            // json path индексы начинаются с 0
            .body("data.first_name[1]", Matchers.equalTo("Janet"));
    }

    @Test
    public void getUsersSimpleWithAssertJTest() {
        JsonPath actualBodyJsonPath = RestAssured
            .given()
            .log().all()
            .when()
            .get("https://reqres.in/api/users")
            .then()
            .log().all()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .extract()
            .body()
            .jsonPath();

        List<String> actualNamesList = actualBodyJsonPath.getList("data.first_name", String.class);

        assertThat(actualNamesList)
            .containsExactlyInAnyOrderElementsOf(List.of("George", "Janet", "Emma", "Eve", "Charles", "Tracey"));
    }
}
