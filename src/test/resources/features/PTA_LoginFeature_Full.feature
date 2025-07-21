@regression
Feature: Login Functionality

  Background:
    Given User is on the login page

  @smoke
  Scenario: Successful login with valid credentials
    When User enters "student" and "Password123"
    Then Close the browser

  @login
  Scenario Outline: Login attempts with multiple credentials
    When User enters with "<username>" and "<password>"
    Then Close the browser

    Examples:
      |username|password|
      |student|Password123|
      |incorrectUser|Password123|
      |student|incorrectPassword|