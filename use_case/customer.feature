Feature: Recording a full information of customer
Discription: A customer should enter all of own's informations(name,address,phone, gender and his email)
Actor: Admin

Scenario: A customer was added succefully
Given that the admin is logged in
And there is a customer with ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852"
When the customer is added to the system
Then a customer whose ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852" was added



Scenario: Delete a customer
Given that you want to delete a customer whose ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852"
And the admin is logged in
Then you delete all his information of a customer

Scenario: Update a customer information
Given that you want to update a name to "Kinan Adham" , ID "12345678" , Address "Ramallah" , Phone "05697418"
And admin is logged in 
Then the information for a customer was updated

Scenario: Adding customer fails
Given that the admin is logged in
And there is a customer with ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852"
When an admin want to add customer
Then a customer is already exists

Scenario: Delete a customer fails
Given that you want to delete a customer whose ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852"
And the admin is logged in
Then the customer you want to delete does not exist

Scenario: Update a customer information fails
Given that you want to update a name to "Kinan Adham" , ID "12345678" , Address "Ramallah" , Phone "05697418"
And admin is logged in  
Then the customer you want to update his information does not exist 
