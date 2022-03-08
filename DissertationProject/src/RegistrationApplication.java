import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.*;  

public class RegistrationApplication {
	
	public static void createAccount(String firstName, String surname, String identity, String userName, String password, String email) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into accounts VALUES (NULL ," + firstName +  "," + surname + ", 55," + identity + "," + userName + "," + password + "," + email + " )";		
		
			
			
			statement.executeUpdate(query);															// Return the results of query to this variable. ResultSet is special variable type for databases
		
		
			statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		
		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
			System.exit(-1);
		}
	}
	
	public static void createAccount() {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into accounts VALUES (NULL , 'dave', 'smith', 20220309, 'male', 'davesmith' , 'pass' , 'dave@smith')";		
		
			
			
			statement.executeUpdate(query);															// Return the results of query to this variable. ResultSet is special variable type for databases
		
		
			statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		
		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
			System.exit(-1);
		}
	}
	
	
	public static boolean checkBlank(String text) {
		
		if (text.trim().isBlank())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean checkLength(String text) {
		
		if (text.trim().length() >= 8)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean regexCheck(String text) {
		
		System.out.print(text+"\n");
		String regex = "^(?=.*[0-9])"
                + "(?=.*[A-Z])"
                + "(?=.*[@#£$%^&+=?!])"
                + "(?=\\S+$).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		boolean matchFound = matcher.find();
		
		if (matchFound)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean regexEmail(String text) {
		
		System.out.print(text+"\n");
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+"
				+ "(?:com|co.uk)$";
	
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		boolean matchFound = matcher.find();
		
		if (matchFound)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean comparePassword(String password, String confirmPassword) {
		
		if (password.equals(confirmPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
