package my_package;

public class Operations {
	private Operations() {
		
	}
public static boolean addW(Worker w) {
	boolean add=true;
	for(int i=0; i< Worker.getW().size() ; i++) {
		if((Worker.getW().get(i).getID().equals(w.getID())) && (Worker.getW().get(i).getName().equals(w.getName())) && (Worker.getW().get(i).getAddress().equals(w.getAddress()))&& (Worker.getW().get(i).getPhone().equals(w.getPhone())))
				{
			    add = false;
				break;
				}
			}
	if(add) {
		Worker.getW().add(w);
		Statistics.totalw();
	}
	return add;
}

public static boolean deleteW(Worker w) {
	 boolean delete =true;
	 
		int index=-1;
		for(int i=0; i< Worker.getW().size() ; i++) {
			if((Worker.getW().get(i).getID().equals(w.getID())) && (Worker.getW().get(i).getName().equals(w.getName())) && (Worker.getW().get(i).getAddress().equals(w.getAddress()))&& (Worker.getW().get(i).getPhone().equals(w.getPhone())))
					{
				    index=i;
				    delete = false;
					break;
					}
				}
		if(!delete) {
			Worker.getW().remove(index);		
			Statistics.totalwo();
		}
	 return delete;
}
public static boolean updateW(String idd,String id,String name,String address,String phone,String password) {
	boolean update=true;
	int index=-1;
	for(int i=0; i< Worker.getW().size() ; i++) {
		if((Worker.getW().get(i).getID().equals(idd))) {
			    index=i;
			    update = false;
				break;
				}
			}
	if(!update) {
		Worker.getW().get(index).setID(id);
		Worker.getW().get(index).setName(name);
		Worker.getW().get(index).setAddress(address);
		Worker.getW().get(index).setPhone(phone);	
		Worker.getW().get(index).pass=password;	

	}

	return update;
	

}
public static boolean addC(Customer w) {
	boolean add=true;
	for(int i=0; i< Customer.getCU().size() ; i++) {
		if((Customer.getCU().get(i).getID().equals(w.getID())) && (Customer.getCU().get(i).getName().equals(w.getName())) && (Customer.getCU().get(i).getAddress().equals(w.getAddress()))&& (Customer.getCU().get(i).getPhone().equals(w.getPhone())))
				{
			    add = false;
				break;
				}
			}
	if(add) {
		Customer.getCU().add(w);
		
	}
	return add;
}

public static boolean deleteC(Customer w) {
	 boolean delete =true;
	 
		int index=-1;
		for(int i=0; i< Customer.getCU().size() ; i++) {
			if((Customer.getCU().get(i).getID().equals(w.getID())) && (Customer.getCU().get(i).getName().equals(w.getName())) && (Customer.getCU().get(i).getAddress().equals(w.getAddress()))&& (Customer.getCU().get(i).getPhone().equals(w.getPhone())))
					{
				    index=i;
				    delete = false;
					break;
					}
				}
		if(!delete) {
			Customer.getCU().remove(index);			
		}
	 return delete;
}
public static boolean updateC(String idd,String id,String name,String address,String phone,String password) {
	boolean update=true;
	int index=-1;
	for(int i=0; i< Customer.getCU().size() ; i++) {
		if((Customer.getCU().get(i).getID().equals(idd))) {
			    index=i;
			    update = false;
				break;
				}
			}
	if(!update) {
		Customer.getCU().get(index).setID(id);
		Customer.getCU().get(index).setName(name);
		Customer.getCU().get(index).setAddress(address);
		Customer.getCU().get(index).setPhone(phone);	
		Customer.getCU().get(index).password=password;	

	}

	return update;
	

}
public static boolean addP(Product w) {
	boolean add=true;
	for(int i=0; i< Product.getP().size() ; i++) {
		if((Product.getP().get(i).getID().equals(w.getID())) && (Product.getP().get(i).getName().equals(w.getName())) && (Product.getP().get(i).getDis().equals(w.getDis()))&& (Product.getP().get(i).getPrice()==w.getPrice()))
				{
			    add = false;
				break;
				}
			}
	if(add) {
		Product.getP().add(w);
		Statistics.totalpr();
	}
	return add;
}

public static boolean deleteP(Product w) {
	 boolean delete =true;
	 
		int index=-1;
		for(int i=0; i< Product.getP().size() ; i++) {
			if((Product.getP().get(i).getID().equals(w.getID())) && (Product.getP().get(i).getName().equals(w.getName())) && (Product.getP().get(i).getDis().equals(w.getDis()))&& (Product.getP().get(i).getPrice()==(w.getPrice())))
					{
				    index=i;
				    delete = false;
					break;
					}
				}
		if(!delete) {
			Product.getP().remove(index);	
			Statistics.totalpro();
		}
	 return delete;
}
public static boolean updateP(String idd,String id,String name,String diss,double price) {
	boolean update=true;
	int index=-1;
	for(int i=0; i< Product.getP().size() ; i++) {
		if((Product.getP().get(i).getID().equals(idd)))
				{
			    index=i;
			    update = false;
				break;
				}
			}
	if(!update) {
		Product.getP().get(index).setID(id);
		Product.getP().get(index).setName(name);
		Product.getP().get(index).setDis(diss);
		Product.getP().get(index).setPrice(price);
	
	}
	


	return update;
}


}
