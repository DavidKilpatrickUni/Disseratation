

public class CustomException extends Exception {


		
	private String errorMessage = "Error has occured";												
	private String reason = "Generic Reason";

		
	public CustomException() {
			
	}
		

		
	public CustomException(String altErrorMessage) {
			
			errorMessage = altErrorMessage;
			
	}
	
	public CustomException(String altErrorMessage, String altReason) {
		
		errorMessage = altErrorMessage;
		reason = altReason;
}
		

		
	public String getMessage() {

			return errorMessage;
		
	}
		

		
	public String toStringMessage() {
			
		return getMessage();
			
	}
		
		
	public String getReason() {

		return reason;
	
}
	

	
public String toStringReason() {
		
	return getReason();
		
}

}
