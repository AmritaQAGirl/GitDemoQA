Feature: Search and place the order for products

@PlaceOrder
Scenario Outline: Search experience for product search in both Home page and Offers page

Given User is on GreenCart Landing page
When  User searched with search name <Name> and extracted actual name of product
And   Added "3" items of the selected product to cart
Then  User proceeds to Checkout and validate the <Name> items in checkout page
And   Verify user has ability to enter promo code and place the order

Examples:
|Name|
|Tom |