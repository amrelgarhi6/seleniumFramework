Feature: E2E Automated Test Script 
Description : MAke 

Scenario: Registered User Can Search the Product and add to Cart with Check Out

Given User is already opened web site 
When  User search the product
And   User Can add product to Cart
And   User navigate to cart page and Check Out Product and 
And   User enter the data and complete the process
Then  USer Can view the order and Download invoice