@Smoke
Feature: HomePage
  Background:
    Given I am in automationtesting site

  Scenario:  Home Page displays 3 Sliders
    When I click on Shop Menu
    And I click on Home Menu Button
    Then I can verify that the Home Page has 3 Sliders only

  Scenario:  Home Page displays 3 Arrivals
    When I click on Shop Menu
    And I click on Home Menu Button
    Then I can verify that the Home Page has 3 Arrivals only