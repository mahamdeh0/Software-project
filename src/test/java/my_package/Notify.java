package my_package;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Notify {
	boolean state=true;
	Logging L;
	Order O;
	Worker W;
	String email;
	public String password;
	
	public Notify (){
		L=new Logging();
		L.password="worker123";
		O=new Order();
		W=new Worker();

	}
	@Given("that the worker whose email is {string} logged in")
	public void that_the_worker_whose_email_is_logged_in(String string) {
		L.logState(true);
		email = string;

	}

	@When("the order is marked as {string} to {string}")
	public void the_order_is_marked_as_to(String string, String string2) {
		O.setStatus(string);
		if(O.getStatus().equalsIgnoreCase("complete"))
			state=SendEmailExample.sendEmail(email, string, string2);
		else state=true;
	}

	@Then("the worker sends an email to the customer notify them that their order is complete")
	public void the_worker_sends_an_email_to_the_customer_notify_them_that_their_order_is_complete() {
   assertFalse(state);
	}

	@Then("the worker will not send an email to the customer notifying them that their order is complete")
	public void the_worker_will_not_send_an_email_to_the_customer_notifying_them_that_their_order_is_complete() {
	    assertTrue(state);
	}

	
	
	

}