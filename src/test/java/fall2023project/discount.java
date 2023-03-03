package fall2023project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class discount {
	
    private double totalSpentByCustomer;



    @Given("the customer has spent {int} NIS on orders")
    public void the_customer_has_spent_nis_on_orders(int totalSpent) {

        totalSpentByCustomer = totalSpent;

    }

	@When("When the customer has spent more than {int} NIS on orders")
	public void when_the_customer_has_spent_more_than_nis_on_orders(int int1) {


	}

	@Then("the system applies a {int}% discount to the customer's next order")
	public void the_system_applies_a_discount_to_the_customer_s_next_order(int discountPercentage) {

	        if (totalSpentByCustomer > 400) {
	            // Apply discount to next order
	            double discountAmount = 0.1 * totalSpentByCustomer;
	            // This step is just to represent the action of applying the discount to the next order
	            System.out.println("Discount of " + discountAmount + " NIS applied to next order");
	        } else {
	            // No discount applied
	            System.out.println("Customer not eligible for discount");
	        }
	    }


}
