package fall2023project;

import java.util.logging.Logger;

public class Worker {
	boolean logState;
	String password;
	final Logger logger = Logger.getLogger(Worker.class.getName());
	


	public Worker() {
		logState=false;
		password="worker123";
		
	}

 
	public void LogState(boolean t) {
		
		logState=t;		
	}
	public boolean getLogState() {
		
		return logState;
	}

	


}