#Author: gkm010@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
Feature: Login to Amazon account

  Background: Open amazon login url
    Given open url "https://www.amazon.in" in browser

  Scenario: Login with mobile number
    Given "Login" textbox is displayed
    And "Continue" button is displayed
    When I type "99999999" in "Login" textbox
    And I click on "Continue" button
    Then "99999999" is displayed
    And "Password" textbox is displayed
    And "Login" button is displayed
    When I type "password123" in "Password" textbox
    And I click on "Login" button
    Then I am logged in

  Scenario: Login with email id
    Given There is "Hello, Sign in" option
    When I hover over "Hello, Sign in" option
    Then A pop-up with "Sign in" button is displayed
    When I click on "Sign in" button on the pop-up
    Then "Login" textbox is displayed
    And "Continue" button is displayed
    When I type "demo@gmail.com" in "Login" textbox
    And I click on "Continue" button
    Then "demo@gmail.com" is displayed
    And "Password" textbox is displayed
    And "Login" button is displayed
    When I type "password123" in "Password" textbox
    And I click on "Login" button
    Then I am logged in

  Scenario Outline: Login with invalid credentials
    Given There is "Hello, Sign in" option
    When I hover over "Hello, Sign in" option
    Then A pop-up with "Sign in" button is displayed
    When I click on "Sign in" button on the pop-up
    Then "Login" textbox is displayed
    And "Continue" button is displayed
    When I type "<userId>" in "Login" textbox
    And I click on "Continue" button
    Then "<userId>" is displayed
    And "Password" textbox is displayed
    And "Login" button is displayed
    When I type "<password>" in "Password" textbox
    And I click on "Login" button
    Then User is unable to login

    Examples: 
      | userId         | password    |
      |     9191919191 | password000 |
      |     9090909090 | password123 |
      | demo@gmail.com | password000 |
      | bad@gmail.com  | password123 |
