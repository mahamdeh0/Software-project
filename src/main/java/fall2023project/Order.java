package fall2023project;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order {
    private Customer customer;
    public ArrayList <Product> products;
    String date2;
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



	public Order(Customer customer, List<Product> invoice, Calendar date1, String date2, String status) {
		super();
		this.customer = customer;
		this.products = (ArrayList<Product>) invoice;
		this. date1 = Calendar.getInstance();
		 date1.add(Calendar.DAY_OF_MONTH, 7); 
		this.date2=  sdf.format(date1.getTime());
		this.status = status;
	}



	public Calendar getDate1() {
		return date1;
	}



	public void setDate1(Calendar date1) {
		this.date1 = date1;
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




    public ArrayList<Product> getProducts() {
		return products;
	}



	public void setProducts(ArrayList<Product> products) {
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
    
    

    public void notifyCustomer(Worker worker) {
    	String np = null;
    	for(int i=0;i<products.size();i++) {
    		np+= products.get(i).getName()+" , ";
    	}
        String message = "Dear " + customer.getName() + ",\n\nYour order of " + np + " has been marked as complete.\n\nThank you for choosing our service.\n\nBest regards,\n" + worker.getName();
        worker.sendd(customer.getEmail()+" Order Complete Notification "+ message);
    }
    
}
