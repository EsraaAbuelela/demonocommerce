@smoke
Feature: verify user can use Euro Currency
  Scenario: verify user can change currency to Euro
    When User select Euro currency from HomePage
    Then All products should be in Euro Currency