@regression
Feature: Login functionality with multiple input types

  Scenario: Login without using datatable
    When I login with username "student" and password "Password123"

  Scenario: Login using datatable without header
    When I login using below credentials
      |student|Password123|
      |incorrectUser|Password123|
      |student|incorrectPassword|
      
  Scenario: Login using credentials with headers
    When I login using credentials with headers
      |username|password|
      |student|Password123|
      |incorrectUser|Password123|
      |student|incorrectPassword|