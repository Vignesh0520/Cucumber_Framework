@regression
Feature: Adactin Hotel Booking

  Scenario: Successful login to Adactin website
    Given The user is on the Adactin login page
    When The user logs in with username "Vignesh7094772888" and password "Vignes@0"
    Then The user should be logged in successfully

  Scenario: Search for a hotel on the Adactin website
    Given The user is on the Adactin hotel search page
    When The user selects the location as "Sydney", hotel as "Hotel Creek", and room type as "Super Deluxe"
    
  Scenario: Select a hotel from the search results
    Given The hotel search results are displayed
    When The user selects a hotel from the list and clicks on the Continue button
    Then The user should be navigated to the hotel booking page