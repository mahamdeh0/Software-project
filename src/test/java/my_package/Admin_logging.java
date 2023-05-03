package my_package;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class Admin_logging {
	
	
	Logging ad;
	Admin a;
	public String password;
	
	public Admin_logging() {
		ad=new Logging();
		ad.password="123456";
	}
	
	
	@Given("that the admin is not logged in")
	public void that_the_admin_is_not_logged_in() {
		
		ad.logState(false);
	}

	@Given("the password is {string}")
	public void the_password_is(String string) {
		
		password = string;
	}

	@Then("the login operation succeeds")
	public void the_login_operation_succeeds() {
		
		 assertTrue(ad.login(password));
	}

	@Then("the admin is logged in")
	public void the_admin_is_logged_in() {
		
		assertTrue(ad.getLogState());
	}

	@Then("the login operation fails")
	public void the_login_operation_fails() {
		
		assertFalse(ad.login(password));
	}
	
	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
		  ad.logState(true);
	
	}

	@When("the admin logs out")
	public void the_admin_logs_out() {
	
		ad.logout();
	}

	@Then("the admin is not logged in")
	public void the_admin_is_not_logged_in() {
		  ad.logState(false);
	}



}