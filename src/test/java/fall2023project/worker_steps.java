package fall2023project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class worker_steps {
	Product p;
	Worker w;
	String ID , name , diss ,price;
	String IDU;
boolean add=true;
boolean delete=true;
boolean update=true;

public worker_steps(){
	w= new Worker();
}
	@Given("a list of product with their state.")
	public void a_list_of_product_with_their_state(io.cucumber.datatable.DataTable dataTable) {
		String ID,name , diss ,price ;
		for(int i=0; i< dataTable.height() ; i++){
			ID = dataTable.cell(i,0);
		    name = dataTable.cell(i,1);
			diss = dataTable.cell(i,2);
			price = dataTable.cell(i,3);
			double value = Double.parseDouble(price);


			p= new Product (ID,name,diss,value);
			Product.getP().add(i, p);
			}
	}

	@Given("there is a product with ID {string} , Name {string} ,Category {string} price {string} NIS")
	public void there_is_a_product_with_id_name_category_price_nis(String string, String string2, String string3, String string4) {
		ID=string;
        name=string2;
        diss=string3;
        price=string4;
	}

	@Then("a product whose ID {string} , Name {string} ,Category {string} , price {string} NIS  was added")
	public void a_product_whose_id_name_category_price_nis_was_added(String string, String string2, String string3, String string4) {
		
		double value = Double.parseDouble(price);
         p= new Product (ID,name,diss,value);
        add=Operations.addP(p);
		assertTrue(add);
	}

	@Given("that you want to delete a product whose ID {string} , Name {string} ,Category {string} price {string} NIS")
	public void that_you_want_to_delete_a_product_whose_id_name_category_price_nis(String string, String string2, String string3, String string4) {
		ID=string;
        name=string2;
        diss=string3;
        price=string4;
	}

	@Given("that you want to update a name to ID {string} , Name {string} ,Category {string} price {string} NIS")
	public void that_you_want_to_update_a_name_to_id_name_category_price_nis(String string, String string2, String string3, String string4) {
		ID=string;
        name=string2;
        diss=string3;
        price=string4;
        
	}


	@Then("you delete all his information of a product")
	public void you_delete_all_his_information_of_a_product() {
		double value = Double.parseDouble(price);
		p=new Product(ID,name,diss,value);
		delete = Operations.deleteP(p);
		assertEquals(false,delete);
	}
	@When("its ID {string}")
	public void its_id(String string) {
	    IDU=string;
	}


	@Then("the information for a product was updated")
	public void the_information_for_a_product_was_updated() {
		double value = Double.parseDouble(price);  
		update=Operations.updateP(IDU,ID,name,diss,value);
	    assertEquals(false,update);

		
	}

}
