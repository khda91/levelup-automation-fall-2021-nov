package ru.levelp.at.lesson08.rest.assured.client;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.response.Response;
import java.util.Collections;
import java.util.Map;
import ru.levelp.at.lesson08.rest.assured.model.CreateUserDataRequest;

public class ReqResClient {

    private static final String USERS_ENDPOINT = "/users";
    private static final String USER_ENDPOINT = USERS_ENDPOINT + "/{id}";

    /**
     * <p>
     * Allow get user with id.
     * </p>
     * HttpMethod: GET, endpoint - /users.
     *
     * @param userId - id of required user
     *
     * @return general Rest-Assured response which could be cast to
     *
     *     <li>
     *         <ul>{@link ru.levelp.at.lesson08.rest.assured.model.SingleUserDataResponse}
     *         - if success</ul>
     *         <ul>#link_to_error_reponse class - if error</ul>
     *     </li>
     */
    public Response getUser(String userId) {
        return when()
            .get(USER_ENDPOINT, userId)
            .andReturn();
    }

    public Response createUser(final CreateUserDataRequest createUserDataRequest) {
        return given()
            .body(createUserDataRequest)
            .when()
            .post(USERS_ENDPOINT)
            .andReturn();
    }

    public Response getUsers() {
        return getUsers(Collections.emptyMap());
    }

    public Response getUsers(final Map<String, String> queryParams) {
        return given()
            .queryParams(queryParams)
            .when()
            .get(USERS_ENDPOINT)
            .andReturn();
    }
}
