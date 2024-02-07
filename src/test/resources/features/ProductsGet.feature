Feature: Get Products

  Scenario Outline: Get Products with pagination
    Given I get Products with offset <offset> and limit <limit>
    Then I receive <amount> products

    Examples:
      | offset | limit | amount |
      | 0      | 10    | 10     |
      | 0      | 20    | 20     |
      | 10     | 30    | 20     |