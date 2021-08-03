Feature: Sorting products

  @sort
  Scenario: As user i want to sort product by lowest first
    Given user open homepage
    And user are in product list page "Women"
    When user sort product by "Price: Lowest first"
    Then user verified that products are sorted by lowest price