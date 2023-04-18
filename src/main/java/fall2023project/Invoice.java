package fall2023project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

    public Order order;

  

    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Invoice(Order order) {
		super();
		this.order = order;
	}

	public double getTotalPrice(List<Product> card) {
        double totalPrice = 0;
        for (Product product : card) {
        	totalPrice += product.getPrice();
            statistics.inc_totalD();
	    }
        double cc= totalPrice - totalPrice*0.1;
        statistics.inc_totalC(cc);
        statistics.inc_totalP(totalPrice);
        return totalPrice;
    }

    public void generateInvoice(List<Product> invoice) {
        // Calculate total cost of products
        double totalCost = 0;
        for (Product product : invoice) {
            totalCost += product.getPrice();

        }
        // Print invoice details
        System.out.println("Invoice for " + order.getCustomer().getName());
        System.out.println("Customer address: " + order.getCustomer().getAddress());
        System.out.println("Delivery date: " + order.getDate2() );

        System.out.println("Items:");

        for (Product item : invoice) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }

        System.out.println("Total price: $" + totalCost);
        System.out.println("Total price after Discount: $" + order.getCustomer().cost);

    }
}