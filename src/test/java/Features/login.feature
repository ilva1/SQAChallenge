Feature: LogIn
  This feature file deals with Login functionality of the website

  @tag1
  Scenario: Successful Login with correct username and password
    Given I am on main page
    Then I press on login page
    Then I enter email
    Then I enter password
    And  I click Login button
    Then I see dashboard

  Scenario: Missing email
    Given I am on main page
    Then I press on login page
    Then I enter password
    And  I click Login button
    Then I see error message for email

  Scenario: Missing password
    Given I am on main page
    Then I press on login page
    Then I enter email
    And  I click Login button
    Then I see error message for password

  Scenario: Enter wrong password
    Given I am on main page
    Then I press on login page
    Then I enter email
    Then I enter wrong password
    And  I click Login button
    Then I see error message for password/email

  Scenario: enter wrong username
    Given I am on main page
    Then I press on login page
    Then I enter wrong email
    Then I enter password
    And  I click Login button
    Then I see error message for email credential

  Scenario: enter wrong username and password
    Given I am on main page
    Then I press on login page
    Then I enter wrong email
    Then I enter wrong password even not the characters and required size
    And  I click Login button
    Then I see error message for email and password credential

  Scenario: see required fields
    Given I am on main page
    Then I press on login page
    Then I leave empty email
    Then I leave empty password
    And  I click Login button
    And error for password appears

  Scenario: forgot password feature
    Given I am on main page
    Then I press on login page
    Then I press Forgot Password?
    Then I should enter my email
    And press reset password
    Then I should see a page that informs me to check email

  Scenario: return feature check
    Given I am on main page
    Then I press on login page
    And I click the return button
    Then I should see main page
