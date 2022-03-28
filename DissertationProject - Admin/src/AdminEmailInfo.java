
public class AdminEmailInfo {
	
	private String firstname;
	private String surname;
	private String emailAddress;
	private String message;
	
	public AdminEmailInfo() {
		
	}


	public AdminEmailInfo(String firstname, String surname, String email) {
	
		this.firstname = firstname;
		this.surname = surname;
		this.emailAddress = email;
	
	}

	public String getFirstname() {
	
		return firstname;
	
	}

	public void setFirstname(String firstname) {
	
		this.firstname = firstname;
	
	}
	
	public String getSurname() {
		
		return surname;
	
	}

	public void setSurname(String surname) {
	
		this.surname = surname;
	
	}
	
	public String getEmailAddress() {
		
		return emailAddress;
	
	}

	public void setEmailAddress(String emailAddress) {
	
		this.emailAddress = emailAddress;
	
	}
	
	public String getMessage() {
		
		return message;
	
	}

	public void setMessage(String message) {
	
		this.message = message;
	
	}


	
}
