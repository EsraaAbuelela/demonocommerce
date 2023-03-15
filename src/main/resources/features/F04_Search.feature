@smoke
Feature: user able to search

  Scenario Outline:  user could search using product name
    Given user click on search textbox
    When user enter productName as "<Name>"
    And user click on search button
    Then search shows relevant results
    Examples:
      | Name   |
      | book   |
      | Laptop |
      | Nike   |

  Scenario Outline: user could search for product using sku
    Given user click on search textbox
    When user enter productName as "<Sku>"
    And user click on search button
    And user click on product displayed
    Then product contains same "<Sku>"
    Examples:
      | Sku   |
      | SCI_FAITH  |
      | APPLE_CAM |
      | SF_PRO_11   |