import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyProfileApplication {

	
	public static ResultSet getProfileDetail(String userID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();																
			String query = "SELECT * FROM Accounts where UserID = '" + userID  + "'";	
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
	
public static void updateGenre(String userID, String genre1, String genre2, String genre3) {
		
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");																	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
	String query = "SELECT * FROM Accounts WHERE UserID = '"+ userID + "'";									
	ResultSet results = statement.executeQuery(query);			
		
	if (results.next()) 
		{
		results.first();
		results.updateString("Genre One", genre1);
		results.updateString("Genre Two", genre2);
		results.updateString("Genre Three", genre3);
		
		results.updateRow();
		} 
		else 
		{
			System.out.println("Record does not exist");
		}

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
}
	
	

