import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class LoginApplication {


	public static LoggedIn enterLogin(String username, String password) throws CustomException {
	
		boolean checkFields;																												// Variable to store result of method call

		try {									
		
			checkFields = checkFields(username,password);																					// Set variable to result of passing variables through given method.
	
				try {
				
					if (checkFields) {																										// If Statement. The text boxes do contain content.
					
						ResultSet loginAttempt = MySQLQueries.attemptLogin(username,password);	
						
						String currentUserID = null;
						String currentUsername = null;
			
						try {
							
							if (loginAttempt.next()) 																								
							{
								System.out.println("LoginApplication - loginAttempt");
								
								currentUserID = loginAttempt.getString("UserID");
								currentUsername = loginAttempt.getString("UserName");
								
								System.out.println(currentUserID);
								System.out.println(currentUsername);
							
								LoggedIn currentLoggedIn = new LoggedIn(currentUserID, currentUsername);
								
								return currentLoggedIn;
							
							}
						
							else
							
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
			
			throw new CustomException("Enter Details To Attempt Login", "login");
			
		}
		
		return null;	
		
	}


	private static boolean checkFields(String userName , String password) throws CustomException{								
	
		System.out.println("LoginApplication - CheckFields");
		
		boolean result;																									
		result = true;																									
	
		if (Helper.checkBlank(userName) || Helper.checkBlank(password)) {																	
		
			result = false;	
	
			throw new CustomException("Enter Valid Details To Attempt Login");													
		
		}
	
		return result;			
		
	}

}
		
