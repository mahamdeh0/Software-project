package fall2023project;

import io.cucumber.java.en.Given;
import java.util.ArrayList;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Customer_steps  {
	public int ind;
	Admin A;
	Customer C;
	public ArrayList <Customer> customersList=new ArrayList <Customer>();
	
	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
		A.LogState(true);
		
	}

	@Given("there is a customer with ID {string} , Name {string}, Address {string} , Phone {string}")
	public void there_is_a_customer_with_id_name_address_phone(String string, String string2, String string3, String string4) {
		
		int ind= C.find(customersList, string);
		
		if(ind==-1) C.addState(false);
		else {
	    C.addState(true);	
		C.setID(string);
		C.setName(string2);
		C.setAddress(string3);
		C.setPhone(string4);
		customersList.add(C);
		}
		
	}



	@Then("a customer whose ID {string} , Name {string}, Address {string} , Phone {string} was added")
	public void a_customer_whose_id_name_address_phone_was_added(String string, String string2, String string3, String string4) {
		
		C.addState(true);
	}


	@Given("that you want to delete a customer whose ID {string} , Name {string}, Address {string} , Phone {string}")
	public void that_you_want_to_delete_a_customer_whose_id_name_address_phone(String string, String string2, String string3, String string4) {
       ind= C.find(customersList,string);
       if(ind == -1) C.deleteState(false);
       else {
    	   C.deleteState(true);
    	   customersList.remove(ind);
    	   
       }
       
	}

	@Given("the admin is logged in")
	public void the_admin_is_logged_in() {
		A.LogState(true);
	}

	@Then("you delete all his information of a customer")
	public void you_delete_all_his_information_of_a_customer() {
	    assertTrue(C.getdeleteState());
	}

	@Given("that you want to update a name to {string} , ID {string} , Address {string} , Phone {string}")
	public void that_you_want_to_update_a_name_to_id_address_phone(String string, String string2, String string3, String string4) {
          ind=C.find(customersList, string2);
          if(ind == -1) C.updateState(false);
          else {
       	   C.updateState(true);
       	   customersList.get(ind).setName(string);
       	   customersList.get(ind).setID(string2);
       	   customersList.get(ind).setAddress(string3);
       	   customersList.get(ind).setPhone(string4);

          }
	}

	@Given("admin is logged in")
	public void admin_is_logged_in() {
		A.LogState(true);
	}

	@Then("the information for a customer was updated")
	public void the_information_for_a_customer_was_updated() {
		 assertTrue(C.getupdateState());
	}

	@Then("a customer is already exists")
	public void a_customer_is_already_exists() {
        assertFalse(C.getaddState());
	}

	@Then("the customer you want to delete does not exist")
	public void the_customer_you_want_to_delete_does_not_exist() {
           assertFalse(C.getdeleteState());
	}

	@Then("the customer you want to update his information does not exist")
	public void the_customer_you_want_to_update_his_information_does_not_exist() {
		 assertFalse(C.getupdateState());
	}
	@When("the customer is added to the system")
	public void the_customer_is_added_to_the_system() {
		 assertTrue(C.getaddState());
	}

	@When("an admin want to add customer")
	public void an_admin_want_to_add_customer() {
		 assertTrue(C.getaddState());

	}



}