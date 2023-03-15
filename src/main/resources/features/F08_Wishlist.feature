@smoke
Feature: Add item to wishlist

  Scenario: verify success message after add product to wishlist
    Given user click on wish button for Product
    Then success message will be displayed
    And color of success message will be green


    Scenario: item added to wishlist successfully
      Given user click on wish button for Product
      Given user opens wishlist page
      Then Qty value is increased
