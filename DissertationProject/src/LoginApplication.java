import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Application part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * LoginApplication
 * </p>
 * 
 * <p>
 * LoginApplication of the program that stores methods/process/tasks quickly available to the <code>LoginScreen</code>.
 * <br> Has a direct link with <code>LoginScreen</code> that receives user input.
 * <br> Uses CustomException to throw exceptions - this is when validation errors occur to give user feedback onscreen 
 * </p>
 * 
 *
 * @see LoginScreen
 * @see CustomException
 */

public class LoginApplication {


	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input from <code>LoginScreen</code> and calls other methods to process and validate the inputs given.
	 * <br> Is primary method in attempting a login to the Elenco system. 
	 * <br> Takes a user input of username and password and compares those inputs to the database.
	 * <br> A valid match allows access to the rest of the program, invalid does not and feedback is given in response.
	 * <br> Any validation error is thrown using <code>CustomException</code>
	 * </p>
	 * 
	 * <p>
	 * Parameter is the username provided by user. A <code>String</code> object is used to store the data.
	 * <br> Parameter is the password provided by user. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param username			<code>String</code> object to store user input.
	 * @param password			<code>String</code> object to store user input.
	 *
	 * @see LoginApplication
	 * @see LoginScreen
	 * @see CustomException
	 * @see String
	 */
	
	public static LoggedIn enterLogin(String username, String password) throws CustomException {
	
		boolean checkFields;																												

		try {								
		
			checkFields = checkFields(username,password);													// Calls method to check user input has content (not blank) 																			
	
				try {
				
					if (checkFields) {																		// If content																							
					
						ResultSet loginAttempt = MySQLQueries.attemptLogin(username,password);				// Search database for account row with same details
						
						String currentUserID = null;
						String currentUsername = null;
			
						try {
							
							if (loginAttempt.next()) 														// If a Result Set is found from above sql query																				
							{
								System.out.println("LoginApplication - loginAttempt");
								
								currentUserID = loginAttempt.getString("UserID");							// Set variable to row content of column name
								currentUsername = loginAttempt.getString("UserName");						// Set variable to row content of column name
								
								System.out.println(currentUserID);
								System.out.println(currentUsername);
							
								LoggedIn currentLoggedIn = new LoggedIn(currentUserID, currentUsername);	// Create new instance of object with the desired parameters - This is the logged in user, whose deatils is passed throught the program
								
								return currentLoggedIn;
							
							}
						
							else																			// If fails or false in previous decision points, throw a CustomException or sql exception
							
							{
								throw new CustomException("Invalid Details Provided");						
							}
							
						} catch (SQLException sqe){
							
						}
					
					}
				
				} catch (CustomException error) {
					
					throw new CustomException("Enter Valid Details To Attempt Login", "login");	
					
				}
			
		} catch (CustomException error) {
			
			throw new CustomException("Enter Valid Details To Attempt Login", "login");	
			
		}
		
		return null;	
		
	}


	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input parameters originally from <code>LoginScreen</code> passed by another method.
	 * <br> Is a convenient housing method for checking content exists for multiple inputs (inputs not blank)
	 * <br> Any validation error is thrown using <code>CustomException</code>
	 * </p>
	 * 
	 * <p>
	 * Parameter is the username provided by user. A <code>String</code> object is used to store the data.
	 * <br> Parameter is the password provided by user. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param username			<code>String</code> object to store user input.
	 * @param password			<code>String</code> object to store user input.
	 *
	 * @see LoginApplication
	 * @see LoginScreen
	 * @see CustomException
	 * @see String
	 */
	public static boolean checkFields(String username , String password) throws CustomException{								
	
		System.out.println("LoginApplication - CheckFields");
		
		boolean result;																									
		result = true;																									
	
		if (Helper.checkBlank(username) || Helper.checkBlank(password)) {					// Check inputs not blank																
		
			result = false;	
	
			throw new CustomException("Enter Valid Details To Attempt Login");													
		
		}
	
		return result;			
		
	}

}
		
