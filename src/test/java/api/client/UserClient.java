package api.client;

import io.restassured.response.Response;

import static api.utils.BaseAPI.APP_ID;
import static api.utils.BaseAPI.BASE_URL;
import static io.restassured.RestAssured.given;

public class UserClient {
    public Response getTags() {
        return given()
                .baseUri(BASE_URL)
                .header("app-id", APP_ID)
                .when()
                .get("/tag");
    }

    public Response getUsers() {
        return given()
                .baseUri(BASE_URL)
                .header("app-id", APP_ID)
                .when()
                .get("/user");
    }

    public Response getUsersWithoutAppId() {
        return given()
                .baseUri(BASE_URL)
                .when()
                .get("/user");
    }

    public Response createUser(String body) {
        return given()
                .baseUri(BASE_URL)
                .header("app-id", APP_ID)
                .contentType("application/json")
                .body(body)
                .when()
                .post("/user/create");
    }

    public Response getUserById(String userId) {
        return given()
                .baseUri(BASE_URL)
                .header("app-id", APP_ID)
                .when()
                .get("/user/" + userId);
    }

    public Response updateUser(String userId, String body) {
        return given()
                .baseUri(BASE_URL)
                .header("app-id", APP_ID)
                .contentType("application/json")
                .body(body)
                .when()
                .put("/user/" + userId);
    }

    public Response deleteUser(String userId) {
        return given()
                .baseUri(BASE_URL)
                .header("app-id", APP_ID)
                .when()
                .delete("/user/" + userId);
    }
}
