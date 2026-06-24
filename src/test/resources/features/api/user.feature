@API
Feature: User API Testing

  Scenario: Get list tags successfully
    Given user has valid app-id
    When user sends GET request to tag endpoint
    Then status code should be 200
    And tag list should be displayed

  Scenario: Get user list successfully
    Given user has valid app-id
    When user sends GET request to user endpoint
    Then status code should be 200
    And user list should be displayed

  Scenario: Create user successfully
    Given user has valid app-id
    When user sends POST request to create user
    Then status code should be 200
    And user should be created successfully

  Scenario: Get user by id successfully
    Given user already has created user
    When user sends GET request by user id
    Then status code should be 200
    And user detail should be displayed

  Scenario: Verify user response contains required fields
    Given user already has created user
    When user sends GET request by user id
    Then status code should be 200
    And response should contain user id
    And response should contain title
    And response should contain first name
    And response should contain last name
    And response should contain email

  Scenario: Update user successfully
    Given user already has created user
    When user sends PUT request to update user
    Then status code should be 200
    And user should be updated successfully

  Scenario: Delete user successfully
    Given user already has created user
    When user sends DELETE request
    Then status code should be 200
    And user should be deleted successfully

  Scenario: Access endpoint without app-id
    Given user does not provide app-id
    When user sends GET request to user endpoint
    Then status code should be 403