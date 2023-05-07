Feature: Generate statistics
Actor: Admin

Scenario: Generate statistics Report
Given that admin is logged into the system
When  admin selects the "Generate statistics" option
Then the system generates the statistics report and presents it to admin