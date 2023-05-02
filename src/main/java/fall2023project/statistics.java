package fall2023project;

import java.util.logging.Logger;

public class statistics {
    
	private  int totalDeliveredItems;
    private  double totalCash;
    private  double totalPaid;
    private  double totalWorkers;
    private  double totalProducts;
    private static Logger logger;
    
    static statistics  s =new statistics();

    
    public statistics(int deliveredItems, double cash, double paid, double workers,double products) {
        totalDeliveredItems = deliveredItems;
        totalCash = cash;
        totalPaid = paid;
        totalWorkers = workers;
        totalProducts = products;


    }
    
    public static void statisticsReport() {
    	String formatting=String.format("Customized Statistics Report:"
    	+"Total Delivered Items: " + s.totalDeliveredItems
    	+"Total Cash: " + s.totalCash
    	+"Total Paid: " + s.totalPaid
    	+"Total Workers: " + s.totalWorkers
    	+"Total Products: " + s.totalProducts);
    	logger.info(formatting);

    }

	public statistics() {
		super();
		
	}
	public static void totald() {
		s.totalDeliveredItems++;
	}
	
	public static void totalc(double x) {
		s.totalCash+=x;
		}
	public static void totalp(double x) {
		s.totalPaid+=x;
		}
	public static void totalw() {
		s.totalWorkers++;
		}
	public static void totalde() {
		s.totalDeliveredItems--;
	}
	public static void totalpr() {
		s.totalProducts++;
		}
	public static void totalpro() {
		s.totalProducts--;
	}
	public static void totalca(double x) {
		s.totalCash-=x;
		}
	public static void totalpa(double x) {
		s.totalPaid-=x;
		}
	public static void totalwo() {
		s.totalWorkers--;
		}
}
