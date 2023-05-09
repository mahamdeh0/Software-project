package my_package;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Statistics_steps {
	
	
	Logging ad;
	public String password;
	boolean state=false;
	Statistics s;
	public Statistics_steps() {
		ad=new Logging();
		ad.password="123456";
      s=new Statistics();
	}
	@Given("that admin is logged into the system")
	public void that_admin_is_logged_into_the_system() {
		  ad.logState(true);

	}

	@When("admin selects the {string} option")
	public void admin_selects_the_option(String string) {
		if(string.equals("Generate rebort"))
	    	state=true;
	}

	@Then("the system generates the statistics report and presents it to admin")
	public void the_system_generates_the_statistics_report_and_presents_it_to_admin() {
		 if(state) {
			 Statistics.statisticsReport();
			   assertTrue(state);
		 }
		   else assertFalse(state);
		}
	

	
	
	}



