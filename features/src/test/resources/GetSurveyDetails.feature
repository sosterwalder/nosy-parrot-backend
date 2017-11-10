Feature: Get the details of a survey

  As a User who has created at least one survey
  I want to be able to get the details of a survey
  So that I can ask other users or guests about their opinion concerning a
  certain topic.

  Background:
    Given a registered user named "John"
    And I am a logged-in as "John"

  Scenario: A user who has created a survey before gets the details of that
            survey
    When I have created survey called "My new survey" identified by 123
    And I request to get the details of my survey "My new survey" identified by 123
    Then I should should receive the details of my survey "My new survey" identified by 123
