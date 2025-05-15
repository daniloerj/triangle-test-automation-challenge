Feature: Triangle Validation

  Scenario: Validate Equilateral Triangle
    Given the user is on the triangle validation page
    And the user enters the name "Danilo"
    And the user enters the sides 5, 5, 5
    When the user submits the triangle validation form
    Then the application should indicate that the triangle is "equilateral"

  Scenario: Validate Isosceles Triangle
    Given the user is on the triangle validation page
    And the user enters the name "Danilo"
    And the user enters the sides 5, 5, 3
    When the user submits the triangle validation form
    Then the application should indicate that the triangle is "isosceles"

  Scenario: Validate Scalene Triangle
    Given the user is on the triangle validation page
    And the user enters the name "Danilo"
    And the user enters the sides 5, 4, 3
    When the user submits the triangle validation form
    Then the application should indicate that the triangle is "scalene"

  Scenario: Validate Invalid Triangle
    Given the user is on the triangle validation page
    And the user enters the name "Danilo"
    And the user enters the sides 1, 2, 3
    When the user submits the triangle validation form
    Then the application should indicate that the triangle is "notatriangle"