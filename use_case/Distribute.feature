Feature: Distribute orders to workers
Description: The system distributes orders to available workers
Actor: Admin

Scenario: Distribute orders to workers
Given that the admin iis logged in
When the admin selects the "Distribute Orders" optionn
Then the system displays a list of orders that need to be distributed
And the admin can select a worker whose name "Abd Mahamdeh" to assign the order to