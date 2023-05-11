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
	boolean addstate;
	boolean deletestate; 
	boolean updatestate;
	@SuppressWarnings("unused")
	private int type;
	protected static final List<Worker> W = new ArrayList<Worker>() ;
	


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
		this.type= type;

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
	



}