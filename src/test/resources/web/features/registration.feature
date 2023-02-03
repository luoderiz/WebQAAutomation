@Smoke
Feature: Registration
  Background:
    Given I am in automationtesting site

  Scenario Outline: Registration failure due to empty fields
    When I click on My Account Menu
    And I enter <Email> in Register EmailAddress TextBox
    And I enter <Password> in Register Password Textbox
    And I click on Register Button
    Then An error message will announce Registration failure

    Examples:
      | Email               | Password                     |
      |                     | MyPassword1234$VerySecret$   |
      | user@email.com      |                              |
      |                     |                              |