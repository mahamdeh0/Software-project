package fall2023project;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Order_steps {
	Product product;
	Order order;
	Logging C;
	String IDp , namep , diss ,price;
	Customer c;
	String IDc , namec , address ,phone,email;
	  LocalDateTime date1;
	    LocalDateTime date2;
	public String password;
	
	public Order_steps() {
		C=new Logging();
		C.password="customer123";
		date1 = LocalDateTime.now();
		date2= LocalDateTime.now();
	}
	
	

	@Given("that the customer with ID {string} , Name {string}, Address {string} , Phone {string} , email {string} is logged in")
	public void that_the_customer_with_id_name_address_phone_email_is_logged_in(String string, String string2, String string3, String string4, String string5) {
		c = new Customer (string2,"147",string3 , string4,string,0.0,1);
		C.LogState(false);
		}

	@When("the customer selects a  product with ID {string} , Name {string} ,Category {string} price {string} NIS")
	public void the_customer_selects_a_product_with_id_name_category_price_nis(String string, String string2, String string3, String string4) {
		product= new Product (string,string2,string3,string4);
	}


@Then("the system generates an invoice for the customer and updates the order status to {string}")
public void the_system_generates_an_invoice_for_the_customer_and_updates_the_order_status_to(String string) {

    order=new Order(c,product,date1,date2,string);
    String s= order.getStatus();
	assertEqual("waiting",string); 

}



private void assertEqual(String expected, String actual) {
    if (!expected.equals(actual)) {
        throw new AssertionError("Expected: " + expected + ", but got: " + actual);
    }
}


}