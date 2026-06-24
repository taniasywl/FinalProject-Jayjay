package api.stepdef;
import api.client.UserClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class UserSteps {
    UserClient userClient = new UserClient();

    Response response;
    String userId;

    boolean withoutAppId = false;

    @Given("user has valid app-id")
    public void userHasValidAppId() {
        withoutAppId = false;
    }

    @Given("user does not provide app-id")
    public void userDoesNotProvideAppId() {
        withoutAppId = true;
    }

    @Given("user already has created user")
    public void createUserBeforeTesting() {
        String body = """
                {
                  "title":"mr",
                  "firstName":"Tania",
                  "lastName":"Putri",
                  "email":"tania%s@mail.com"
                }
                """.formatted(System.currentTimeMillis());
        Response createResponse = userClient.createUser(body);
        userId = createResponse.jsonPath().getString("id");
    }

    @When("user sends GET request to tag endpoint")
    public void getTagList() {
        response = userClient.getTags();
    }

    @When("user sends GET request to user endpoint")
    public void getUserList() {
        if (withoutAppId) {
            response = userClient.getUsersWithoutAppId();
        } else {
            response = userClient.getUsers();
        }
    }

    @When("user sends POST request to create user")
    public void createUser() {
        String body = """
                {
                  "title":"mr",
                  "firstName":"Tania",
                  "lastName":"Putri",
                  "email":"tania%s@mail.com"
                }
                """.formatted(System.currentTimeMillis());
        response = userClient.createUser(body);
        userId = response.jsonPath().getString("id");
    }

    @When("user sends GET request by user id")
    public void getUserById() {
        response = userClient.getUserById(userId);
    }

    @When("user sends PUT request to update user")
    public void updateUser() {
        String body = """
                {
                  "firstName":"UpdatedName"
                }
                """;
        response = userClient.updateUser(userId, body);
    }

    @When("user sends DELETE request")
    public void deleteUser() {
        response = userClient.deleteUser(userId);
        System.out.println(response.asPrettyString());
    }

    @Then("status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("tag list should be displayed")
    public void verifyTagList() {
        assertNotNull(response.jsonPath().getList("data"));
    }

    @Then("user list should be displayed")
    public void verifyUserList() {
        assertNotNull(response.jsonPath().getList("data"));
    }

    @Then("user should be created successfully")
    public void verifyCreateUser() {
        assertNotNull(userId);
    }

    @Then("user detail should be displayed")
    public void verifyUserDetail() {
        assertEquals(userId,
                response.jsonPath().getString("id"));
    }

    @Then("response should contain user id")
    public void verifyUserId() {
        assertNotNull(response.jsonPath().getString("id"));
    }

    @Then("response should contain title")
    public void verifyTitle() {
        assertNotNull(response.jsonPath().getString("title"));
    }

    @Then("response should contain first name")
    public void verifyFirstName() {
        assertNotNull(response.jsonPath().getString("firstName"));
    }

    @Then("response should contain last name")
    public void verifyLastName() {
        assertNotNull(response.jsonPath().getString("lastName"));
    }

    @Then("response should contain email")
    public void verifyEmail() {
        assertNotNull(response.jsonPath().getString("email"));
    }

    @Then("user should be updated successfully")
    public void verifyUpdate() {
        assertEquals(
                "UpdatedName",
                response.jsonPath().getString("firstName")
        );
    }

    @Then("user should be deleted successfully")
    public void verifyDelete() {
        assertEquals(200, response.getStatusCode());
    }
}

