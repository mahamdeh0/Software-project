package fall2023project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class admin_logout {
	
	public Admin ad;
	
	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
		  ad.LogState(true);
	
	}

	@When("the admin logs out")
	public void the_admin_logs_out() {
	
		ad.logout();
	}

	@Then("the admin is not logged in")
	public void the_admin_is_not_logged_in() {
		  ad.LogState(false);
	}


}
