/**
 * <h1> Class </h1>
 * 
 * <p>
 * Lower level part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * LoggedIn
 * </p>
 * 
 * <p>
 * An Object class to hold information about the current user that is currently logged into the program - Currently username and userID but this is open to further possibilities or requirements
 * <br> This provided a quick and easy way to access and add data to that is beneficial during runtime of this program.
 * <br> Was also decided as the best way to pass data between GUI elements to keep the data of the user consistent and produce expected screen content and SQL query returns.
 * </p>
 * 
 */

public class LoggedIn {
	
	// Variables
	
	private String currentUserID;
	private String currentUserName;
	
	// Constructors
	// Default 
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>LoggedIn</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Constructor to create a <code>LoggedIn</code> with no parameters.
	 * </p>
	 * 
	 * 
	 * @see LoggedIn
	 *
	 */
	
	public LoggedIn() {
		
		}

	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>LoggedIn</code> class with <code>String</code> parameters. 
	 * </p>
	 * 
	 * <p>
	 * Constructor to create a <code>LoggedIn</code> with parameters of userID and username.
	 * </p>
	 * 
	 *<p>
	 * Parameter is the userID of current logged in user. A <code>String</code> object is used to store the data.
	 * <br> Parameter is the username of current logged in user. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID			<code>String</code> object to store userID of user.
	 * @param currentUserName			<code>String</code> object to store username of user.
	 * 
	 * @see LoggedIn
	 * @see String
	 */
	public LoggedIn(String currentUserID, String currentUserName) {
	
		this.currentUserID = currentUserID;
		this.currentUserName = currentUserName;
	
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To return userID for given <code>LoggedIn</code> instance.
	 * </p>
	 * 
	 *
	 * @see LoggedIn
	 * @see String
	 */

	public String getCurrentUserID() {
	
		return currentUserID;
	
	}

	/**
	 * <h1> Method </h1>
	 * <p>
	 * To set userID for given <code>LoggedIn</code> instance to parameter provided.
	 * </p>
	 *
	 * <p>
	 * Parameter is the userID for current user. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID			<code>String</code> object to store message.
	 *
	 * @see LoggedIn
	 * @see String
	 */
	public void setCurrentUserID(String currentUserID) {
	
		this.currentUserID = currentUserID;
	
	}


	/**
	 * <h1> Method </h1>
	 * <p>
	 * To return username for given <code>LoggedIn</code> instance.
	 * </p>
	 * 
	 *
	 * @see LoggedIn
	 * @see String
	 */
	public String getCurrentUserName() {
	
		return currentUserName;
	
	}

	/**
	 * <h1> Method </h1>
	 * <p>
	 * To set username for given <code>LoggedIn</code> instance to parameter provided.
	 * </p>
	 *
	 * <p>
	 * Parameter is the username for current user. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID			<code>String</code> object to store message.
	 *
	 * @see LoggedIn
	 * @see String
	 */
	public void setCurrentUserName(String currentUserName) {
	
		this.currentUserName = currentUserName;
	
	}

}
