package fall2023project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fall2023project.Customer;
import fall2023project.Invoice;
import fall2023project.Logging;
import fall2023project.Order;
import fall2023project.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invoice_steps {
	Product product1;
	Product product2;
	Invoice x;
	Logging C;
	Customer c;
	Order order;
	Calendar date1;
	String date2;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	  List <Product> invoice = new ArrayList<Product>();
	  boolean state=false;
	  
	public String password;
	
	public invoice_steps() {
		C=new Logging();
		C.password="customer123";
		date1 = Calendar.getInstance();
		 date1.add(Calendar.DAY_OF_MONTH, 7); 
		date2=  sdf.format(date1.getTime());
	}
	

@Given("that the customer with ID {string} , Name {string}, Address {string} , Phone {string} , email {string} is logged in system")
public void that_the_customer_with_id_name_address_phone_email_is_logged_in_system(String string, String string2, String string3, String string4, String string5) {
	c = new Customer (string2,"147",string3 , string4,string,0.0,1);
	C.logState(true);
}

@When("the customer selects a  product wwith ID {string} , Name {string} ,Category {string} price {string} NIS")
public void the_customer_selects_a_product_wwith_id_name_category_price_nis(String string, String string2, String string3, String string4) {
	double value = Double.parseDouble(string4);
	product1= new Product (string,string2,string3,value);
	invoice.add(product1);
}

@When("When the customer selects a  product with  ID {string} , Name {string} ,Category {string} price {string} NIS")
public void when_the_customer_selects_a_product_with_id_name_category_price_nis(String string, String string2, String string3, String string4) {
	double value = Double.parseDouble(string4);

	product2= new Product (string,string2,string3,value);
	invoice.add(product2);
}

@When("the customer generates an invoice")
public void the_customer_generates_an_invoice() {
	order= new Order(c,invoice,date2,"complete");
	x=new Invoice(order);
	x.generateInvoice(invoice);
	state=true;
}

@Then("the system displays the invoice for the customer and send {string}")
public void the_system_displays_the_invoice_for_the_customer_and_send(String string) {
	order.setStatus(string);
	if(order.getStatus().equals("complete"))
		assertTrue(state);
	else 
		assertFalse(state);
}


}