package fall2023project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class discount {
	
	Customer c;
	double ccost=0.0;
    private double totalDiscount;
    int index=-1;

    @Given("list of customers with their state.")
    public void list_of_customers_with_their_state(io.cucumber.datatable.DataTable dataTable) {
    	String ID,name , address ,phone ;
		for(int i=0; i< dataTable.height() ; i++){
			ID = dataTable.cell(i,0);
		    name = dataTable.cell(i,1);
			address = dataTable.cell(i,2);
			phone = dataTable.cell(i,3);
		

			c = new Customer (name,address,"cust123" , phone,ID,0.0,1);
			Customer.getCU().add(i, c);
			}

    }
    @Given("the customer whose ID {string} has spent {int} NIS on orders")
    public void the_customer_whose_id_has_spent_nis_on_orders(String string, Integer int1) {
    	String ID,name , address ,phone ;
		for(int i=0; i< Customer.getCU().size() ; i++) {
			if((Customer.getCU().get(i).getID().equals(string)))
					{
				    index=i;
					break;
					}
				}
		Double d=new Double(int1);
		Customer.getCU().get(index).cost=d;
		ccost=d;
	
		
    }
    

	@When("When the customer has spent more than {int} NIS on orders")
	public void when_the_customer_has_spent_more_than_nis_on_orders(int int1) {
  totalDiscount=int1;

	}

	@Then("the system applies a {int}% discount to the customer's next order")
	public void the_system_applies_a_discount_to_the_customer_s_next_order(int discountPercentage) {

	        if (ccost >  totalDiscount) {
	            // Apply discount to next order
	        	double per=(double)discountPercentage/100.0;
	            double discountAmount = per * ccost;
	            ccost=ccost-discountAmount;
	            // This step is just to represent the action of applying the discount to the next order
	            System.out.println("Discount of " + discountAmount + " NIS applied to next order");
	        } else {
	            // No discount applied
	            System.out.println("Customer not eligible for discount");
	        }
	    }


}
