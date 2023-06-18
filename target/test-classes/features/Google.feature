Feature: Google search functionality
  Scenario: Validate the title and url after search
    Given user navigates to "https://www.google.com"
    When user searches for "Tesla"
    Then user should see "Tesla" in the url
    And user should see "Tesla" in the title