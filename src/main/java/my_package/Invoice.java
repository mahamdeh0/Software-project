package my_package;

import java.util.logging.Logger;


import java.util.List;

public class Invoice {

	private Order order;
    private static final Logger LOGGER = Logger.getLogger(Invoice.class.getName());

   

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
            Statistics.totald();
	    }
        double cc= totalPrice - totalPrice*0.1;
        Statistics.totalc(cc);
        Statistics.totalp(totalPrice);
        return totalPrice;
    }

    public void generateInvoice(List<Product> invoice) {


        double totalCost = 0;
        for (Product product : invoice) {
            totalCost += product.getPrice();

        }

        LOGGER.info("Invoice for " + order.getCustomer().getName()
        +"Customer address: " + order.getCustomer().getAddress()
        +"Delivery date: " + order.getDate2() 
        +"Items:");

        for (Product item : invoice) {
        	LOGGER.info("- " + item.getName() + ": $" + item.getPrice());
        }
        LOGGER.info("Total price: $" + totalCost
        +"Total price after Discount: $" +  order.getCustomer().getCost());

    }
}
