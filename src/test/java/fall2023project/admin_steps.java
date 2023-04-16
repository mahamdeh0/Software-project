package fall2023project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class admin_steps {
	Admin A;
	Worker w;
	String ID , name , address ,phone;
	String IDU;
boolean add=true;
boolean delete=true;
boolean update=true;
	
public admin_steps(){
	A= new Admin();
	w= new Worker();
	//C =new Customer();
}

	@Given("a list of workers with their state.")
	public void a_list_of_workers_with_their_state(io.cucumber.datatable.DataTable dataTable) {
		String ID,name , address ,phone ;
		for(int i=0; i< dataTable.height() ; i++){
			ID = dataTable.cell(i,0);
		    name = dataTable.cell(i,1);
			address = dataTable.cell(i,2);
			phone = dataTable.cell(i,3);
		

			w = new Worker (name,"122",address , phone,ID,true,2);
			Worker.getW().add(i, w);
			}
	}

	@Given("there is a worker with ID {string} , Name {string}, Address {string} , Phone {string}")
	public void there_is_a_worker_with_id_name_address_phone(String string, String string2, String string3, String string4) {

		ID=string;
        name=string2;
        address=string3;
        phone=string4;
	}

	@Then("a worker whose ID {string} , Name {string}, Address {string} , Phone {string} was added")
	public void a_worker_whose_id_name_address_phone_was_added(String string, String string2, String string3, String string4) {
		w=new Worker(name,"12333",address,phone,ID,true,2);
		add=Operations.addW(w);
		assertTrue(add);
	}

	@Given("that you want to delete a worker whose ID {string} , Name {string}, Address {string} , Phone {string}")
	public void that_you_want_to_delete_a_worker_whose_id_name_address_phone(String string, String string2, String string3, String string4) {
	
	     ID=string;
	        name=string2;
	        address=string3;
	        phone=string4;
	}

	@Given("admin is logged in")
	public void admin_is_logged_in() {
		A.LogState(true);
		assertTrue(A.getLogState());
	}

	@Then("you delete all his information of a worker")
	public void you_delete_all_his_information_of_a_worker() {
		w=new Worker(name,"12333",address,phone,ID,true,2);
		delete = Operations.deleteW(w);
		assertEquals(false,delete);

	}

	@Given("that you want to update the name to {string} , ID {string} , Address {string} , Phone {string}")
	public void that_you_want_to_update_the_name_to_id_address_phone(String string, String string2, String string3, String string4) {
	     ID=string2;
	        name=string;
	        address=string3;
	        phone=string4;
	}

	@When("his own ID {string}")
	public void his_own_id(String string) {
		  IDU=string;
	}

	@Then("the information for a worker was updated")
	public void the_information_for_a_worker_was_updated() {
       update=Operations.updateW(IDU,ID,name,address,phone,"12499");
        assertEquals(false,update);

	}

	@Then("a worker is already exists")
	public void a_worker_is_already_exists() {
		assertFalse(!add);
	}

	@Then("the worker you want to delete does not exist")
	public void the_worker_you_want_to_delete_does_not_exist() {
		assertTrue(delete);
	}

	@Then("the worker you want to update his information does not exist")
	public void the_worker_you_want_to_update_his_information_does_not_exist() {
		assertTrue(update);
	}
}
