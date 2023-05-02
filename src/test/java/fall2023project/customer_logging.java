package fall2023project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class customer_logging {
	
	
	
	Logging C;	
	public String password;
	
	public customer_logging() {
		C=new Logging();
		C.password="customer123";
	}
	
	
	
	@Given("that the customer is not logged in")
	public void that_the_customer_is_not_logged_in() {
	    
		C.logState(false);

	}

	@Given("password is {string}")
	public void password_is(String string) {

		password = string;

	}

	@Then("loginn operation succeeds")
	public void loginn_operation_succeeds() {

		 assertTrue(C.login(password));

	}

	@Then("the customer is logged in")
	public void the_customer_is_logged_in() {

		assertTrue(C.getLogState());

	}

	@Then("login operation fails")
	public void login_operation_fails() {

		assertFalse(C.login(password));

	}

	@Then("the customer is not logged in")
	public void the_customer_is_not_logged_in() {

		  C.logState(true);

	}

	@Given("that the customer is logged in")
	public void that_the_customer_is_logged_in() {

		C.logout();

	}

	@When("the customer logs out")
	public void the_customer_logs_out() {

		  C.logState(false);

	}

	

}
