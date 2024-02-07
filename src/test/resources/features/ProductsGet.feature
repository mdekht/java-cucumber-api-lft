Feature: Get Products

  Scenario Outline: Get Products with pagination
    Given I get Products with offset <offset> and limit <limit>
    Then I receive <amount> of products

    Examples:
      | offset | limit | amount         |
      | 0      | 10    | 10             |
      | 0      | 20    | limit - offset |
      | 10     | 30    | 20             |