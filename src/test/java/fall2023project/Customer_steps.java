package fall2023project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Customer_steps  {
	Customer C;
	Admin A;
	Worker W;
	String ID , name , address ,phone;
	String IDU;
boolean add=true;
boolean delete=true;
boolean update=true;
	
public Customer_steps(){
	A= new Admin();
	W= new Worker();
}
	
	@Given("a list of customers with their state.")
	public void a_list_of_customers_with_their_state(io.cucumber.datatable.DataTable dataTable) {
		String ID,name , address ,phone ;
		for(int i=0; i< dataTable.height() ; i++){
			ID = dataTable.cell(i,0);
		    name = dataTable.cell(i,1);
			address = dataTable.cell(i,2);
			phone = dataTable.cell(i,3);
		

			C = new Customer (name,"147",address , phone,ID,0.0,1);
			Customer.getCU().add(i, C);
			}
	
	    
	}

	@Given("there is a customer with ID {string} , Name {string}, Address {string} , Phone {string}")
	public void there_is_a_customer_with_id_name_address_phone(String string, String string2, String string3, String string4) {
        ID=string;
        name=string2;
        address=string3;
        phone=string4;
        
        
		
		
	}

	@When("the customer is added to the system")
	public void the_customer_is_added_to_the_system() {
		C=new Customer(name,"147",address,phone,ID,0.0,1);
		add=Operations.addC(C);
		assertTrue(add);
			
	}

	@Then("a customer whose ID {string} , Name {string}, Address {string} , Phone {string} was added")
	public void a_customer_whose_id_name_address_phone_was_added(String string, String string2, String string3, String string4) {
	   assertTrue(add);
	}

	@Given("that you want to delete a customer whose ID {string} , Name {string}, Address {string} , Phone {string}")
	public void that_you_want_to_delete_a_customer_whose_id_name_address_phone(String string, String string2, String string3, String string4) {
        ID=string;
        name=string2;
        address=string3;
        phone=string4;
	}

	@Then("you delete all his information of a customer")
	public void you_delete_all_his_information_of_a_customer() {
		C=new Customer(name,"12333",address,phone,ID,0,1);
		delete = Operations.deleteC(C);
		assertEquals(false,delete);
		
	}

	@Given("that you want to update a name to {string} , ID {string} , Address {string} , Phone {string}")
	public void that_you_want_to_update_a_name_to_id_address_phone(String string, String string2, String string3, String string4) {
        ID=string2;
        name=string;
        address=string3;
        phone=string4;
	}


	@When("his ID {string}")
	public void his_id(String string) {
	  IDU=string;

	}

	@Then("the information for a customer was updated")
	public void the_information_for_a_customer_was_updated() {
	       update=Operations.updateC(IDU,ID,name,address,phone,"12499");
	        assertEquals(false,update);
		
	}

	@When("an admin want to add customer")
	public void an_admin_want_to_add_customer() {
        assertEquals(true,add);
	}

	@Then("a customer is already exists")
	public void a_customer_is_already_exists() {
		
	 assertFalse(!add);
	}

	@Then("the customer you want to delete does not exist")
	public void the_customer_you_want_to_delete_does_not_exist() {
		 assertTrue(delete);
	}

	@Then("the customer you want to update his information does not exist")
	public void the_customer_you_want_to_update_his_information_does_not_exist() {
		 assertTrue(update);

	}
	@Given("that the admin is logged in or the worker is logged in")
	public void that_the_admin_is_logged_in_or_the_worker_is_logged_in() {
		A.logging(true);
		W.logging(true);
		assertTrue((A.getLogState() )|| (W.getLogState()));
	}

	@Given("admin is logged in or the worker is logged in")
	public void admin_is_logged_in_or_the_worker_is_logged_in() {
		A.logging(true);
		W.logging(true);
		assertTrue((A.getLogState() )|| (W.getLogState()));
	}
}
