package fall2023project;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Customer customer;
    private Product product;

    LocalDateTime date1;
    LocalDateTime date2;
    
    public Order() {
		super();
		customer = new Customer();
		product = new Product();
		date1 = LocalDateTime.now();
		date2= LocalDateTime.now();
	}



	public Order(Customer customer, Product product, LocalDateTime date1, LocalDateTime date2, String status) {
		super();
		this.customer = customer;
		this.product = product;
		this.date1 = date1;
		this.date2 = date2;
		this.status = status;
	}



	public LocalDateTime getDate1() {
		return date1;
	}



	public void setDate1(LocalDateTime date1) {
		this.date1 = date1;
	}



	public LocalDateTime getDate2() {
		return date2;
	}






	private String status;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        String message = "Dear " + customer.getName() + ",\n\nYour order of " + product.getName() + " has been marked as complete.\n\nThank you for choosing our service.\n\nBest regards,\n" + worker.getName();
        worker.sendd(customer.getEmail()+" Order Complete Notification "+ message);
    }
    
}