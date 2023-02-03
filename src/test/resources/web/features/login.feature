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

  Scenario:  Login Handles case sensitive
    When I enter a case changed username in Login User TextBox
    And I enter a case changed password in Login Password Textbox
    And I click on Login Button
    Then An error message will announce Login failure

  Scenario: Authentication ends at Log Out
    Given I am logged in
    When I log out of the site
    And I press the back button of my browser
    Then The login page must be visible
    And I shouldn’t be signed in to my account