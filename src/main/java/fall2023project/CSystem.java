package fall2023project;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CSystem {
	
    public static HashMap<String,String> q= new HashMap<String,String>();
    public static Scanner input = new Scanner (System.in);
    public static int y;
    static Order order;
    static String date2;
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	static Calendar date1;
	static LocalDate date3;

	static Invoice i;

    
	public static void main(String [] args) {
		 date1 = Calendar.getInstance();
		 date3 = LocalDate.now();         order=new Order();
		 date1.add(Calendar.DAY_OF_MONTH, 7); 
		date2=  sdf.format(date1.getTime());
		init();
        int x = authenticate();
        while(x == -1) {
            System.out.println("The Username doesn't exist, please enter your Username again");
            x = authenticate();   
        }
        if(x == 0) {
            admin_activities();
        } else if(x == 1) {
            customer_activities();
        } else {
            worker_activities();
        }
    }	

	public static void init() {
	
				Admin a =new Admin("Woroud Fouleh","passw123",0);
				Admin.getAa().add(a);
			
				Worker n=new Worker("Abd Mahamdeh","123123","nablus","0568725598","122",true,2);
				Operations.addW(n);

		    	Customer i=new Customer("ahmad tone","222","nablus","028725598","98",0,3);
				Customer.getCU().add(i);
				
				Product product1 = new Product("1","CarpetA" ,"Small carpet cleaning", 170);
				Product product2 = new Product("2", "CarpetB","Medium carpet cleaning", 250);
				Product product3 = new Product("3", "CarpetC","Great carpet cleaning", 400);
				Operations.addP(product3);
				Operations.addP(product2);
				Operations.addP(product1);

                q.put("Woroud Fouleh", "passw123");
                q.put("Abd Mahamdeh","123123" );
                q.put("ahmad tone", "222");

 }
	
	
	public static int authenticate() {
		
	    Scanner input = new Scanner(System.in);
	    
	    System.out.println("\n Welcome to the Cleaning services for carpets and covers");
	    System.out.println("Please select your role:");
	    System.out.println("1. Admin");
	    System.out.println("2. Worker");
	    System.out.println("3. Customer");

	    int roleChoice = input.nextInt();
	    input.nextLine();

	    if (roleChoice == 1 || roleChoice == 2 || roleChoice == 3) {
	    	
	        System.out.println("Enter your UserName:");
	        String id2 = input.nextLine();

	        boolean flag = true;
	        int index = 0;

	        for (int i = 0; i < Admin.getAa().size(); i++) {
	            if (id2.equals(Admin.getAa().get(i).getName())) {
	                flag = false;
	                index = 0;
	                break;
	            }
	        }

	        if (flag) {
	            for (int i = 0; i < Customer.getCU().size(); i++) {
	                if (id2.equals(Customer.getCU().get(i).getName())) {
	                    flag = false;
	                    index = 1;
		                y=i;

	                    break;
	                }
	            }
	        }

	        if (flag) {
	            for (int i = 0; i < Worker.getW().size(); i++) {
	                if (id2.equals(Worker.getW().get(i).getName())) {
	                    flag = false;
	                    index = 2;
	                    break;
	                }
	            }
	        }

	        if (flag) {
	            return -1;
	        } else {
	            System.out.println("Enter Password");

	            while (true) {
	                String pass = input.nextLine();
	                String value = q.get(id2);
	                if (pass.equals(value)) {
	                    System.out.printf("Welcome:: %s", id2);
	                    return index;
	                } else {
	                    System.out.println("Please enter your password again");
	                }
	            }
	        }
	    } else {
	        return -1;
	    }
	}
		
		

	
	
	
	public static void admin_activities() {
	    Scanner input = new Scanner(System.in);
	    while (true) {
	    	System.out.println("\n Welcome , to the Cleaning services for carpets and covers");
	    	System.out.println("------------------------------------------------------------");
	    	System.out.println("Select an option:");
	    	System.out.println("1. Show all workers");
	    	System.out.println("2. Add a new worker");
	    	System.out.println("3. Update a worker");
	    	System.out.println("4. Delete a worker");
	    	System.out.println("5. Distribute the orders on the available workers");
	    	System.out.println("6. View business reports");
	    	System.out.println("7. View the statistics report");
	    	System.out.println("8. Quit");
	    	System.out.print("Enter the number of the activity you want to perform: ");
	        int choice = input.nextInt();

	        switch (choice) {
	       
	        
	            case 1:
	                for (int i = 0; i < Worker.getW().size(); i++) {
	                    System.out.printf("%d - ", i + 1);
	                    System.out.println(Worker.getW().get(i).getName() + "   " + Worker.getW().get(i).getAddress() + "   " + Worker.getW().get(i).getPhone());
	                    System.out.println();
	                }
	                break;
	                

	            case 2:
	                Scanner pass = new Scanner(System.in);
	                Scanner pp = new Scanner(System.in);
	                Scanner nn = new Scanner(System.in);
	                Scanner nn2 = new Scanner(System.in);


	                System.out.println("Enter id:");
	                String s = pass.next();
	                System.out.println("Enter name:");
	                String n = pp.nextLine();
	                System.out.println("Enter password:");
	                String d = nn2.nextLine();
	                System.out.println("Enter Phone:");
	                String j = nn.nextLine();
	                System.out.println("Enter address:");
	                String h = nn.nextLine();
	                Worker r = new Worker(n, d, h, j, s,true, 2);
	                boolean add = Operations.addW(r);
	                if (add)
	                    System.out.println("A new Worker added");
	                else
	                    System.out.println("A Worker is already exist");
	                break;
	                

	            case 3:
	            	
	                Scanner pass1 = new Scanner(System.in);
	                Scanner pp1 = new Scanner(System.in);
	                Scanner nn1 = new Scanner(System.in);
	                Scanner ppp1 = new Scanner(System.in);

	                System.out.println("Enter a worker ID you want to update:");
	                String z = pass1.next();
	                System.out.println("Enter a new id:");
	                String s1 = pass1.next();
	                System.out.println("Enter a new name:");
	                String n1 = pp1.nextLine();
	                System.out.println("Enter a new password:");
	                String d1 = ppp1.nextLine();
	                System.out.println("Enter a new Phone:");
	                String j1 = nn1.nextLine();
	                System.out.println("Enter a new address:");
	                String h1 = nn1.nextLine();
	                boolean update = Operations.updateW(z, s1, n1, h1, j1, d1);
	                if (!update)
	                    System.out.println("A worker was updated");
	                else
	                    System.out.println("A worker was not exist");
	                break;

	            case 4:
	                int index = -1;
	                Scanner pass2 = new Scanner(System.in);
	                System.out.println("Enter a worker ID you want to delete:");
	                String z1 = pass2.next();
	                for (int i = 0; i < Worker.getW().size(); i++) {
	                    if (Worker.getW().get(i).getID().equals(z1)) {
	                        index = i;
	                    }
	                }
	                if (index == -1) {
	                    System.out.println("A worker you want to delete does not exist");
	                } else {
	                    boolean delete = Operations.deleteW(Worker.getW().get(index));
	                    if (!delete)
	                    	System.out.println("A worker was deleted");	       
	                }
	                    break;

	            case 5:
	            	String state;
	            	String namee;
	                for (int i = 0; i < Worker.getW().size(); i++) {
	                    System.out.printf("%d - ", i + 1);
	                    if(Worker.getW().get(i).available)state="Available";
	                    else state="Not Available";
	                    System.out.println(Worker.getW().get(i).getName() + "   " +state);
	                    System.out.println();
	                }
                    System.out.println("Write a name of worker you want to give him a job");
	                Scanner ppp = new Scanner(System.in);
                    namee= ppp.nextLine();
                    Admin.list_W(Worker.getW(), namee);
	                for (int i = 0; i < Worker.getW().size(); i++) {
	                    System.out.println("Done");
	                    System.out.printf("%d - ", i + 1);
	                    if(Worker.getW().get(i).available)state="Available";
	                    else state="Not Available";
	                    System.out.println(Worker.getW().get(i).getName() + "   " +state);
	                    System.out.println();
	                }

	          
	                break;

	                
	                
	                    
	                case 6:
	                	
	                    reports myReports = new reports(); 
	                    myReports.generateReport(); 
	                    
	                    break;
	                case 7:
		               	 i=new Invoice(order);
	                	i.getTotalPrice(Customer.getCU().get(y).card);
	                	statistics.statisticsReport();

	                	
	                    break;
	                case 8:

	                	  System.out.println("You are logged out.");
	                	  int x = authenticate();
	                      while(x == -1) {
	                          System.out.println("The Username doesn't exist, please enter your Username again");
	                          x = authenticate();   
	                      }
	                      if(x == 0) {
	                          admin_activities();
	                      } else if(x == 1) {
	                          customer_activities();
	                      } else {
	                          worker_activities();
	                      }
	                  
	                	    break;


	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    
	                    break;
	                    }
	        }

	}
	
	
	  
	
	
	public static void customer_activities() {
		while(true) {
			System.out.println("\n Welcome to the Cleaning services for carpets and covers, Customer!\n");
			System.out.println("--------------------------------------------------");
			System.out.println("Please select an option from the following menu:\n");
			System.out.println("1. Show all products");
			System.out.println("2. Make an order");
			System.out.println("3. Show order");
			System.out.println("4. Checkout order");
			System.out.println("5. Show mailbox");
			System.out.println("6. Show my invoice");
			System.out.println("7. Quit\n");
			System.out.println("Enter the number of the activity you want to perform:");
			
		int choice;
		choice=input.nextInt();
	     switch (choice) {
	       
	        
         case 1:
             for (int i = 0; i < Product.getP().size(); i++) {
                 System.out.printf("%d - ", i + 1);
                 System.out.println(Product.getP().get(i).getName() + "   " + Product.getP().get(i).getDis()+ "   " + Product.getP().get(i).getPrice());
                 System.out.println();
             }
             break;
             
         case 2:
             for (int i = 0; i < Product.getP().size(); i++) {
                 System.out.printf("%d - ", i + 1);
                 System.out.println(Product.getP().get(i).getName() + "   " + Product.getP().get(i).getDis()+ "   " + Product.getP().get(i).getPrice());
                 System.out.println();
             }
             System.out.println("Please enter the number the type of product wou want to clean");
             int b;
             b=input.nextInt();
             b--;
             Customer.getCU().get(y).card.add(Product.getP().get(b));
             Customer.getCU().get(y).cost+=Product.getP().get(b).getPrice();
             System.out.println("Added to your order successfully");

             

             
             break;
             
         case 3:
            for(int i=0;i<Customer.getCU().get(y).card.size();i++) {
                System.out.printf("%d - ", i + 1);
                System.out.println(Customer.getCU().get(y).card.get(i).getName() + "   " + Customer.getCU().get(y).card.get(i).getDis()+ "   " + Customer.getCU().get(y).card.get(i).getPrice());
                System.out.println();           	
            }
            System.out.println("Total cost :"+Customer.getCU().get(y).cost);           	

             break;
             
        
         case 4:
        	 order=new Order(Customer.getCU().get(y),Customer.getCU().get(y).card,date2,"complete");
        	 if (Customer.getCU().get(y).cost >  400) {
 	            // Apply discount to next order
 	        	double per=(double)10/100.0;
 	            double discountAmount = per * Customer.getCU().get(y).cost;
 	           Customer.getCU().get(y).cost=Customer.getCU().get(y).cost-discountAmount;
 	            // This step is just to represent the action of applying the discount to the next order
 	            System.out.println("You has spent more than 400 NIS on orders "
 	            		+ "So the system applies a 10% discount to your order " + discountAmount + " NIS applied to next order");
 	        } else {
 	            // No discount applied
 	            System.out.println("You are not eligible for discount");
 	        }
 	    
             System.out.println("Your order checked out, an email will be sent to you when the delivery arrives after 7 days");
             break;


         case 5:
        	 i=new Invoice(order);
	      	Worker w=new Worker("Woroud Fouleh","123123","nablus","0568725598","122",true,2);
        	 order.notifyCustomer(w);
        	 

                 break;
         case 6:
        	 i=new Invoice(order);
        	 i.generateInvoice(order.getProducts()); 
        	 break;
         
         case 7:
        	 System.out.println("You are logged out.");
       	  int x = authenticate();
             while(x == -1) {
                 System.out.println("The Username doesn't exist, please enter your Username again");
                 x = authenticate();   
             }
             if(x == 0) {
                 admin_activities();
             } else if(x == 1) {
                 customer_activities();
             } else {
                 worker_activities();
             }
         
        	 break;

         default:
            System.out.println("Invalid choice. Please try again.");
                 
                 break;
                 }
		
}
	}	
	
	
	
	
	public static void worker_activities() {
		while(true) {
			System.out.println("\n Welcome to the Cleaning services for carpets and covers, Worker!\n");
			System.out.println("--------------------------------------------------");
			System.out.println("Please select an option from the following menu:\n");
			System.out.println("1. Show all customers");
			System.out.println("2. Add a new customer");
			System.out.println("3. Update an existing customer");
			System.out.println("4. Delete a customer");
			System.out.println("5. Show all products");
			System.out.println("6. Add a new product");
			System.out.println("7. Update an existing product");
			System.out.println("8. Delete a product");
			System.out.println("9. Notify the customer by sending email when the order is complete.");
			System.out.println("10. Quit\n");
			System.out.println("Enter the number of the activity you want to perform:");
			
		int choice;
		choice=input.nextInt();
		

		switch(choice) {
			case 1:
				for(int i=0;i<Customer.getCU().size();i++) {
					System.out.printf("%d - ",i+1);
					System.out.println(Customer.getCU().get(i).getName()+"   "+ Customer.getCU().get(i).getAddress()+"   "+Customer.getCU().get(i).getPhone());
					System.out.println();
				}
				break;
				
			case 2:
				Scanner pass = new Scanner(System.in);
				Scanner pp = new Scanner(System.in);
				Scanner nn = new Scanner(System.in);
				Scanner nn4 = new Scanner(System.in);

				System.out.println("Enter id:");
				String s = pass.next();
				System.out.println("Enter name:");
				String n=pp.nextLine();
				System.out.println("Enter password:");
				String d=nn4.nextLine();
				System.out.println("Enter Phone:");
				String j=nn.nextLine();
				System.out.println("Enter address:");
				String h=nn.nextLine();
				Customer r=new Customer(n,d,h,j,s,0,2);
				boolean add=Operations.addC(r);
				if(add) {
					System.out.println("A new Customer added");
				} else {
					System.out.println("A Customer is already exist"); 
				}
				break;
				
			case 3:
                Scanner pass1 = new Scanner(System.in);
                Scanner pp1 = new Scanner(System.in);
                Scanner nn1 = new Scanner(System.in);
                Scanner ppp1 = new Scanner(System.in);

                System.out.println("Enter a worker ID you want to update:");
                String z = pass1.next();
                System.out.println("Enter a new id:");
                String s1 = pass1.next();
                System.out.println("Enter a new name:");
                String n1 = pp1.nextLine();
                System.out.println("Enter a new password:");
                String d1 = ppp1.nextLine();
                System.out.println("Enter a new Phone:");
                String j1 = nn1.nextLine();
                System.out.println("Enter a new address:");
                String h1 = nn1.nextLine();
				boolean update=Operations.updateC(z, s1, n1, h1, j1, d1);
				if(!update) {
					System.out.println("A customer was updated");
				} else {
					System.out.println("A customer was not exist");
				}
				break;
				
			
			case 4:
				int index = -1;
				Scanner pass2 = new Scanner(System.in);
				System.out.println("Enter a customer ID you want to delete:");
				String z2 = pass2.next();
				for (int i = 0; i < Customer.getCU().size(); i++) {
					if (Customer.getCU().get(i).getID().equals(z2)) {
						index = i;
					}
				}
				if (index == -1) {
					System.out.println("A customer you want to delete does not exist");
				} else {
					boolean delete = Operations.deleteC(Customer.getCU().get(index));
					if (!delete) {
						System.out.println("A customer was deleted");
					}
				}
				break;
				
			case 5:
				
				for(int i=0;i<Product.getP().size();i++) {
					System.out.printf("%d - ",i+1);
					System.out.println(Product.getP().get(i).getName()+"   "+ Product.getP().get(i).getDis()+"   "+Product.getP().get(i).getPrice());
					System.out.println();
				}
				break;
				
				
			case 6:
				Scanner id = new Scanner(System.in);
				Scanner na = new Scanner(System.in);
				Scanner dis = new Scanner(System.in);
				Scanner pr = new Scanner(System.in);


				System.out.println("Enter id:");
				String a = id.next();
				System.out.println("Enter name:");
				String b=na.nextLine();
				System.out.println("Enter description:");
				String c=dis.nextLine();
				System.out.println("Enter price:");
				String p=pr.nextLine();
				double value = Double.parseDouble(p);

				Product ne = new Product(a,b,c,value);

				boolean addd=Operations.addP(ne);
				
				if(addd) {
					System.out.println("A new Proudct added");
				} else {
					System.out.println("A Product is already exist"); 
				}
				break;
                
            	
			case 7:
				Scanner id_old = new Scanner(System.in);
				Scanner na1 = new Scanner(System.in);
				Scanner pas = new Scanner(System.in);
				Scanner p2 = new Scanner(System.in);


				System.out.println("Enter a customer ID you want to update:");
				String aa = id_old.next();
				System.out.println("Enter a new id:");
				String aa1 = id_old.next();
				System.out.println("Enter a new name:");
				String nn5 = na1.nextLine();
				System.out.println("Enter a new dis:");
				String pp2 = pas.nextLine();
				System.out.println("Enter a new price:");
				String pp3 = p2.nextLine();
				double v = Double.parseDouble(pp3);
				boolean update1 =Operations.updateP(aa,aa1,nn5,pp2,v);
				if(!update1) {
					System.out.println("A Product was updated");
				} else {
					System.out.println("Your message was sent successfully");
				}
				break;
            	
			case 8:
				int index1 = -1;
				Scanner pass3 = new Scanner(System.in);
				System.out.println("Enter a Product ID you want to delete:");
				String z3 = pass3.next();
				for (int i = 0; i < Product.getP().size(); i++) {
					if (Product.getP().get(i).getID().equals(z3)) {
						index1 = i;
					}
				}
				if (index1 == -1) {
					System.out.println("A Product you want to delete does not exist");
				} else {
					boolean delete = Operations.deleteP(Product.getP().get(index1));
					if (!delete) {
						System.out.println("A Product was deleted");
					}
				}
				break;
				
			case 9:
			    Worker worker = new Worker();
			    String message = "Your request has been completed successfully.";
			    worker.sendd(message);
			    break;

         
			case 10:
				 System.out.println("You are logged out.");
           	  int x = authenticate();
                 while(x == -1) {
                     System.out.println("The Username doesn't exist, please enter your Username again");
                     x = authenticate();   
                 }
                 if(x == 0) {
                     admin_activities();
                 } else if(x == 1) {
                     customer_activities();
                 } else {
                     worker_activities();
                 }
             
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                
                break;
				
		}
	}
}
	
	
	
	
	}