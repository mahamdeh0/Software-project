Feature: Notify customer when order is complete
Actor: worker

Scenario: Notify customer by email

Given that the worker is logged in system
When the order is marked as "complete"
Then the worker sends an email to the customer notifying them that their order is complete