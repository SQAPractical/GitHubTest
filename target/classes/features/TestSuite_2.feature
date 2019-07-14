Feature: second

  @Regression
  Scenario: Log In valid email
    Given Navigate to login page
    When Type email "qa.sofi@gmail.com"
    Then Type Password "12345"
    And Push Sign In button
    And Make sure user name is "Sofia"


  Scenario: Log In invalid email
    Given  Navigate to login page
    When Type email "skirro7k@muhdioso8abqqts2yy.gq"
    Then Type Password "12345"
    And Push Sign In button
    And Error message displayed: "Authentication failed."
    #And Error message displayed: "ERROR MESSAGE"

  @Regression
  Scenario: Quiz
    Given  Navigate to login page
    When Type email "qa.sofi@gmail.com"
    Then Type Password "12345"
    And Push Sign In button
    And Click on Quizzes on left navigational panel
    And Push Create new Quiz button
    And Type Title of the Quiz "SQA"
    And Click Add Question
    And Select Textual Type of questionOne
    And Type text of Question "one"
    And Push Save button
