package fall2023project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Worker_logging {
	Logging w;
	public String password;
	
	public  Worker_logging (){
		w=new Logging();
		w.password="worker123";

	}
	@Given("that the worker is not logged in")
	public void that_the_worker_is_not_logged_in() {
		w.logState(false);
	}

	@Then("the worker is logged in")
	public void the_worker_is_logged_in() {
		assertTrue(w.getLogState());
	}

	@Then("the worker is not logged in")
	public void the_worker_is_not_logged_in() {
		 w.logState(false);
	}

	@Given("that the worker is logged in")
	public void that_the_worker_is_logged_in() {
	   
		w.logState(true);
	}
	@Then("the login worker operation succeeds")
	public void the_login_worker_operation_succeeds() {
		assertTrue(w.login(password));
	}

	@When("the worker logs out")
	public void the_worker_logs_out() {
		w.logout();
	}
	
	@Given("the password  {string}")
	public void the_password(String string) {
		password = string;

	}

	@Then("the login operation fail")
	public void the_login_operation_fail() {
		
		assertFalse(w.login(password));

	}
}