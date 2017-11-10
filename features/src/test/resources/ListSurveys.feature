Feature: List surveys

  As a user I want to see my created surveys so that I have an overview over
  all my surveys.

  Background:
    Given a registered user named "Betty"
    And I am a logged-in as "Betty"

  Scenario Outline: A user lists his surveys

    When "Betty" has created <input> surveys
    And she asks to retrieve her list of surveys
    Then she receives a list containing <output> surveys

    Examples:
      | input | output |
      | 0     | 0      |
      | 1     | 1      |
      | 2     | 2      |

