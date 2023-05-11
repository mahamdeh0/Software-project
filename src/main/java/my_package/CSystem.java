package my_package;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;
public class CSystem {
	
    protected static HashMap<String,String> q= new HashMap<String,String>();
   protected static Scanner input = new Scanner (System.in);
    protected static int y;
    protected static Order order;
    private static  String date2;
    private SimpleDateFormat sdf ;
    private Calendar date1; 
    static Invoice i;
    public static final  String ENAME="Enter name:";
    public static final  String NEWID="Enter new ID: ";
    public static final  String DEC="%d - ";

    public static final  String EID="Enter ID:";
    public static final  String LOGOUT="You are logged out.";
    public static final  String INVALID="Invalid choice. Please try again.";
   

  public static final String NOTE="The Username doesn't exist, please enter your Username again";
    protected static Logger logger;

    public CSystem() {
         sdf = new SimpleDateFormat("yyyy/MM/dd"); 
         date1 = Calendar.getInstance();
         date1.add(Calendar.DAY_OF_MONTH, 7); 
    }
    
    public static void main(String [] args) {
    	
    	 logger = Logger.getLogger(CSystem.class.getName());


         init();
         int x = authenticate();
         while(x == -1) {
        	 logger.info(NOTE);
             x = authenticate();   
         }
         if(x == 0) {
             adminActivities();
         } else if(x == 1) {
             customerActivities();
         } else {
             workerActivities();
         }
    }	
    
    public static void init() {
        Admin a =new Admin("abd mahamdeh","passw123",0);
        Admin.getAa().add(a);

        Worker n=new Worker("woroud fouleh","123123","RAM","0568725598","122",true,2);
        Worker n1=new Worker("ahmad sam","123","nablus","0568665598","123",true,2);
        Worker n2=new Worker("leen sam","321","SAM","0568722198","124",true,2);

        Operations.addW(n);
        Operations.addW(n1);
        Operations.addW(n2);

        Customer i=new Customer("ahmad tone","222","QAM","02872228","98",0,3);
        Customer i1=new Customer("zeina sam","111","KIM","028725510","97",0,3);
        Customer i2=new Customer("emad sam","555","DAM","028725323","99",0,3);
        Customer.getCU().add(i);
        Customer.getCU().add(i1);
        Customer.getCU().add(i2);

        Product product1 = new Product("1","CarpetA" ,"Small carpet cleaning", 170);
        Product product2 = new Product("2", "CarpetB","Medium carpet cleaning", 250);
        Product product3 = new Product("3", "CarpetC","Great carpet cleaning", 400);
        Product product4 = new Product("4", "CoverA","Small cover cleaning", 150);
        Product product5 = new Product("5", "CoverB","Medium cover cleaning", 220);
        Product product6 = new Product("6", "CoverC","Great cover cleaning", 380);
        Operations.addP(product3);
        Operations.addP(product2);
        Operations.addP(product1);
        Operations.addP(product4);
        Operations.addP(product5);
        Operations.addP(product6);
        q.put("abd mahamdeh", "passw123");
        q.put("woroud fouleh","123123" );
        q.put("ahmad tone", "222");
    }


	
	
