package fall2023project;
import java.util.logging.Logger;


import java.util.List;

public class Invoice {

    public Order order;
    private static Logger logger ;

   

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
        String fr=String.format("Invoice for %s %n Customer address: %s %n Delivery date: %s %n Items:   ",order.getCustomer().getName(), order.getCustomer().getAddress(),order.getDate2());
        logger.info(fr);


        for (Product item : invoice) {
        	String ss=String.format("- %s : $ %lf %n",item.getName(), item.getPrice());
        	logger.info(ss);
        }
        String tt=String.format("Total price: $ %lf %nTotal price after Discount: $ %lf %n " ,totalCost, order.getCustomer().cost);
        logger.info(tt);

    }
}
