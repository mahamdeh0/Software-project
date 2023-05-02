package fall2023project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class statistics_steps {
	
	Logging ad;
	public String password;
	boolean state=false;
	statistics s;
	public statistics_steps() {
		ad=new Logging();
		ad.password="123456";
      s=new statistics();
	}
	
	
	@Given("that the admin is logged into the system")
	public void that_the_admin_is_logged_into_the_system() {
		
		  ad.logState(true);

	}

	@When("the admin selects the {string} selection")
	public void the_admin_selects_the_selection(String string) {
	    
		if(string.equals("Generate Report"))
	    	state=true;
	}

	@Then("the system generates the statistics report and presents it to the admin")
	public void the_system_generates_the_statistics_report_and_presents_it_to_the_admin() {

		   if(state) {
			   s.statisticsReport();
			   assertTrue(state);
		   }
		   else assertFalse(state);
		}

	}


