
/**
 * <h1> Class </h1>
 * 
 * <p>
 * Lower level part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * CustomException
 * </p>
 * 
 * <p>
 * CustomException is an extension of <code>Exception</code> and is primarily used to throw validation checks, so the user can be alerted and given feedback.
 * <br> On creation can have a: 
 * <br> 1. A Message <code>String</code> that is used to display fault/error to the user as feedback.
 * <br> 2. A Reason <code>String</code> that is used as a parameter in Switch statements for decision making. 
 * </p>
 * 
 *@see Exception 
 *@see String
 */
public class CustomException extends Exception {

	// Variables
	
	private String errorMessage = "Error has occured";												
	private String reason = "Generic Reason";
		
	// Constructors
	// Default 
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>CustomException</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Constructor to create a <code>CustomException</code> with no parameters.
	 * </p>
	 * 
	 * 
	 * @see CustomException
	 *
	 */
	
	public CustomException() {
			
	}
		
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>CustomException</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Constructor to create a <code>CustomException</code> with message parameter.
	 * </p>
	 * <p>
	 * Parameter is the created message associated with the exception
	 * </p>
	 * 
	 * @param altErrorMessage			<code>String</code> object to store message.
	 * 
	 * @see CustomException
	 * @see String
	 *
	 */
	
	public CustomException(String altErrorMessage) {
			
			errorMessage = altErrorMessage;		
	}
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>CustomException</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Constructor to create a <code>CustomException</code> with message and reason parameters.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the message for Exception. A <code>String</code> object is used to store the data.
	 * <br>Parameter is the reason for Exception. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param altErrorMessage			<code>String</code> object to store message for exception.
	 * @param altReason					<code>String</code> object to store reason for exception.
	 * 
	 * @see CustomException
	 * @see String
	 *
	 */
	public CustomException(String altErrorMessage, String altReason) {
		
		errorMessage = altErrorMessage;
		reason = altReason;
	}
		
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To return message for given <code>CustomException</code>.
	 * </p>
	 * 
	 *
	 * @see CustomException
	 * @see String
	 */
		
	public String getMessage() {

			return errorMessage;	
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To set message for given <code>CustomException</code> to parameter provided.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the message for Exception. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param altErrorMessage			<code>String</code> object to store message.
	 *
	 * @see CustomException
	 * @see String
	 */
		
	public void setMessage(String altErrorMessage) {

		this.errorMessage = altErrorMessage;
		
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * A ToString method for message of given <code>CustomException</code>.
	 * </p>
	 * 
	 *
	 * @see CustomException
	 * @see String
	 */
		
	public String toStringMessage() {
			
		return getMessage();
			
	}
		
		
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To return reason for given <code>CustomException</code>.
	 * </p>
	 * 
	 *
	 * @see CustomException
	 * @see String
	 */
	public String getReason() {

		return reason;
	
	}
	
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To set reason for given <code>CustomException</code> to parameter provided.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the reason for Exception. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param altReason			<code>String</code> object to store reason.
	 *
	 * @see CustomException
	 * @see String
	 */
	public void setReason(String altReason) {

		this.reason = altReason;
		
	}
	
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * A ToString method for reason of given <code>CustomException</code>.
	 * </p>
	 * 
	 *
	 * @see CustomException
	 * @see String
	 */
	public String toStringReason() {
		
		return getReason();
		
	}

}
