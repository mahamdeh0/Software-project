Feature: customer logging
Description: Admin during his logging into the system 
Actor: customer

Scenario: customer can login 
Given that the customer is not logged in 
And  password is "customer123"
Then  loginn operation succeeds
And the customer is logged in

Scenario: customer enter wrong password
Given that the customer is not logged in
And  password is "Wrong_password"
Then  login operation fails
And the customer is not logged in  

Scenario: customer logs out
	Given that the customer is logged in
	When the customer logs out
	Then the customer is not logged in 