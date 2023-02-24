Feature: Discount Management
Description: Manage customer discounts
Actor: Admin

Scenario: Apply Discount
Given that the admin is logged in
And there are existing customers and orders in the system
When the admin selects a customer
And the customer has spent more than 400 NIS on orders
Then the system applies a 10% discount to the customer's next order