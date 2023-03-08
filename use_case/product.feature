Feature: Recording a full information of product
Actor: worker

Background: 
   Given a list of product with their state.
    |1|CarpetA|Small carpet cleaning|50|  
    |2|CarpetB|Medium carpet cleaning|100| 
    |3|CarpetC|Great carpet cleaning|150|
    |4|CoverA|Small cover cleaning|40|
    |5|CoverB|Medium cover cleaning|80|

    
    
Scenario: A product was added succefully
Given that the admin is logged in or the worker is logged in
And there is a product with ID "6" , Name "CoverC" ,Category "Great cover cleaning" price "120" NIS
Then a product whose ID "6" , Name "CoverC" ,Category "Great cover cleaning" , price "120" NIS  was added



Scenario: product a customer
Given that you want to delete a product whose ID "2" , Name "CarpetB" ,Category "Medium carpet cleaning" price "100" NIS
And admin is logged in or the worker is logged in
Then you delete all his information of a product

Scenario: Update a product information
Given that you want to update a name to ID "1" , Name "CarpetA" ,Category "Small carpet cleaning" price "50" NIS 
And admin is logged in or the worker is logged in
When its ID "1"
Then the information for a product was updated

