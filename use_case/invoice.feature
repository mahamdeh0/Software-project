Feature: Generate Invoice

  Scenario: Customer generates an invoice for a multi-product order
    Given that the customer with ID "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741963" , email " mohammahd@gmail.com" is logged in system  
    When the customer selects a  product wwith ID "6" , Name "CoverC" ,Category "Great cover cleaning" price "120" NIS
    And When the customer selects a  product with  ID "1" , Name "CarpetA" ,Category "Small carpet cleaning" price "50" NIS 
    And the customer generates an invoice
    Then the system displays the invoice for the customer and send "done"