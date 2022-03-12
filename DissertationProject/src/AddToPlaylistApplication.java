import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddToPlaylistApplication {
	public static ResultSet search(String search, Object criteria, Object sort, String sortType) {
		
		System.out.println(search);
		System.out.println(checkBlank(search));
		
		if(checkBlank(search) == true)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
	
				System.out.println("SELECT * FROM songs ORDER BY " + sort + " " + sortType );	
				String query = "SELECT * FROM songs ORDER BY " + sort + " " + sortType;	
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
		else {
		
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
				System.out.println("SELECT * FROM songs where " + criteria + " = '" + search + "'" + " ORDER BY " + sort + " DESC");	
				String query = "SELECT * FROM songs where " + criteria + " = '" + search + "'" + " ORDER BY " + sort + " DESC";	
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
		
		
		
		
	}
	
	
public static ResultSet songOnPlaylist(String checkSongID, String currentUserID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			//System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
			//String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
			String query = "SELECT * FROM playlists where songID = '" + checkSongID + "' AND userID = '" + currentUserID + "'";
		
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
	
public static void addSong(String currentUserID, String selectedSongID, String currentPlayListTitle, int ranking) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into playlists VALUES (NULL ,'" + currentUserID +  "','" + selectedSongID + "','" + currentPlayListTitle + "','" + ranking + "')";		
		
			
			
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
}
