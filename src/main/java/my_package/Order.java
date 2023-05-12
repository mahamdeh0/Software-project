package my_package;


import java.text.SimpleDateFormat;
import java.util.*;

public class Order {
    private Customer customer;

    private List <Product> products;
    String date2;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar date1;


    public Order() {
		super();
		customer = new Customer();
		products =new ArrayList<>();
		date1 = Calendar.getInstance();
		 date1.add(Calendar.DAY_OF_MONTH, 7); 
		date2=  sdf.format(date1.getTime());
	}



	public Order(Customer customer, List<Product> invoice, String date2, String status) {
		super();
		this.customer = customer;
		this.products =  invoice;
		this.date2=  date2;
		this.status = status;
		
	}

	public String getDate2() {
		return date2;
	}

	private String status;

    public Customer getCustomer() {
        return customer;
    }



    public List<Product> getProducts() {
		return products;
	}


	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
   


    
}
