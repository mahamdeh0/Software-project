package fall2023project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Notify {
	boolean state=false;
	Logging L;
	Order O;
	Worker W;
	public String password;
	
	public Notify (){
		L=new Logging();
		L.password="worker123";
		O=new Order();
		W=new Worker();

	}
	
	@Given("that the worker is logged in system")
	public void that_the_worker_is_logged_in_system() {
		
		L.logState(true);

	}

	@When("the order is marked as {string}")
	public void the_order_is_marked_as(String string) {
		O.setStatus(string);
		if(O.getStatus().equalsIgnoreCase("complete"))
			state=true;

	}

	@Then("the worker sends an email to the customer notifying them that their order is complete")
	public void the_worker_sends_an_email_to_the_customer_notifying_them_that_their_order_is_complete() {
		
		if (state) {
			O.notifyCustomer(W);
			assertTrue(state);
		} else {
			assertFalse(state);
		}
	}

}