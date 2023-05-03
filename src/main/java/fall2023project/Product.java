package fall2023project;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private String dis;
	private double price;
	private String idp;
	boolean addstate;
	boolean deletestate; 
	boolean updatestate;
	protected static final List<Product> P = new ArrayList<Product>() ;
	public Product(String idw, String name, String dis, double price) {
		super();
		this.name = name;
		this.dis = dis;
		this.price = price;
		this.idp = idw;
	}
	
	public Product() {
		super();
	}

	public static List<Product> getP() {
		return P;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getID() {
		return idp;
	}
	public void setID(String iD) {
		idp = iD;
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
