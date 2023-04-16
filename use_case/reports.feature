Feature: Generate customized reports
Description: The system generates customized reports about business
Actor: Admin

Scenario: Generate a customized report
Given that the admin is logged in system
When the admin selects the "Generate Report" option
Then the system generates and displays the customized report