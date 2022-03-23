
public class AdminLoggedIn {
	
	private String adminID;
	private int adminLevel;
	
	public AdminLoggedIn() {
		
		}


	public AdminLoggedIn(String adminID, int adminLevel) {
	
		this.adminID = adminID;
		this.adminLevel = adminLevel;
	
	}

	public String getAdminID() {
	
		return adminID;
	
	}

	public void setAdminID(String adminID) {
	
		this.adminID = adminID;
	
	}


	public int getAdminLevel() {
	
		return adminLevel;
	
	}

	public void setAdminLevel(int adminLevel) {
	
		this.adminLevel = adminLevel;
	
	}

}
