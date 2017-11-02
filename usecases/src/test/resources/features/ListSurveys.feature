Feature: List surveys

  As a user I want to see my created surveys so that I have an overview over
  all my surveys.

  Background:
    Given a user is logged in

  Scenario Outline: A user lists his surveys

    When the user has created <input> surveys
    And he asks to retrieve his list of surveys
    Then the user receives a list containing <output> surveys

    Examples:
      | input | output |
      | 0     | 0      |
      | 1     | 1      |
      | 2     | 2      |

