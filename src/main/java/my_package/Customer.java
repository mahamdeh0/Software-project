package my_package;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class Customer {
	private String name;
	private String address;
	private String phone;
	private String id;
	@SuppressWarnings("unused")
	private int type;
	private List<Product> card = new ArrayList<>() ;


	protected static final List<Customer> CU = new ArrayList<>() ;
	boolean logState;
	private double cost;
	String password;
	final Logger logger = Logger.getLogger(Customer.class.getName());
	
	
	public Customer() {
		super();
		
	}
	
	public List<Product> getCard() {
		return card;
	}



	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Customer(String name,String password,String address, String phone, String iD,double cost,int type) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		id = iD;
		this.cost=cost;
		this.password=password;
		this.type= type;
		
	}
	public static List<Customer> getCU() {
		return CU;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	

}