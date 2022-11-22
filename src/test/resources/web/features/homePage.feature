@Ignore
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

  Scenario: Check out Total & Sub total condition for Home Arrival Items in Basket
    Given I click on the image in the Arrivals in stock
    And I am redirected to the Add to Basket Page
    And I click on the Add to Basket button
    And I can view my chosen item in the Products menu with its price
    When I go to View Basket
    And I am led to final review of Basket page
    Then I can see the final values where I can verify that subtotal < total, as taxes are added to the subtotal

  Scenario: Check out Payment Gateway Features
    Given I add an Arrival to Basket and Proceed to Checkout
    When I click on Proceed to Checkout button
    And I am led to payment gateway page
    Then I have the feasibility to add coupon
    And I can view Billing Details, Order Details, Additional details and Payment gateway details
    And I can fill my details in billing details form
    And I can opt any payment in the payment gateway, like Direct bank transfer, cheque, cash or paypal

  Scenario: Check out Place order
    Given I add an Arrival to Basket and Proceed to Checkout
    And I click on Proceed to Checkout button
    And I am led to payment gateway page
    And I have the feasibility to add coupon
    And I can view Billing Details, Order Details, Additional details and Payment gateway details
    And I can fill my details in billing details form
    And I can opt any payment in the payment gateway, like Direct bank transfer, cheque, cash or paypal
    When I click on Place Order button to complete process
    Then I am led to Order confirmation page with order details, bank details, customer details and billing details