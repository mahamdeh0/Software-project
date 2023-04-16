package fall2023project;

public class statistics {
    
    private int totalDeliveredItems;
    private double totalCash;
    private double totalPaid;
    private double totalWorkers;
    
    public statistics(int deliveredItems, double cash, double paid, double workers) {
        this.totalDeliveredItems = deliveredItems;
        this.totalCash = cash;
        this.totalPaid = paid;
        this.totalWorkers = workers;
    }
    
    public void statisticsReport() {
        System.out.println("Customized Statistics Report:");
        System.out.println("Total Delivered Items: " + totalDeliveredItems);
        System.out.println("Total Cash: " + totalCash);
        System.out.println("Total Paid: " + totalPaid);
        System.out.println("Total Workers: " + totalWorkers);
    }

	public statistics() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}