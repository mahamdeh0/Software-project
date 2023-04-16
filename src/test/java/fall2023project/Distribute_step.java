package fall2023project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Distribute_step {
	Logging ad;
	Admin a;
    String choice;
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
		  ad.LogState(true);

	}

	@When("the admin selects the {string} optionn")
	public void the_admin_selects_the_optionn(String string) {
         choice=string;
	}

	@Then("the system displays a list of orders that need to be distributed")
	public void the_system_displays_a_list_of_orders_that_need_to_be_distributed() {
             if(choice.equalsIgnoreCase("Distribute Orders"))
            	 show=true;
		
	}

	@Then("the admin can select a worker to assign the order to")
	public void the_admin_can_select_a_worker_to_assign_the_order_to() {
	   if(show) {
		   a.list_W(W.getW());
		   assertTrue(show);
	   }
	   else assertFalse(show);
	}



}