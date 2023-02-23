package fall2023project;

public class Admin {
	
	boolean logState;

	public void LogState(boolean t) {
		
		logState=t;		
	}
	public boolean getLogState() {
		
		return logState;
	}

	public void logout() {
		
		logState=false;		
	}
	

}
