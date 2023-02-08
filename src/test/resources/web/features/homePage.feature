@Smoke
Feature: HomePage
  Background:
    Given I am in automationtesting site

  Scenario: Home Page displays 3 Sliders
    When I click on Shop Menu
    And I click on Home Menu Button
    Then I can verify that the Home Page has 3 Sliders only

  Scenario: Home Page displays 3 Arrivals
    When I click on Shop Menu
    And I click on Home Menu Button
    Then I can verify that the Home Page has 3 Arrivals only

  Scenario: Images in Arrivals should navigate
    When I click on the image in the Arrivals in stock
    Then I am redirected to the Add to Basket Page

  Scenario: Add to Basket Home Arrival Items
      Given I click on the image in the Arrivals in stock
      And I am redirected to the Add to Basket Page
      When I click on the Add to Basket button
      And I can view my chosen item in the Products menu with its price
      And I go to View Basket
      Then I am led to final review of Basket page