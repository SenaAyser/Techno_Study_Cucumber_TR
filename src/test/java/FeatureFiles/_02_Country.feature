Feature: Country Functionality

  Scenario:  Create Country

    Given Navigate to Campus
    When Enter username and password and click Login Button
    Then User should login successfully
    And Navigate to country page
    When Create a country
    Then Success message should be displayed