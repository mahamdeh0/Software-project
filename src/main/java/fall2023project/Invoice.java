package fall2023project;

import java.util.List;

public class Invoice {
    private String customerName;
    private String customerAddress;
    private String deliveryAddress;
    private List<Product> products;
    private String status; 

    public Invoice(String customerName, String customerAddress, String deliveryAddress, List<Product> products) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.deliveryAddress = deliveryAddress;
        this.products = products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
        	totalPrice += Double.parseDouble(product.getPrice());
	    }
        return totalPrice;
    }

    public void generateInvoice() {
        // Calculate total cost of products
        double totalCost = 0;
        for (Product product : products) {
            totalCost += Double.parseDouble(product.getPrice());
        }

        // Print invoice details
        System.out.println("Invoice for " + customerName);
        System.out.println("Customer address: " + customerAddress);
        System.out.println("Delivery address: " + deliveryAddress);
        System.out.println("Items:");

        for (Product item : products) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }

        System.out.println("Total price: $" + totalCost);
    }
}