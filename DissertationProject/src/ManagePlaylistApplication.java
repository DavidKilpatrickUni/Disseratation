import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ManagePlaylistApplication {
	
	
	public static ResultSet getCurrentPlaylistTitle(String currentPlaylistID){
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			//System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
			//String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
			String query = "SELECT * from  playlists where playListID = " + currentPlaylistID;
		
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
	
	public static ResultSet loadPlaylist(String currentPlaylistTitle) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			//System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
			//String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
			String query = "SELECT playlists.* , songs.* from playlists inner join songs on playlists.songID = songs.songID where playlists.playlistTitle = '" + currentPlaylistTitle + "' ORDER BY Ranking ASC";
		
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
	
	
	public static void removeFromList(String currentUserID, String currentPlaylistID ) {
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");																	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		String query = "DELETE FROM playlists WHERE UserID = '"+ currentUserID + "' and PlaylistID = '" + currentPlaylistID + "'";		
		System.out.print("DELETE FROM playlists WHERE PlaylistID = '" + currentPlaylistID + "'");	
		statement.executeUpdate(query);	
	

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
	
	public static void updatePlaylistTitle(String currentUserID, String currentPlaylistTitle, String newPlaylistTitle) {
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");																	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		String query = "SELECT * FROM playlists WHERE UserID = '" + currentUserID + "' AND PlaylistTitle =  '" + currentPlaylistTitle + "'" ;		
		System.out.println("SELECT * FROM playlists WHERE UserID = '" + currentUserID + "' AND PlaylistTitle =  '" + currentPlaylistTitle + "'") ;	
		ResultSet results = statement.executeQuery(query);			
			
		while (results.next()) 
			{

			results.updateString("PlayListTitle", newPlaylistTitle);
	
	
			
			results.updateRow();
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
	


			
		



public static void swapRanking(String playlistID1, String playlistID2 ) {
	
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");																	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);	
	
	String query = "SELECT * FROM playlists WHERE PlaylistID =  '" + playlistID1 + "'";		
	System.out.println("SELECT * FROM playlists Where PlaylistID =  '" + playlistID1 + "'") ;	
	ResultSet results = statement.executeQuery(query);	
		
	while (results.next() ) 
		{

		int currentRanking = results.getInt("Ranking");
		System.out.println("Old rank: " + currentRanking) ;	
		
		
		int newRanking = (currentRanking -1);
		
		System.out.println("New rank: " + newRanking) ;	
		
		
		
		results.updateInt("Ranking", newRanking);
		results.updateRow();
		} 
	

	
	
	
/*
	String query2 = "DELETE FROM playlists WHERE PlaylistID =  '" + playlistID1 + "'";	
	System.out.println("DELETE FROM playlists Where PlaylistID =  '" + playlistID1 + "'") ;		
	statement.executeUpdate(query2);	
*/

				

	
	
	String query3 = "SELECT * FROM playlists WHERE PlaylistID =  '" + playlistID2 + "'";		
	System.out.println("SELECT * FROM playlists Where PlaylistID =  '" + playlistID2 + "'") ;	
	ResultSet results3 = statement.executeQuery(query3);	
		
	while (results3.next() ) 
		{

		int currentRanking2 = results3.getInt("Ranking");
		System.out.println("Old rank2: " + currentRanking2) ;	
		
		int newRanking2 = (currentRanking2 +1);
		System.out.println("New rank2: " + newRanking2) ;	
		
		results3.updateInt("Ranking", newRanking2);
		results3.updateRow();
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


/*
String query2 = "SELECT * FROM playlists WHERE PlaylistID =  '" + playlistID2 + "'";		
System.out.println("SELECT * FROM playlists Where PlaylistID =  '" + playlistID2 + "'") ;	
ResultSet results2 = statement.executeQuery(query2);	
	
while (results2.next() ) 
	{

	int currentRanking2 = results2.getInt("Ranking");
	currentRanking2 = currentRanking2 +1;
	results.updateInt("Ranking", currentRanking2);
	
	} 

results2.updateRow();

**/
