import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class LoginApplication {

	/*
public static ResultSet attemptLogin(String userName, String password) {
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();																
			String query = "SELECT * FROM Accounts where UserName = '" + userName + "' AND Password = '" + password + "'";	
			System.out.println(query);
			ResultSet results = statement.executeQuery(query);															
			System.out.println("this here " + results);
			
			return results;
			
	
		}

		catch (ClassNotFoundException cnf)
		{	
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);	
		}
		
		catch (SQLException sqe)
		{
			System.out.println("Error performing SQL Query");
			System.out.println(sqe.getMessage());
			System.exit(-1);
		}
		
		return null;	
	}
	*/

	public static void enterLogin(String username, String password, LoginScreen loginScreen) throws CustomException {
	
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
								currentUserID = loginAttempt.getString("UserID");
								currentUsername = loginAttempt.getString("UserName");
								
						
								System.out.println(currentUserID);
								System.out.println(currentUsername);
							
								LoggedIn currentLoggedIn = new LoggedIn(currentUserID, currentUsername);
								
								
								MainScreen mainScreen = new MainScreen(currentLoggedIn);
								mainScreen.setVisible(true);
								loginScreen.setVisible(false);
							}
						
							else
							{
							System.out.println("Invalid Account Details");
							throw new CustomException("Invalid Details Provided");	
							
							}
						} catch (SQLException sqe){
							
						}
					
					}
				
				} catch (CustomException error) {																							// Exception
					throw new CustomException("Enter Valid Details To Attempt Login", "login");
	
				}
			
		} catch (CustomException error) {																									// Exception
			throw new CustomException("Enter Details To Attempt Login", "login");
		
		
		}	
}


	private static boolean checkFields(String userName , String password) throws CustomException{								
	
		boolean result;																									
	
		result = true;																									
	
		if (Helper.checkBlank(userName) || Helper.checkBlank(password)) {																	
		
			result = false;	
	
			throw new CustomException("Enter Valid Details To Attempt Login");													
		
		}
	
		return result;			
		
	}

}
		
