import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ViewSongApplication {
	
public static ResultSet songDetails(String songID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
			String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
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

public static ResultSet getComments(String songID) {
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");																	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		Statement statement = conn.createStatement();
		//System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
		//String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
		String query = "SELECT songs.* , comments.*, accounts.* from comments inner join accounts on accounts.UserID = comments.UserID inner join songs on songs.SongID = comments.SongID where songs.songID = '" + songID + "'";
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

public static void addComment(String songID, String userID, String comment) {
	
	String posted = changeDateFormat(LocalDate.now());
	
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
		Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database

		String query = "Insert Into comments VALUES (NULL ,'" + songID +  "','" + userID + "','" + comment + "','" + posted + "' )";		
	
		
		
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

public static String changeDateFormat(LocalDate localDate) {
	
	
	

	DateTimeFormatter myPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String formattedDate = localDate.format(myPattern);

	return formattedDate;
}




}
