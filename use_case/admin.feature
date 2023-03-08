Feature: Recording a full information of workers
Discription: A worker should enter all of own's informations(name,address,phone, gender and his email)
Actor: Admin

Background: 
   Given a list of workers with their state.
    |1202587|Abd Mahamdeh|Nablus|0598741963| 
    |1201597|Woroud Fouleh|Nablus|0598741123| 
Scenario: A worker was added succefully
Given that the admin is logged in 
And there is a worker with ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741963" 
Then a worker whose ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852" was added



Scenario: Delete a worker
Given that you want to delete a worker whose ID "1202587" , Name "Abd Mahamdeh", Address "Nablus" , Phone "0598741963"
And admin is logged in 
Then you delete all his information of a worker

Scenario: Update a worker information
Given that you want to update the name to "Kinan Adham" , ID "12345678" , Address "Ramallah" , Phone "05697418"
And admin is logged in 
When his own ID "1201597"
Then the information for a worker was updated

Scenario: Adding worker fails
Given that the admin is logged in 
And there is a worker with ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741852"

Then a worker is already exists

Scenario: Delete a worker fails
Given that you want to delete a worker whose ID "1202587" , Name "Abd Mahamdeh", Address "Nablus" , Phone "0598741852"
And admin is logged in or the worker is logged in
Then the worker you want to delete does not exist

Scenario: Update a worker information fails
Given that you want to update the name to "Kinan Adham" , ID "12345678" , Address "Ramallah" , Phone "05697418"
And admin is logged in
Then the worker you want to update his information does not exist