	public static int authenticate() {

	    
		logger.info("\n Welcome to the Cleaning services for carpets and covers\r\n"
	    +"Please select your role:\r\n"
	    +"1. Admin\r\n"
	    +"2. Worker\r\n"
	    +"3. Customer\r\n");

	    int roleChoice = input.nextInt();
	    input.nextLine();

	    if (roleChoice == 1 || roleChoice == 2 || roleChoice == 3) {
	    	
	    	logger.info("Enter your UserName:");
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
	        	logger.info("Enter Password");

	            while (true) {
	                String pass = input.nextLine();
	                String value = q.get(id2);
	                if (pass.equals(value)) {
	                	String f=String.format("Welcome:: %s",id2);
	                	logger.info(f);
	                    return index;
	                } else {
	                	logger.info("Please enter your password again");
	                }
	            }
	        }
	    } else {
	        return -1;
	    }
	}
		
		

	
	
	
	public static void adminActivities() {
		boolean running = true;
	    while (running) {
	    	logger.info("\n Welcome , to the Cleaning services for carpets and covers.\r\n"
	    	+"------------------------------------------------------------.\r\n"
	    	+"Select an option:.\r\n"
	    	+"1. Show all workers.\r\n"
	    	+"2. Add a new worker.\r\n"
	    	+"3. Update a worker.\r\n"
	    	+"4. Delete a worker.\r\n"
	    	+"5. Distribute the orders on the available workers.\r\n"
	    	+"6. View business reports.\r\n"
	    	+"7. View the statistics report.\r\n"
	    	+"8. LogOut.\r\n"
	    	+"9. Quit.\r\n"
            +"Enter the number of the activity you want to perform: ");
	        int choice = input.nextInt();

	        switch (choice) {
	       
	        
	            case 1:
	                for (int i = 0; i < Worker.getW().size(); i++) {
	                		String ff=String.format("%d-" ,i + 1);
	                	logger.info (ff);
	                    
	                	logger.info(Worker.getW().get(i).getName() + "   " + Worker.getW().get(i).getAddress() + "   " + Worker.getW().get(i).getPhone() + "\r\n");

	                }
	                break;
	                

	            case 2:
	                Scanner pass = new Scanner(System.in);
	                Scanner pp = new Scanner(System.in);
	                Scanner nn = new Scanner(System.in);
	                Scanner nn2 = new Scanner(System.in);


	                logger.info(EID);
	                String s = pass.next();
	                logger.info(ENAME);
	                String n = pp.nextLine();
	                logger.info("Enter password:");
	                String d = nn2.nextLine();
	                logger.info("Enter Phone:");
	                String j = nn.nextLine();
	                logger.info("Enter address:");
	                String h = nn.nextLine();
	                Worker r = new Worker(n, d, h, j, s,true, 2);
	                boolean add = Operations.addW(r);
	                if (add)
	                	logger.info("A new Worker added");
	                else
	                	logger.info("A Worker is already exist");
	                break;
	                

	            case 3:
	            	
	                Scanner pass1 = new Scanner(System.in);
	                Scanner pp1 = new Scanner(System.in);
	                Scanner nn1 = new Scanner(System.in);
	                Scanner ppp1 = new Scanner(System.in);

	                logger.info("Enter a worker ID you want to update:");
	                String z = pass1.next();
	                logger.info(NEWID);
	                String s1 = pass1.next();
	                logger.info(ENAME);
	                String n1 = pp1.nextLine();
	                logger.info("Enter a new password:");
	                String d1 = ppp1.nextLine();
	                logger.info("Enter a new Phone:");
	                String j1 = nn1.nextLine();
	                logger.info("Enter a new address:");
	                String h1 = nn1.nextLine();
	                boolean update = Operations.updateW(z, s1, n1, h1, j1, d1);
	                if (!update)
	                	logger.info("A worker was updated");
	                else
	                	logger.info("A worker was not exist");
	                break;

	            case 4:
	                int index = -1;
	                Scanner pass2 = new Scanner(System.in);
	                logger.info("Enter a worker ID you want to delete:");
	                String z1 = pass2.next();
	                for (int i = 0; i < Worker.getW().size(); i++) {
	                    if (Worker.getW().get(i).getID().equals(z1)) {
	                        index = i;
	                    }
	                }
	                if (index == -1) {
	                	logger.info("A worker you want to delete does not exist");
	                } else {
	                    boolean delete = Operations.deleteW(Worker.getW().get(index));
	                    if (!delete)
	                    	logger.info("A worker was deleted");	       
	                }
	                    break;

	            case 5:
	            	String state;
	            	String namee;
	                for (int i = 0; i < Worker.getW().size(); i++) {
	                	String xx=String.format(DEC, i + 1);
	                	logger.info(xx);
	                    if(Worker.getW().get(i).available)state="Available";
	                    else state="Not Available";
	                    String fw=String.format(" %s         %s  \r%n" ,Worker.getW().get(i).getName(),state);

	                    logger.info(fw);
	                }
	                logger.info("Write a name of worker you want to give him a job");
	                Scanner ppp = new Scanner(System.in);
                    namee= ppp.nextLine();
                    Admin.listw(Worker.getW(), namee);
	                for (int i = 0; i < Worker.getW().size(); i++) {
	                	logger.info("Done");
	                	String px=String.format(DEC, i + 1);
                       	logger.info(px);
	                    if(Worker.getW().get(i).available)state="Available";
	                    else state="Not Available";
	                    String ff=String.format(" %s         %s  \r%n" ,Worker.getW().get(i).getName(),state);
	                    logger.info(ff);
	                }     

	          
	                break;

	                
	                
	                    
	                case 6:
	                	
	                    Reports myReports = new Reports(); 
	                    myReports.generateReport(); 
	                    
	                    break;
	                case 7:
		               	 i=new Invoice(order);
	                	i.getTotalPrice(Customer.getCU().get(y).getCard());
	                	
	                	Statistics.statisticsReport();

	                	
	                    break;
	                case 8:

	                	  logger.info(LOGOUT);
	                	  int x = authenticate();
	                      while(x == -1) {
	                    	  logger.info(NOTE);
	                          x = authenticate();   
	                      }
	                      if(x == 0) {
	                          adminActivities();
	                      } else if(x == 1) {
	                          customerActivities();
	                      } else {
	                          workerActivities();
	                      }
	                  
	                	    break;
	                case 9:
	                	System.exit(0);
	                	break;


	                default:
	                	logger.info(INVALID);
	                    
	                    break;
	                    }
	        }

	}
	
	
	  
	
	
	public static void customerActivities() {
		while(true) {
			logger.info("\n Welcome to the Cleaning services for carpets and covers, Customer!\r \n"
			+"-------------------------------------------------- \r\n"
			+"Please select an option from the following menu:\r\n"
			+"1. Show all products \r\n"
			+"2. Make an order \r \n"
			+"3. Show order\r\n"
			+"4. Checkout order\r\n"
			+"5. Show my invoice\r\n"
			+"6. LogOut\r\n"
			+"7. Quit\r\n"
			+"Enter the number of the activity you want to perform:\r\n");
			
		int choice;
		choice=input.nextInt();
	     switch (choice) {
	       
	        
         case 1:
             for (int i = 0; i < Product.getP().size(); i++) {
            	 String format=String.format(DEC, i + 1);
            	 logger.info(format);
            	 logger.info(Product.getP().get(i).getName() + "   " + Product.getP().get(i).getDis()+ "   " + Product.getP().get(i).getPrice() + "\r\n");
             
             }
             break;
             
         case 2:
             for (int i = 0; i < Product.getP().size(); i++) {
            	 String format=String.format(DEC, i + 1);

            	 logger.info(format);
            	 logger.info(Product.getP().get(i).getName() + "   " + Product.getP().get(i).getDis()+ "   " + Product.getP().get(i).getPrice() + "\r\n");
             }
             logger.info("Please enter the number the type of product wou want to clean");
             int b;
             b=input.nextInt();
             b--;
             Customer.getCU().get(y).getCard().add(Product.getP().get(b));
             double r= Customer.getCU().get(y).getCost();
             r+=Product.getP().get(b).getPrice();
             Customer.getCU().get(y).setCost(r);
             logger.info("Added to your order successfully");

             

             
             break;
             
         case 3:
            for(int i=0;i<Customer.getCU().get(y).getCard().size();i++) {
            	String vv=String.format(DEC, i + 1);
            	logger.info(vv);
            	logger.info(Customer.getCU().get(y).getCard().get(i).getName() + "   " + Customer.getCU().get(y).getCard().get(i).getDis()+ "   " + Customer.getCU().get(y).getCard().get(i).getPrice() + "\r\n");
            }
            String cc=String.format("Total cost :%lf",Customer.getCU().get(y).getCost());
            logger.info(cc);           	

             break;
             
        
         case 4:
        	 order=new Order(Customer.getCU().get(y),Customer.getCU().get(y).getCard(),date2,"complete");
        	 if (Customer.getCU().get(y).getCost() >  400) {
 	        	double per=10/100.0;
 	            double discountAmount = per * Customer.getCU().get(y).getCost();
 	           Customer.getCU().get(y).setCost(Customer.getCU().get(y).getCost()-discountAmount);
 	           String aa=String.format("You has spent more than 400 NIS on orders %n So the system applies a 10 discount to your order %lf NIS applied to next order",discountAmount);
 	        		   
 	        		   
 	           logger.info(aa);
 	        } else {
 	        	logger.info("You are not eligible for discount");
 	        }
 	    
        	 logger.info("Your order checked out, Check your email. The delivery arrives after 7 days");
             boolean m=SendEmailExample.sendEmail("mahamdehabd@gmail.com", "Test Email", "The operation was completed successfully. Welcome to our beautiful laundry");
             break;


         case 5:
        	 i=new Invoice(order);
        	 i.generateInvoice(order.getProducts()); 
        	 break;
         
         case 6:
        	 logger.info(LOGOUT);
       	  int x = authenticate();
             while(x == -1) {
            	 logger.info(NOTE);
                 x = authenticate();   
             }
             if(x == 0) {
                 adminActivities();
             } else if(x == 1) {
                 customerActivities();
             } else {
                 workerActivities();
             }
         
        	 break;
         case 7:
         	System.exit(0);
         	break;

         default:
        	 logger.info(INVALID);
                 
                 break;
                 }
		
}
	}	
	
	
	
	
	public static void workerActivities() {
		while(true) {
			logger.info("\n Welcome to the Cleaning services for carpets and covers, Worker!\r\n"
			+"--------------------------------------------------"
			+"Please select an option from the following menu:\r\n"
			+"1. Show all customers\r\n"
			+"2. Add a new customer\r\n"
			+"3. Update an existing customer\r\n"
			+"4. Delete a customer\r\n"
			+"5. Show all products\r\n"
			+"6. Add a new product\r\n"
			+"7. Update an existing product\r\n"
			+"8. Delete a product\r\n"
			+"9. LogOut\r\n"
			+"10. Quit\r\n"
			+"Enter the number of the activity you want to perform:\r\n");
			
		int choice;
		choice=input.nextInt();
		

		switch(choice) {
			case 1:
				for(int i=0;i<Customer.getCU().size();i++) {
					String zz=String.format(DEC , i+1);
					logger.info(zz);
					logger.info(Customer.getCU().get(i).getName()+"   "+ Customer.getCU().get(i).getAddress()+"   "+Customer.getCU().get(i).getPhone() + "\r\n");
				}
				break;
				
			case 2:
				Scanner pass = new Scanner(System.in);
				Scanner pp = new Scanner(System.in);
				Scanner nn = new Scanner(System.in);
				Scanner nn4 = new Scanner(System.in);

				logger.info(EID);
				String s = pass.next();
				logger.info(ENAME);
				String n=pp.nextLine();
				logger.info("Enter password:");
				String d=nn4.nextLine();
				logger.info("Enter Phone:");
				String j=nn.nextLine();
				logger.info("Enter address:");
				String h=nn.nextLine();
				Customer r=new Customer(n,d,h,j,s,0,2);
				boolean add=Operations.addC(r);
				if(add) {
					logger.info("A new Customer added");
				} else {
					logger.info("A Customer is already exist"); 
				}
				break;
				
			case 3:
                Scanner pass1 = new Scanner(System.in);
                Scanner pp1 = new Scanner(System.in);
                Scanner nn1 = new Scanner(System.in);
                Scanner ppp1 = new Scanner(System.in);

                logger.info("Enter a worker ID you want to update:");
                String z = pass1.next();
                logger.info(NEWID);
                String s1 = pass1.next();
                logger.info("Enter a new name:");
                String n1 = pp1.nextLine();
                logger.info("Enter a new password:");
                String d1 = ppp1.nextLine();
                logger.info("Enter a new Phone:");
                String j1 = nn1.nextLine();
                logger.info("Enter a new address:");
                String h1 = nn1.nextLine();
				boolean update=Operations.updateC(z, s1, n1, h1, j1, d1);
				if(!update) {
					logger.info("A customer was updated");
				} else {
					logger.info("A customer was not exist");
				}
				break;
				
			
			case 4:
				int index = -1;
				Scanner pass2 = new Scanner(System.in);
				logger.info("Enter a customer ID you want to delete:");
				String z2 = pass2.next();
				for (int i = 0; i < Customer.getCU().size(); i++) {
					if (Customer.getCU().get(i).getID().equals(z2)) {
						index = i;
					}
				}
				if (index == -1) {
					logger.info("A customer you want to delete does not exist");
				} else {
					boolean delete = Operations.deleteC(Customer.getCU().get(index));
					if (!delete) {
						logger.info("A customer was deleted");
					}
				}
				break;
				
			case 5:
				
				for(int i=0;i<Product.getP().size();i++) {
	            	 String format=String.format(DEC, i + 1);

					logger.info(format);
					logger.info(Product.getP().get(i).getName()+"   "+ Product.getP().get(i).getDis()+"   "+Product.getP().get(i).getPrice() +"\r\n");
				}
				break;
				
				
			case 6:
				Scanner id = new Scanner(System.in);
				Scanner na = new Scanner(System.in);
				Scanner dis = new Scanner(System.in);
				Scanner pr = new Scanner(System.in);


				logger.info(EID);
				String a = id.next();
				logger.info(ENAME);
				String b=na.nextLine();
				logger.info("Enter description:");
				String c=dis.nextLine();
				logger.info("Enter price:");
				String p=pr.nextLine();
				double value = Double.parseDouble(p);

				Product ne = new Product(a,b,c,value);

				boolean addd=Operations.addP(ne);
				
				if(addd) {
					logger.info("A new Proudct added");
				} else {
					logger.info("A Product is already exist"); 
				}
				break;
                
            	
			case 7:
				Scanner idold = new Scanner(System.in);
				Scanner na1 = new Scanner(System.in);
				Scanner pas = new Scanner(System.in);
				Scanner p2 = new Scanner(System.in);


				logger.info("Enter a customer ID you want to update:");
				String aa = idold.next();
				logger.info(NEWID);
				String aa1 = idold.next();
				logger.info("Enter a new name:");
				String nn5 = na1.nextLine();
				logger.info("Enter a new dis:");
				String pp2 = pas.nextLine();
				logger.info("Enter a new price:");
				String pp3 = p2.nextLine();
				double v = Double.parseDouble(pp3);
				boolean update1 =Operations.updateP(aa,aa1,nn5,pp2,v);
				if(!update1) {
					logger.info("A Product was updated");
				} else {
					logger.info("Your message was sent successfully");
				}
				break;
            	
			case 8:
				int index1 = -1;
				Scanner pass3 = new Scanner(System.in);
				logger.info("Enter a Product ID you want to delete:");
				String z3 = pass3.next();
				for (int i = 0; i < Product.getP().size(); i++) {
					if (Product.getP().get(i).getID().equals(z3)) {
						index1 = i;
					}
				}
				if (index1 == -1) {
					logger.info("A Product you want to delete does not exist");
				} else {
					boolean delete = Operations.deleteP(Product.getP().get(index1));
					if (!delete) {
						logger.info("A Product was deleted");
					}
				}
				break;
				
            case 10:
            	System.exit(0);
            	break;

         
			case 9:
				logger.info(LOGOUT);
           	  int x = authenticate();
                 while(x == -1) {
                	 logger.info(NOTE);
                     x = authenticate();   
                 }
                 if(x == 0) {
                     adminActivities();
                 } else if(x == 1) {
                     customerActivities();
                 } else {
                     workerActivities();
                 }
             
                break;

            default:
            	logger.info(INVALID);
                
                break;
				
		}
	}
}
	
	
	
	
	}