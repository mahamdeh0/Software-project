Feature: Discount Management
Description: Manage customer discounts


Scenario: Apply Discount
Given the customer has spent 500 NIS on orders
When When the customer has spent more than 400 NIS on orders 
Then the system applies a 10% discount to the customer's next order