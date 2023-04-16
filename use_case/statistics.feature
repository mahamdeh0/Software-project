Feature: Generate statistics
Description: The system allows the admin to Generate statistics about, for example, total delivered items , total cash , total paid, total debts.

Actor: Admin

Scenario: Generate a statistics Report
Given that the admin is logged into the system
When the admin selects the "Generate statistics" selection
Then the system generates the statistics report and presents it to the admin