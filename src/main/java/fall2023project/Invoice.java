package fall2023project;
import java.util.logging.Logger;


import java.util.List;

public class Invoice {

    public Order order;
    public static Logger logger ;

   

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
            statistics.totald();
	    }
        double cc= totalPrice - totalPrice*0.1;
        statistics.totalc(cc);
        statistics.totalp(totalPrice);
        return totalPrice;
    }

    public void generateInvoice(List<Product> invoice) {


        double totalCost = 0;
        for (Product product : invoice) {
            totalCost += product.getPrice();

        }

        System.out.printf("Invoice for " + order.getCustomer().getName());
        System.out.printf("Customer address: " + order.getCustomer().getAddress());
        System.out.printf("Delivery date: " + order.getDate2() );

        System.out.printf("Items:");

        for (Product item : invoice) {
        	System.out.printf("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.printf("Total price: $" + totalCost);
        System.out.printf("Total price after Discount: $" + order.getCustomer().cost);

    }
}
