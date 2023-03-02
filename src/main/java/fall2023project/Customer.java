package fall2023project;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class Customer {
	private String name;
	private String address;
	private String phone;
	private String ID;
	boolean addstate;
	boolean deletestate; 
	boolean updatestate;
	protected static final List<Customer> CU = new ArrayList<Customer>() ;
	boolean logState;
	String password;
	final Logger logger = Logger.getLogger(Customer.class.getName());
	
	
	public Customer(String name, String address, String phone, String iD) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		ID = iD;
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
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public void addState(boolean t) {
		
		addstate=t;		
	}
    public void deleteState(boolean t) {
		
		deletestate=t;		
	}
    public void updateState(boolean t) {
		
		updatestate=t;		
	}

    public boolean getaddState() {
		
		return addstate;
	}
    public boolean getdeleteState() {
		
		return deletestate;
	}    public boolean getupdateState() {
		
		return updatestate;
	}
	
	public  int find( ArrayList <Customer> customersList ,String string) {
		
		  int index=-1;
	    	 for(int i=0;i<customersList.size();i++){
	    		 
	             if(customersList.get(i).getName().equalsIgnoreCase(string)){
	               index=i;
	          } 
	    }
	    	return index;
	}

}