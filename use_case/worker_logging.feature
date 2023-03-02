Feature: Worker login
Description: Worker during his logging into the system goes through several cases and logging out
Actor: Worker

Scenario: Worker can login 
Given that the worker is not logged in 
And the password  "worker123"
Then the login worker operation succeeds
And the worker is logged in

Scenario: Worker enter wrong password
Given that the worker is not logged in
And the password  "Wrong_password"
Then the login operation fail
And the worker is not logged in 

Scenario: Worker logs out
	Given that the worker is logged in
	When the worker logs out
	Then the worker is not logged in