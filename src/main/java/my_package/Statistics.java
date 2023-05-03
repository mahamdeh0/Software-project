package my_package;


import java.util.logging.Logger;

public class Statistics {
    
	private  int totalDeliveredItems;
    private  double totalCash;
    private  double totalPaid;
    private  double totalWorkers;
    private  double totalProducts;
    private static Logger logger;
    
    static Statistics  s =new Statistics();

    
    public Statistics(int deliveredItems, double cash, double paid, double workers,double products) {
        totalDeliveredItems = deliveredItems;
        totalCash = cash;
        totalPaid = paid;
        totalWorkers = workers;
        totalProducts = products;


    }
    
    public static void statisticsReport() {
    	String formatting=String.format("Customized Statistics Report:%nTotal Delivered Items: %lf %n Total Cash: %lf %n Total Paid: %lf %n Total Workers: %lf %n Total Products: %lf" ,s.totalDeliveredItems,s.totalCash,s.totalPaid,s.totalWorkers, s.totalProducts);
    	logger.info(formatting);

    }

	public Statistics() {
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
