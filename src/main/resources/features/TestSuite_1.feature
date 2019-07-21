Feature: first

  @Regression
  Scenario: Log In - valid email
    Given Navigate to login page
    When Type email "mayajkamath@gail.com "
    Then Type Password "dd"
    And Push Sign In button
    And Make sure user name is "Maya"

  @Regression
  Scenario: Log In - invalid password
    Given  Navigate to login page
    When Type email "skirro7k@muhdioso8abts2yy.gq"
    Then Type Password "123456"
    And Push Sign In button
    And Error message displayed: "Authentication failed"
#    And Error message displayed: "ERROR MESSAGE"