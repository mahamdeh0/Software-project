Feature: Generate Invoice

  Scenario: Customer generates ice for a multi-product order
    Given that the custome "12027619" , Name "Mohammad Loay", Address "Nablus" , Phone "0598741963" , email " mohammahd@gmail.com" is logged in system  
    When the customer selectth ID "6" , Name "CoverC" ,Category "Great cover cleaning" price "120" NIS
    And When the customer selecth "CarpetA" ,Category "Small carpet cleaning" price "50" NIS 
    And the customer generates an invoice
    Then the system displays the invoice forsend "complete"
    
    