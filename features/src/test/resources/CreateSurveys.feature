Feature: Create surveys

  As a User
  I want to be able to create surveys
  So that I can ask other users or guests about their opinion concerning a
  certain topic.

  Background:
    Given a registered user named "Greg"
    And I am a logged-in as "Greg"

  Scenario: A user creates a new survey with a title but without questions
    When I create a new survey called "My new survey" but without questions
    Then the survey "My new survey" should appear in my list of surveys
