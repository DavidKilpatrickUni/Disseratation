import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountApplication {

	public static ResultSet getAccountsDetail(String userID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();																
			String query = "SELECT * FROM Accounts where UserID = '" + userID  + "'";	
			
			//AES_DECRYPT(AES_ENCRYPT('ABC', 'key_string'), 'key_string'); 
			System.out.println(query);
			ResultSet results = statement.executeQuery(query);															
			System.out.println("this here " + results);
			return results;
			
	
		}

		catch (ClassNotFoundException cnf)
		{	
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			
		}
		
		catch (SQLException sqe)
		{
			System.out.println("Error performing SQL Query");
			System.out.println(sqe.getMessage());
	
		}
		
		return null;	
	}
		
	public static void checkValidFirstname(String firstname) throws CustomException {
		
		if (Helper.checkBlank(firstname) |  Helper.regexSQLInjection(firstname)   )
		{
			System.out.println("firstname error");
			throw new CustomException("Valid First Name Input Required", "firstname");
			//return "firstname";
		}
		
	}
	
	public static void checkValidSurname(String surname) throws CustomException {
		
		if (Helper.checkBlank(surname) |  Helper.regexSQLInjection(surname)   )
		{
			System.out.println("surname error");
			throw new CustomException("Valid Surname Input Required", "surname");
			//return "firstname";
		}
		
	}
	
	public static void checkValidPassword(String password) throws CustomException {
		
		if  (Helper.checkBlank(password) || !Helper.regexPassword(password) ||  Helper.regexSQLInjection(password))
		{
			System.out.println("password error");
			throw new CustomException("Valid Password Input Required", "password");
			//return "firstname";
		}
		
	}
			
}
	

