Feature: Apply Voucher
  This feature file deals with apply voucher functionality of the website

  @tag2
  Scenario: Add Item and add the voucher successfully
    Given I am on main page
    Then I press on login page
    Then I enter email
    Then I enter password
    And  I click Login button
    Then I see dashboard
    Then I go to bags
    Then I add new item in shopping bag
    And i go to my bag
    Then I apply the voucher with the code successfully

    Scenario: Leave voucher code empty and try to apply it
      Given I am on main page
      Then I press on login page
      Then I enter email
      Then I enter password
      And  I click Login button
      Then I see dashboard
      Then I go to bags
      Then I add new item in shopping bag
      And i go to my bag
      Then I try to apply code nothing happens



