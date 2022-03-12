import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SuggestSongApplication {
	
	public static void suggestSong(String title, String artist, String genre, int rating, String songLength, String released, String album, String songInfo) {
		
		String uploaded = changeDateFormat(LocalDate.now());
		//uploaded = dateForDatabase(uploaded);
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into songs VALUES (NULL ,'" + title +  "','" + artist + "','" + genre + "','" + rating + "','" + songLength + "','" + released + "','" + album + "','" + songInfo + "','" + uploaded + "','" + 1 + "')";		
		
			
			
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
		
		if (text.strip().isBlank())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static String changeDateFormat(LocalDate localDate) {
	
	
	

		DateTimeFormatter myPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = localDate.format(myPattern);

		return formattedDate;
	}

	public static String dateForDatabase(String date) {
	
	
		String replaceString = date.replace("-", "");


		return replaceString;
	}



}
