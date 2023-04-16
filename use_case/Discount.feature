Feature: Discount Management
Description: Manage customer discounts

Background: 
   Given list of customers with their state.
    |1202587|  Abd Mahamdeh    | Nablus   |   0598741963  | 
    |1201597| Woroud Fouleh    | Nablus   |   0598741123  | 
    
Scenario: Apply Discount
Given the customer whose ID "1201597" has spent 500 NIS on orders
When When the customer has spent more than 400 NIS on orders 
Then the system applies a 10 % discount to the customer's next order