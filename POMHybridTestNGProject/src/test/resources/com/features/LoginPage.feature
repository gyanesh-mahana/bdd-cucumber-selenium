#LoginPage feature
@All @LoginFeature
Feature: Login feature

  @login
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the login page
    Then title should be "Login - My Store"

  @login
  Scenario: forgot password link
    Given user is on login page
    Then Forgot your password? link should be displayed

  @login @critical
  Scenario: Login with valid credentials
    Given user is on login page
    When user type "demo@gkm.com" in email textbox
    And user type "abc123" in password textbox
    And user clicks on login button
    Then user gets the title of the account page
    And title should be "My account - My Store"

  @login @critical @negative
  Scenario Outline: Login with invalid credentials
    Given user is on login page
    When user type "<userId>" in email textbox
    And user type "<password>" in password textbox
    And user clicks on login button
    Then user gets error message

    Examples: 
      | userId       | password |
      | fake@abc.com | 21423rv  |
      | demo@gkm.com | 1234abc  |
      | fake@gkm.com | abc123   |
      | demo@gkm.com | abc123   |
