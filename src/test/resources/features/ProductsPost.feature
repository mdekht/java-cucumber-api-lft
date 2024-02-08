Feature: Create Products

  Scenario: Validate the creation of product
    Given I send POST to create valid product
    Then I verify that product created successfully

  Scenario: Negative test the product creation
    Given Verify that it's impossible to create product without required fields