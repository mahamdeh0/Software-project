package my_package;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Distribute_step {
	Logging ad;
	Admin a;
    String choice;
    String state;
    String name;

    Worker W;
    boolean show=false;
	public Distribute_step() {
		ad=new Logging();
		ad.password="123456";
		W=new Worker();
		a=new Admin();
	}
	
	@Given("that the admin iis logged in")
	public void that_the_admin_iis_logged_in() {
		  ad.logState(true);

	}

	@When("the admin selects the {string} optionn")
	public void the_admin_selects_the_optionn(String string) {
         choice=string;
	}

	@Then("the system displays a list of orders that need to be distributed")
	public void the_system_displays_a_list_of_orders_that_need_to_be_distributed() {
             Admin.listw(Worker.getW(),name);
		
	}
	@Then("the admin can select a worker whose name {string} to assign the order to whose state {string}")
	public void the_admin_can_select_a_worker_whose_name_to_assign_the_order_to_whose_state(String string, String string2) {
	   name=string;
	   state=string2;
   if(state.equals("available"))
   {
	   show=true;
	   
   }
   assertTrue(show);
	}

	@Then("the admin cannot select a worker whose name {string} to assign the order to whose state {string}")
	public void the_admin_cannot_select_a_worker_whose_name_to_assign_the_order_to_whose_state(String string, String string2) {
		   name=string;
		   state=string2;
		   if(state.equals("Not available"))
		   {
			   show=false;
			   
		   }
		   assertFalse(show);

	}


}

