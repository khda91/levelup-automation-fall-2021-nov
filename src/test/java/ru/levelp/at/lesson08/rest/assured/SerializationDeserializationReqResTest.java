package ru.levelp.at.lesson08.rest.assured;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson08.rest.assured.model.CreateUserDataRequest;
import ru.levelp.at.lesson08.rest.assured.model.CreateUserDataResponse;
import ru.levelp.at.lesson08.rest.assured.model.ListUserDataResponse;
import ru.levelp.at.lesson08.rest.assured.model.SingleUserDataResponse;
import ru.levelp.at.lesson08.rest.assured.model.SupportData;
import ru.levelp.at.lesson08.rest.assured.model.UserData;

public class SerializationDeserializationReqResTest {

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .setBaseUri("https://reqres.in/api")
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectContentType(ContentType.JSON)
            .build();
    }

    @Test
    public void getUserSimpleTest() {
        SingleUserDataResponse actualResponse = RestAssured
            .given()
            .spec(requestSpecification)
            .pathParam("id", "2")
            .pathParam("other", "smth")
            .when()
            .get("/users/{id}/{other}")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(SingleUserDataResponse.class);

        var expectedUserData = new UserData(2, "janet.weaver@reqres.in", "Janet", "Weaver",
            "https://reqres.in/img/faces/2-image.jpg");
        var expectedSupportData = new SupportData("https://reqres.in/#support-heading",
            "To keep ReqRes free, contributions towards server costs are appreciated!");
        var expectedSingleUserdataResponse = new SingleUserDataResponse(expectedUserData, expectedSupportData);

        assertThat(actualResponse).isEqualTo(expectedSingleUserdataResponse);
    }

    @Test
    public void createUserSimpleTest() {
        Faker faker = new Faker();
        var createUserRequest = new CreateUserDataRequest(faker.name().name(), faker.job().title());

        OffsetDateTime currentDateTime = OffsetDateTime.now();
        CreateUserDataResponse actualResponse = RestAssured
            .given()
            .spec(requestSpecification)
            .body(createUserRequest)
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreateUserDataResponse.class);

        var expectedResponse = new CreateUserDataResponse(null, createUserRequest.getName(),
            createUserRequest.getJob(), null);

        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            .isEqualTo(expectedResponse);
        assertThat(actualResponse.getId())
            .isPositive();

        OffsetDateTime actualDate = OffsetDateTime.parse(actualResponse.getCreatedAt());
        assertThat(actualDate)
            .isCloseTo(currentDateTime, within(5, ChronoUnit.SECONDS));
    }

    @Test
    public void createUserSimpleSoftAssertionTest() {
        Faker faker = new Faker();
        var createUserRequest = new CreateUserDataRequest(faker.name().name(), faker.job().title());

        OffsetDateTime currentDateTime = OffsetDateTime.now();
        CreateUserDataResponse actualResponse = RestAssured
            .given()
            .spec(requestSpecification)
            .body(createUserRequest)
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreateUserDataResponse.class);

        var expectedResponse = new CreateUserDataResponse(null, createUserRequest.getName(),
            createUserRequest.getJob() + " asas", null);

        //        SoftAssertions.assertSoftly(softly -> {
        //            softly.assertThat(actualResponse)
        //                .usingRecursiveComparison()
        //                .ignoringExpectedNullFields()
        //                .isEqualTo(expectedResponse);
        //            softly.assertThat(actualResponse.getId())
        //                .isNegative();
        //
        //            OffsetDateTime actualDate = OffsetDateTime.parse(actualResponse.getCreatedAt());
        //            softly.assertThat(actualDate)
        //                .isCloseTo(currentDateTime, within(1, ChronoUnit.MICROS));
        //        });

        assertCreateUserDataResponse(actualResponse, expectedResponse, currentDateTime);
    }

    private void assertCreateUserDataResponse(final CreateUserDataResponse actualResponse,
                                              final CreateUserDataResponse expectedResponse,
                                              final OffsetDateTime currentDateTime) {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResponse)
                  .usingRecursiveComparison()
                  .ignoringExpectedNullFields()
                  .isEqualTo(expectedResponse);
            softly.assertThat(actualResponse.getId())
                  .isNegative();

            OffsetDateTime actualDate = OffsetDateTime.parse(actualResponse.getCreatedAt());
            softly.assertThat(actualDate)
                  .isCloseTo(currentDateTime, within(1, ChronoUnit.MICROS));
        });
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

    @Test
    public void getUsersTest() {
        ListUserDataResponse actualResponse = RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/users?page=2")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_OK)
            .extract().as(ListUserDataResponse.class);

        List<UserData> expectedUserData = List.of(
            new UserData(12, "rachel.howell@reqres.in", "Rachel", "Howell",
                "https://reqres.in/img/faces/12-image.jpg"),
            new UserData(10, "byron.fields@reqres.in", "Byron", "Fields",
                "https://reqres.in/img/faces/10-image.jpg"),
            new UserData(9, "tobias.funke@reqres.in", "Tobias", "Funke",
                "https://reqres.in/img/faces/9-image.jpg"),
            new UserData(11, "george.edwards@reqres.in", "George", "Edwards",
                "https://reqres.in/img/faces/11-image.jpg"),
            new UserData(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson",
                "https://reqres.in/img/faces/8-image.jpg"),
            new UserData(7, "michael.lawson@reqres.in", "Michael", "Lawson",
                "https://reqres.in/img/faces/7-image.jpg")
        );

        assertThat(actualResponse.getData())
            .containsExactlyInAnyOrderElementsOf(expectedUserData);
    }
}
