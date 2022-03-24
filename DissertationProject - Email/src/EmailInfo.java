
public class EmailInfo {
	
	private String firstname;
	private String surname;
	private String email;
	private String message;
	
	public EmailInfo() {
		
	}


	public EmailInfo(String firstname, String surname, String email) {
	
		this.firstname = firstname;
		this.surname = surname;
		this.email = email;
	
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
	
	public String getEmail() {
		
		return email;
	
	}

	public void setEmail(String email) {
	
		this.email = email;
	
	}
	
	public String getMessage() {
		
		return message;
	
	}

	public void setMessage(String message) {
	
		this.message = message;
	
	}


	
}
