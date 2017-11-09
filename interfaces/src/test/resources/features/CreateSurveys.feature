Feature: Create surveys

  As a User
  I want to be able to create surveys
  So that I can ask other users or guests about their opinion concerning a
  certain topic.

  Scenario: A user creates a new survey with a title but without questions
    Given I am a logged-in User
    When I create a new survey with a title but without questions
    Then the survey should appear in my list of surveys
