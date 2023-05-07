Feature: Notify customer when order is complete
Actor: worker

Scenario: Notify customer by email

Given that the worker whose email is "woroudfouleh26@gmail.com" logged in 
When the order is marked as "complete" to "Test Email"
Then the worker sends an email to the customer notify them that their order is complete

Scenario: Notify customer by email failed

Given that the worker whose email is "woroudfouleh26@gmail.com" logged in 
When the order is marked as " not complete" to "Test Email"
Then the worker will not send an email to the customer notifying them that their order is complete