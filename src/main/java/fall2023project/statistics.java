package fall2023project;

public class statistics {
    
    private static int totalDeliveredItems;
    private static double totalCash;
    private static double totalPaid;
    private static double totalWorkers;
    private static double totalProducts;

    
    public statistics(int deliveredItems, double cash, double paid, double workers,double products) {
        this.totalDeliveredItems = deliveredItems;
        this.totalCash = cash;
        this.totalPaid = paid;
        this.totalWorkers = workers;
        this.totalProducts = products;

    }
    
    public void statisticsReport() {
        System.out.println("Customized Statistics Report:");
        System.out.println("Total Delivered Items: " + totalDeliveredItems);
        System.out.println("Total Cash: " + totalCash);
        System.out.println("Total Paid: " + totalPaid);
        System.out.println("Total Workers: " + totalWorkers);
        System.out.println("Total Products: " + totalProducts);

    }

	public statistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void inc_totalD() {
	totalDeliveredItems+=totalDeliveredItems;
	}
	
	public static void inc_totalC(double x) {
		totalCash+=x;
		}
	public static void inc_totalP(double x) {
		totalPaid+=x;
		}
	public static void inc_totalW() {
		totalWorkers+=totalWorkers;
		}
	public static void dec_totalD() {
	totalDeliveredItems-=totalDeliveredItems;
	}
	public static void inc_totalPr() {
		totalProducts+=totalProducts;
		}
	public static void dec_totalPr() {
		totalProducts-=totalProducts;
	}
	public static void dec_totalC(double x) {
		totalCash-=x;
		}
	public static void dec_totalP(double x) {
		totalPaid-=x;
		}
	public static void dec_totalW() {
		totalWorkers-=totalWorkers;
		}
}