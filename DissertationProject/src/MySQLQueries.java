import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MySQLQueries {

	
	public static ResultSet attemptLogin(String username, String password) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			//Statement statement = conn.createStatement();				
			
			//String query = "SELECT * FROM Accounts where UserName = '" + userName + "' AND Password = '" + password + "'";
			
			String query = "SELECT * FROM Accounts WHERE UserName = ? AND password = ?";
			//System.out.println(query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			System.out.println("prepared: " + stmt);
			
			ResultSet results = stmt.executeQuery();															
			//System.out.println("this here " + results);
			
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
	
	public static void createAccount(String firstName, String surname, String DOB, String identity, String userName, String password, String email) throws CustomException {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into accounts VALUES (NULL ,'" + firstName +  "','" + surname + "','" + DOB + "','" + identity + "','" + userName + "','" + password + "','" + email + "', null, null, null, null, null, null )";		
		
			
			
			statement.executeUpdate(query);															// Return the results of query to this variable. ResultSet is special variable type for databases
		
		
			statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			
		
		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
			System.err.println(sqlException.getMessage().substring(0,16));
			
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
				//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
			
			
		}
	}
	
	
	
}
