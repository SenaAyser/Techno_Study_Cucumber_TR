Feature: Country Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login Button
    Then User should login successfully
    And Navigate to country page


  @SmokeTest
  Scenario:  Create Country

    When Create a country
    Then Success message should be displayed