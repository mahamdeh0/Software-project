package fall2023project;

import java.util.logging.Logger;

public class Admin {
	
	boolean logState;
	String password;
	final Logger logger = Logger.getLogger(Admin.class.getName());
	
	
	public Admin() {
		logState=false;
		password="123456";
	}
	
		public void LogState(boolean t) {
			
			logState=t;		
		}
		public boolean getLogState() {
			
			return logState;
		}

	



	

}
