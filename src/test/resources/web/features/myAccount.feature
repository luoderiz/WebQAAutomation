@Ignore
Feature: Access MyAccount Success
  Background:
    Given I am in automationtesting site
    And I click on My Account Menu
    And I am logged in

  Scenario: Access and modify Account Details Success
    When I click on Account Details Button
    Then I can view my Details
    And I can change my password

  Scenario: My Account Logout Success
    And I click on My Account link
    When I log out of the site
    And I press the back button of my browser
    Then The login page must be visible
    And I shouldn’t be signed in to my account