Feature: Recording a full information of customer
Discription: A customer should enter all of own's informations(name,address,phone, gender and his email)
Actor: Admin or worker

Background: 
   Given a list of customers with their state.
    |  1202587   |  Abd Mahamdeh    | Nablus   |   0598741963  | 
    |  1201597   | Woroud Fouleh    | Nablus   |   0598741123  | 
Scenario: A customer was added succefully
Given that the admin is logged in or the worker is logged in
And there is a customer with ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741963" 
Then a customer whose ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852" was added



Scenario: Delete a customer
Given that you want to delete a customer whose ID "1202587" , Name "Abd Mahamdeh", Address "Nablus" , Phone "0598741852"
And admin is logged in or the worker is logged in
Then you delete all his information of a customer

Scenario: Update a customer information
Given that you want to update a name to "Kinan Adham" , ID "12345678" , Address "Ramallah" , Phone "05697418"
And admin is logged in or the worker is logged in
When his ID "1201597"
Then the information for a customer was updated

Scenario: Adding customer fails
Given that the admin is logged in or the worker is logged in
And there is a customer with ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852"

Then a customer is already exists

Scenario: Delete a customer fails
Given that you want to delete a customer whose ID "1202587" , Name "Abd Mahamdeh", Address "Nablus" , Phone "0598741852"
And admin is logged in or the worker is logged in
Then the customer you want to delete does not exist

Scenario: Update a customer information fails
Given that you want to update a name to "Kinan Adham" , ID "12345678" , Address "Ramallah" , Phone "05697418"
And admin is logged in or the worker is logged in
Then the customer you want to update his information does not exist