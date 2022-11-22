@Smoke
Feature: Shop
  Background:
    Given I am in automationtesting site
    And I click on Shop Menu
    And I click on an item
    And I am redirected to the Add to Basket Page

  Scenario: View Basket through Item link
    Given I click on the Add to Basket button
    And I can view my chosen item in the Products menu with its price
    When I go to View Basket
    And I am led to final review of Basket page
    Then I can see the final values where I can verify that subtotal < total, as taxes are added to the subtotal
    And I click on Proceed to Checkout button
    And I am led to payment gateway page
    And I can view Billing Details, Order Details, Additional details and Payment gateway details
    And I can fill my details in billing details form
    And I can opt any payment in the payment gateway, like Direct bank transfer, cheque, cash or paypal
    And I click on Place Order button to complete process
    And I am led to Order confirmation page with order details, bank details, customer details and billing details

  Scenario: Add to and view Basket with Tax Functionality
    Given I click on the Add to Basket button
    And I can view my chosen item in the Products menu with its price
    When I go to View Basket
    And I am led to final review of Basket page
    Then I can see the final values where I can verify that subtotal < total, as taxes are added to the subtotal
    And Tax rate for indian should be 2% and for abroad it should be 5%