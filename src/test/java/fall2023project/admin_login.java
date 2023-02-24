package fall2023project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class admin_login {
	
	
	Admin ad;
	public String password;
	
	@Given("that the admin is not logged in")
	public void that_the_admin_is_not_logged_in() {
		
		ad.LogState(false);
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



}
