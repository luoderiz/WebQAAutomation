@Smoke
Feature: Login
  Background:
    Given I am in automationtesting site
    And I click on My Account Menu

  Scenario: Login success
    When I enter my valid existing username in the Login Textbox
    And I enter my valid password in the Login Textbox
    And I click on Login Button
    Then I am redirected to My Account Home Page


  Scenario Outline: Login failure
    When I enter <Email> in Login User TextBox
    And I enter <Password> in Login Password Textbox
    And I click on Login Button
    Then An error message will announce Login failure

    Examples:
      | Email                   | Password              |
      | rraffaella@google.com   | Raffaella0303456Carra |
      | raffaella@google.com    |                       |
      |                         | Raffaella0303456Carra |
      |                         |                       |
      | RAFFAELLA@GOOGLE.COM    | RAFFAELLA0303456CARRA |
