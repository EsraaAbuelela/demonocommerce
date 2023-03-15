@smoke
Feature: user able to hover categories and select sub-category
  Scenario: user able to hover category and select sub-category
    Given user hover on "Computers" category
    When  Category contains sub categories
    And user select "Desktops" as sub Category
    Then sub-category "Desktops" page opened
