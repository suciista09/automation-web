Feature: Checkout

  @checkout
  Scenario: As user I want to complete checkout process using Bank-Wire Payment
    Given user open homepage
    And user logged in into system using "suci.test@mailinator.com" "testing123"
    And user added product into cart from product list "Women"
    When user proceed to checkout from cart form
    And user completed checkout process using payment "Bank-Wire Payment"
    Then user verify order is confirmed