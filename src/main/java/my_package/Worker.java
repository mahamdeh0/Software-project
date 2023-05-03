package my_package;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Worker {
	boolean logState;
	String pass;
	final Logger logger = Logger.getLogger(Worker.class.getName());
	private String name;
	private String address;
	private String phone;
	private String idd;
	boolean available;
	private int type;
	boolean addstate;
	boolean deletestate; 
	boolean updatestate;
	protected static final List<Worker> W = new ArrayList<Worker>() ;
	
 

	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public Worker() {
		logState=false;
		pass="worker123";
		
	}

 
	public void logging(boolean t) {
		
		logState=t;		
	}
	public boolean getLogState() {
		
		return logState;
	}
	

	public Worker(String name,String password, String address, String phone, String iD, boolean available, int type) {
		super();
		this.pass = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		idd = iD;
		this.available = available;
		this.type = type;
	}

	public static List<Worker> getW() {
		return W;
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
		return idd;
	}
	public void setID(String iD) {
		idd = iD;
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
	
	


}