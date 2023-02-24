package fall2023project;

import java.util.logging.Logger;

public class Admin {
	
	boolean logState;
	String password;
	final Logger logger = Logger.getLogger(Admin.class.getName());


	public void LogState(boolean t) {
		
		logState=t;		
	}
	public boolean getLogState() {
		
		return logState;
	}

	public void logout() {
		
		logState=false;		
	}

	public boolean login(String password) {

		if(logState) {
			logger.info("you are already logged in");
			return false;
		}
		else {
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

	

}
