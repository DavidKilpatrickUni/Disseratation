/**
 * <h1> Class </h1>
 * 
 * <p>
 * Application part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * AddToPlaylistApplication
 * </p>
 * 
 * <p>
 * AddToPlaylist Application of the program that stores methods/process/tasks quickly available to the AddToPlaylistScreen.
 * <br>Has a direct link with <code>AddToPlaylistScreen</code> that receives user input.
 * </p>
 * 
 *
 * @see AddToPlaylistScreen
 */

public class AddToPlaylistApplication {
	/*
	
public static ResultSet search(Object search, Object criteria, Object sort, String sortType, int offset, int count) {
		
		
		if(search == null || search.equals(""))
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
				System.out.println("SELECT * FROM songs ORDER BY " + criteria  + " " + sortType+ ", " + sort+  " " + sortType + " LIMIT " + offset + "," + count +";");	
				String query = "SELECT * FROM songs ORDER BY " + criteria + " " + sortType + ", " + sort + " " + sortType + " LIMIT " + offset + "," + count +";";		
				
				//System.out.println("SELECT songs.*, ratings.* FROM songs inner join ratings on songs.songID = ratings.songID GROUP BY songs.songID ORDER BY " + sort + " " + sortType );	
				//String query = "SELECT songs.*, ratings.* FROM songs inner join ratings on songs.songID = ratings.songID GROUP BY songs.songID ORDER BY " + sort + " " + sortType;
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
		else
		{
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
				System.out.println("SELECT * FROM songs where " + criteria + "='" + search + "'" + "ORDER BY " + sort + " " + sortType + " LIMIT " + offset + "," + count +";");	
				String query = "SELECT * FROM songs where " + criteria + "='" + search + "'" + "ORDER BY " + sort + " " + sortType  + " LIMIT " + offset + "," + count +";";	
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
	*/
	/*
public static ResultSet songOnPlaylist(String checkSongID, String currentUserID, String playlistTitle) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			//System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
			//String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
			String query = "SELECT * FROM playlists where songID = '" + checkSongID + "' AND userID = '" + currentUserID + "' AND playlistTitle = '" + playlistTitle + "'";
		
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
	/*
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

*/
	/*
public static ResultSet getPlaylistID(String currentUserID, String currentPlaylistTitle) {
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");																	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		Statement statement = conn.createStatement();
		//System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
		//String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
		String query = "SELECT * FROM playlists where userID = '" + currentUserID + "' AND PlaylistTitle = '" + currentPlaylistTitle + "'";
	
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




}
