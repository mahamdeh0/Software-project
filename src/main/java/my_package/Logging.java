package my_package;


import java.util.logging.Logger;

public class Logging {
	
	boolean logState;
	String password;
	final Logger logger = Logger.getLogger(Logging.class.getName());
	
	public Logging() {
		logState=false;
	}

 
	public void logState(boolean t) {
		
		logState=t;		
	}
	public boolean getLogState() {
		
		return logState;
	}

	public void logout() {
		
		logState=false;		
	}

	public boolean login(String password) {

			if(this.password.equals(password)) {
				logger.info("successfull log in");
				logState=true;
				return true;
		
			}
			else {
				logger.info("wrong password");
				return false;
			}
		}
	








	

}
