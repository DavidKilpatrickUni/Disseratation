

public class LoggedIn {
	
	private String currentUserID;
	private String currentUserName;
	
	public LoggedIn() {
		
		}


	public LoggedIn(String currentUserID, String currentUserName) {
	
		this.currentUserID = currentUserID;
		this.currentUserName = currentUserName;
	
	}

	public String getCurrentUserID() {
	
		return currentUserID;
	
	}

	public void setCurrentUserID(String currentUserID) {
	
		this.currentUserID = currentUserID;
	
	}


	public String getCurrentUserName() {
	
		return currentUserName;
	
	}

	public void setCurrentUserName(String currentUserName) {
	
		this.currentUserName = currentUserName;
	
	}

}
