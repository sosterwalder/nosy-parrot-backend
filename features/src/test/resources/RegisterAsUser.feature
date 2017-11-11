Feature: Register as user

  As a Guest
  I want to be able to register myself as user
  So that I can ask other users or guests about their opinion concerning a
  certain topic.

  Scenario: A guest registers himself successfully as a user
    When I register myself as user "someuser" with the password "123Qwe"
    Then I am registered within the system

  Scenario: A registered user authenticates himself
    Given I am a registered user
    When I authenticate myself
    Then I receive a confirmation that I am authenticated