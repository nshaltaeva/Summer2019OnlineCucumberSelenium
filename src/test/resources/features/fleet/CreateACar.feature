@create_car
Feature: Create new car

  Scenario: Create new car
    Given user is on the login page
    And user logs in as store manager
    Then user navigates to "Fleet" then to "Vehicles"
    And user click on "Create Car" button
    Then user adds new car information:
      | License Plate | Driver         | Location        | Model Year | Color  |
      | Test          | Test Driver    | Tampa, FL       | 2020       | Silver |
      | Superwoman    | Cool Driver    | Dallas, TX      | 2019       | Red    |
      | Superman      | Nice Driver    | Seatle, WA      | 2021       | Gold   |