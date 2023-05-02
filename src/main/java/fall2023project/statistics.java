package fall2023project;

import java.util.logging.Logger;

public class statistics {
    
    private static int totalDeliveredItems;
    private static double totalCash;
    private static double totalPaid;
    private static double totalWorkers;
    private static double totalProducts;
    public static Logger logger;

    
    public statistics(int deliveredItems, double cash, double paid, double workers,double products) {
        totalDeliveredItems = deliveredItems;
        totalCash = cash;
        totalPaid = paid;
        totalWorkers = workers;
        totalProducts = products;


    }
    
    public static void statisticsReport() {
    	logger.info("Customized Statistics Report:");
    	logger.info("Total Delivered Items: " + totalDeliveredItems);
    	logger.info("Total Cash: " + totalCash);
    	logger.info("Total Paid: " + totalPaid);
    	logger.info("Total Workers: " + totalWorkers);
    	logger.info("Total Products: " + totalProducts);

    }

	public statistics() {
		super();
		
	}
	public static void totald() {
	totalDeliveredItems++;
	}
	
	public static void totalc(double x) {
		totalCash+=x;
		}
	public static void totalp(double x) {
		totalPaid+=x;
		}
	public static void totalw() {
		totalWorkers++;
		}
	public static void totalde() {
	totalDeliveredItems--;
	}
	public static void totalpr() {
		totalProducts++;
		}
	public static void totalpro() {
		totalProducts--;
	}
	public static void totalca(double x) {
		totalCash-=x;
		}
	public static void totalpa(double x) {
		totalPaid-=x;
		}
	public static void totalwo() {
		totalWorkers--;
		}
}
