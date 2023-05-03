package fall2023project;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class Order {
    private Customer customer;
    public List <Product> products;
    String date2;
    private static Logger logger ;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Calendar date1;


    public Order() {
		super();
		customer = new Customer();
		products =new ArrayList<Product>();
		date1 = Calendar.getInstance();
		 date1.add(Calendar.DAY_OF_MONTH, 7); 
		date2=  sdf.format(date1.getTime());
	}



	public Order(Customer customer, List<Product> invoice, String date2, String status) {
		super();
		this.customer = customer;
		this.products =  invoice;
		date1 = Calendar.getInstance();
		 date1.add(Calendar.DAY_OF_MONTH, 7); 
		this.date2=  sdf.format(date1.getTime());
		this.status = status;
	}

	public String getDate2() {
		return date2;
	}

	private String status;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




    public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void markAsComplete(Worker worker) {
        if (status.equals("complete")) {
            notifyCustomer(worker);

        } else {
            status = "complete";
            notifyCustomer(worker);
        }
    }
    
    

    public void setDate2(String date2) {
		this.date2 = date2;
	}



	public void notifyCustomer(Worker worker) {
		StringBuilder sb = new StringBuilder();
    	for(int i=0;i<products.size();i++) {
    		sb.append(products.get(i).getName()+" , ");
    	}
    	String np = sb.toString();

        String message = "Dear " + customer.getName() + "\nYour order of " + np + " has been marked as complete.\nThank you for choosing our service.Best regards,\n Please enter number 6 to show your invoice\n"+ worker.getName();
    logger.info(message);


    }
    
}
