package fall2023project;

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

	public double getTotalPrice(ArrayList <Product> products) {
        double totalPrice = 0;
        for (Product product : products) {
        	totalPrice += product.getPrice();
            statistics.inc_totalC(totalPrice);
            statistics.inc_totalP(totalPrice);
            statistics.inc_totalD();
	    }
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
        System.out.println("Order date: " + order.getDate1() );
        System.out.println("Delivery date: " + order.getDate2() );

        System.out.println("Items:");

        for (Product item : invoice) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }

        System.out.println("Total price: $" + totalCost);
        System.out.println("Total price after Discount: $" + order.getCustomer().cost);

    }
}