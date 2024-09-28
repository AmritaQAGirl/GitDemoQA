Feature: Search and place the order for products

@OffersPage
Scenario Outline: Search experience for product search in both Home page and Offers page

Given User is on GreenCart Landing page
When  User searched with search name <Name> and extracted actual name of product
Then  User searched for same shortname <Name> in offers page
And   Validate offers page product name matches with product in Home page

Examples:
|Name|
|Tom |
|Beet|