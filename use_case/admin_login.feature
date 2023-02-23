Feature: Admin login
Description: Admin during his logging into the system goes through several cases

Scenario: Admin can login 
Given that the admin is not logged in 
And the password is "123456"
Then the login operation succeeds
And the admin is logged in

Scenario: Admin enter wrong password
Given that the admin is not logged in
And the password is "Wrong_password"
Then the login operation fails
And the admin is not logged in

Scenario: Admin forget the password
Given that the admin is not logged in
And the password forgotten
Then the new password enterd
And the admin is logged in

