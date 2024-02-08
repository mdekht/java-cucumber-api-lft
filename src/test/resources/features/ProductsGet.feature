Feature: Get Products

  Scenario: Validate all products have the price larger than 0
    Given I send GET to receive all the products
    Then I verify that all products has price more than 0

  Scenario Outline: Test different scenarios on the pager (validating that it returns the expected amount)
    Given I send GET to receive Products with offset <offset> and limit <limit>
    Then I verify that I receive <amount> products

    Examples:
      | offset | limit | amount |
      | 0      | 5     | 5      |
      | 10     | 15    | 15     |
      | 30     | 20    | 20     |

  Scenario Outline: Filter the products within 2 random prices and validate the returned products fall between the given prices
    Given I send GET to receive Products with min price <min price> and max price <max price>
    Then I verify that I receive products in the selected price range <min price> to <max price>

    Examples:
      | min price | max price |
      | 900       | 1000      |
      | 5         | 10        |