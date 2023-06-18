@Regression
  Feature: Front-end Project 4
    Background:
      Given user navigates to "https://techglobal-training.com/frontend/project-4"

    @TestCase01
    Scenario: Validate the default content of the inventory table
      Then the user should see the "Inventory" heading
      And the user should see the table with the headers below
        |Quantity|
        |Product|
        |Price $|
        |Total $|
      And the user should see the table with the rows below
        | 1 | iPhone  | 1,000 | 1,000 |
        | 3 | Airpods | 100   | 300   |
        | 2 | iPad    | 500   | 1,000 |
