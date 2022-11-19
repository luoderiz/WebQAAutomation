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
    When I enter <Username> in Login User TextBox
    And I enter <Password> in Login Password Textbox
    And I click on Login Button
    Then An error message will announce Login failure

    Examples:
      |       Username      |       Password      |
      |rraffaella@google.com|Raffaella0303456Carra|
      |raffaella@google.com |                     |
      |                     |Raffaella0303456Carra|
      |                     |                     |
      |RAFFAELLA@GOOGLE.COM |RAFFAELLA0303456CARRA|

  Scenario: Authentication ends at Log Out
    And I am logged in
    When I log out of the site
    And I press the back button of my browser
    Then The login page must be visible
    And I shouldn’t be signed in to my account