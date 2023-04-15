Feature: Order 
Description: The customer requests a specific service
Actor: customer

Scenario: make Order
Given that the customer with ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741963" , email " mohammahd@gmail.com" is logged in
When the customer selects a  product with ID "6" , Name "CoverC" ,Category "Great cover cleaning" price "120" NIS
Then the system generates an invoice for the customer and updates the order status to "waiting"