import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminSQL {
	
	public static ResultSet attemptLogin(String adminName, String adminPassword) {
		
		String decrypt = AdminEncryption.getEncryptionKey();
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

		
			String query = "SELECT * FROM admin WHERE AdminName = ? AND AdminPassword = AES_ENCRYPT(?,?)";
			System.out.println("Query: " + query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, adminName);
			stmt.setString(2, adminPassword);
			stmt.setString(3, decrypt);
			
			System.out.println("Prepared: " + stmt);
			
			ResultSet results = stmt.executeQuery();															

			return results;
			
		}
		catch (ClassNotFoundException cnf)
		{	
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
		}
		
		catch (SQLException sqlException)
		{
			System.out.println("Error performing SQL Query");
			System.out.println(sqlException.getMessage());
		
		}
		
		return null;	
	}
	
	public static ResultSet populateComboBox(Object comboBoxCriteria) {
		
		String sortType = "ASC";
	
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			System.out.println("SELECT * FROM songs GROUP BY "+ comboBoxCriteria.toString());	
			String query = "SELECT * FROM songs GROUP BY " + comboBoxCriteria.toString() ;		

			System.out.println(query);
			ResultSet results = statement.executeQuery(query);															


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
	
	public static ResultSet search(Object search, Object criteria, int offset, int count) {
		
		
		if(search == null || search.equals(""))
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
				String query = "SELECT * FROM songs ORDER BY " + criteria + " LIMIT ? , ?";
				System.out.println("Query: " + query);
				
				
				PreparedStatement stmt = conn.prepareStatement(query);
	
				stmt.setInt(1, offset);
				stmt.setInt(2, count);
				
				System.out.println("Prepared: " + stmt);
				
				ResultSet results = stmt.executeQuery();															

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
	
				
				String query = "SELECT * FROM songs WHERE " + criteria + "= ? LIMIT ?, ?;";	

				PreparedStatement stmt = conn.prepareStatement(query);
				
				stmt.setString(1, search.toString());
				stmt.setInt(2, offset);
				stmt.setInt(3, count);
				
				System.out.println("Prepared: " + stmt);
				
				ResultSet results = stmt.executeQuery();															

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
	
	}
	
	public static ResultSet songDetails(String songID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

			String query = "SELECT * FROM songs WHERE SongID = ? ";
			System.out.println("Query: " + query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, songID);
	
			
			System.out.println("Prepared: " + stmt);
			
			ResultSet results = stmt.executeQuery();															

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
	
	public static void deleteSong(String songID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");		
		
			String query = "DELETE FROM songs WHERE songID = ?" ;		
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, songID);
		
			
			System.out.println("prepared: " + stmt);
			
			stmt.executeUpdate();	
	

			stmt.close();										
			conn.close();											
			
			
		}
		catch (ClassNotFoundException cnf) 
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());

		} 
		catch (SQLException sqe) 
		{
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
		}
			
		
	}
	
	public static void updateSong(String title, String artist, String genre, String length, String released, String album, String info, String songID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
			String query = "UPDATE songs SET Title = ? , Artist = ?, Genre = ? , `Song Length` = ? , Released = ? , Album = ? , `Song Info` = ? WHERE songID = ?";	
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
			stmt.setString(1, title);
			stmt.setString(2, artist);
			stmt.setString(3, genre);
			stmt.setString(4, length);
			stmt.setString(5, released);
			stmt.setString(6, album);
			stmt.setString(7, info);
			stmt.setString(8, songID);
			
	
			System.out.println("prepared: " + stmt);
	
			stmt.executeUpdate();
		
			stmt.close();										
			conn.close();												
			
			
		}
		catch (ClassNotFoundException cnf) 
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			
		} 
		catch (SQLException sqe) 
		{
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
		}
			
		
	}
	
	public static ResultSet popoulateWithUserName() {

		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();

			String query = "SELECT accounts.* , playlists.* FROM accounts INNER JOIN playlists on accounts.UserID = playlists.UserID GROUP BY accounts.UserName";		
			
			System.out.println("Query: " + query);
			ResultSet results = statement.executeQuery(query);															

		
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
	
	
	
	public static ResultSet popoulateWithPlaylistTitle() {

		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
	
			String query = "SELECT accounts.* , playlists.* FROM accounts INNER JOIN playlists on accounts.UserID = playlists.UserID GROUP BY playlists.PlaylistTitle";		
		

			System.out.println("Query: " + query);
			ResultSet results = statement.executeQuery(query);															

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
	
	public static ResultSet populateForCommentsUsername() {

		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
		
			String query = "SELECT comments.* , accounts.* , songs.* FROM comments INNER JOIN accounts on accounts.UserID = comments.UserID INNER JOIN songs on comments.SongID = songs.SongID GROUP BY accounts.UserName";		
		

			System.out.println("Query: " + query);
			ResultSet results = statement.executeQuery(query);															

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
	
	public static ResultSet popoulateForCommentsSongID() {

		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
	
			String query = "SELECT comments.* , songs.* , accounts.* FROM comments INNER JOIN songs on songs.SongID = comments.SongID INNER JOIN accounts on comments.UserID = accounts.UserID GROUP BY songs.SongID";			
		

			System.out.println("Query: " + query);
			ResultSet results = statement.executeQuery(query);															

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
	
	public static ResultSet searchForPlaylists(Object search, Object criteria, int offset, int count) {
		
		if(search == null & criteria.equals("UserName"))
		{
		
			try
			{
				System.out.println("no search + username");
			
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

				String query = "SELECT playlists.*, accounts.* FROM playlists INNER JOIN accounts ON playlists.userID = accounts.userID GROUP BY playlistTitle, playlists.userID ORDER BY playlists.userID DESC, playlistTitle LIMIT ? , ?" ;
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, offset);
				stmt.setInt(2, count);
		
				System.out.println("Prepared: " + stmt);
			
				ResultSet results = stmt.executeQuery();															
			

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
		
		else if (criteria.equals("UserName"))
		{
			try
			{
				
				System.out.println("just username");
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

				String query = "SELECT playlists.*, accounts.* FROM playlists INNER JOIN accounts ON playlists.userID = accounts.userID WHERE " + criteria +" = ? GROUP BY playlistTitle LIMIT ? , ? " ;
				
				PreparedStatement stmt = conn.prepareStatement(query);
		
				stmt.setString(1, search.toString());
				stmt.setInt(2, offset);
				stmt.setInt(3, count);
				
		
				System.out.println("Prepared: " + stmt);
			
				ResultSet results = stmt.executeQuery();															
			

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
		
		else if (search == null  & criteria.equals("PlaylistTitle") )
		{
			try
			{
				
				System.out.println("no search + playlistTitle");
				
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				
				String query = "SELECT playlists.*, accounts.* FROM playlists INNER JOIN accounts ON playlists.userID = accounts.userID GROUP BY playlistTitle, playlists.userID ORDER BY playlistTitle, playlists.userID DESC LIMIT ? , ?" ;
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, offset);
				stmt.setInt(2, count);
		
				System.out.println("Prepared: " + stmt);
			
				ResultSet results = stmt.executeQuery();															

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
				System.out.println("else");
				
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
				String query = "SELECT playlists.*, accounts.* FROM playlists INNER JOIN accounts ON playlists.userID = accounts.userID WHERE " + criteria +" = ? GROUP BY userName LIMIT ? , ? " ;
				
				PreparedStatement stmt = conn.prepareStatement(query);
		
				stmt.setString(1, search.toString());
				stmt.setInt(2, offset);
				stmt.setInt(3, count);
				
		
				System.out.println("Prepared: " + stmt);
			
				ResultSet results = stmt.executeQuery();															
			

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
			
	}
	
	public static void deletePlaylist(String currentUserID, String currentPlaylistTitle ) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");		
		
			String query = "DELETE FROM playlists WHERE UserID = ? AND PlaylistTitle = ?";		
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
			stmt.setString(2, currentPlaylistTitle);
			
			System.out.println("prepared: " + stmt);
			
			stmt.executeUpdate();	
	

			stmt.close();										
			conn.close();											
			
			
		}
		catch (ClassNotFoundException cnf) 
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());

		} 
		catch (SQLException sqe) 
		{
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
		}
			
		
	}
	
	public static ResultSet searchComments(Object search, Object criteria , int offset, int count) {
		
		System.out.println("search text: " + criteria);
		
		if (search == null & criteria.toString().equals("SongID"))
		{
		
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				
				String query = "SELECT songs.* , comments.*, accounts.* FROM comments INNER JOIN accounts on accounts.UserID = comments.UserID INNER JOIN songs on songs.SongID = comments.SongID ORDER BY comments.SongID LIMIT ? , ? ;";
				System.out.println("Query: " + query);
			
			
				PreparedStatement stmt = conn.prepareStatement(query);

				stmt.setInt(1, offset);
				stmt.setInt(2, count);
	
			
				System.out.println("Prepared: " + stmt);
			
				ResultSet results = stmt.executeQuery();															

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
		else if ( criteria.toString().equals("SongID"))
		{
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				
				String query = "SELECT songs.* , comments.*, accounts.* FROM comments INNER JOIN accounts on accounts.UserID = comments.UserID INNER JOIN songs on songs.SongID = comments.SongID where songs.songID = ?  ORDER BY comments.SongID LIMIT ? , ? ;";
				System.out.println("Query: " + query);
			
			
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, search.toString());
				stmt.setInt(2, offset);
				stmt.setInt(3, count);
	
			
				System.out.println("Prepared: " + stmt);
			
				ResultSet results = stmt.executeQuery();															

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
		else if (search == null & criteria.toString().equals("UserName"))
		{
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
				String query = "SELECT songs.* , comments.*, accounts.* FROM comments INNER JOIN accounts on accounts.UserID = comments.UserID INNER JOIN songs on songs.SongID = comments.SongID ORDER BY accounts.UserName LIMIT ? , ? ;";
				System.out.println("Query: " + query);
				
				
				PreparedStatement stmt = conn.prepareStatement(query);
		
				stmt.setInt(1, offset);
				stmt.setInt(2, count);
		
				
				System.out.println("Prepared: " + stmt);
				
				ResultSet results = stmt.executeQuery();															

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
		
				String query = "SELECT songs.* , comments.*, accounts.* FROM comments INNER JOIN accounts on accounts.UserID = comments.UserID INNER JOIN songs on songs.SongID = comments.SongID where accounts.UserName = ? ORDER BY accounts.UserName LIMIT ? , ? ;";
				System.out.println("Query: " + query);
				
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, search.toString());
				stmt.setInt(2, offset);
				stmt.setInt(3, count);
		
				
				System.out.println("Prepared: " + stmt);
				
				ResultSet results = stmt.executeQuery();															

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
	}

	
	public static void deleteComment(String commentID ) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");		
		
			String query = "DELETE FROM comments WHERE CommentID = ?";		
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, commentID);
		
			
			System.out.println("prepared: " + stmt);
			
			stmt.executeUpdate();	
	

			stmt.close();										
			conn.close();											
			
			
		}
		catch (ClassNotFoundException cnf) 
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());

		} 
		catch (SQLException sqe) 
		{
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
		}
			
		
	}
	
	public static ResultSet popoulateForSearchAccounts(Object criteria) {

		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();

			String query = "SELECT " + criteria.toString()  + " FROM accounts";		
			
			System.out.println("Query: " + query);
			ResultSet results = statement.executeQuery(query);															

		
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
	
	public static ResultSet searchAccounts(Object search, Object criteria, int offset, int count) {
		
		
		if(search == null || search.equals(""))
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
				String query = "SELECT * FROM accounts ORDER BY " + criteria + " LIMIT ? , ?";
				System.out.println("Query: " + query);
				
				
				PreparedStatement stmt = conn.prepareStatement(query);
	
				stmt.setInt(1, offset);
				stmt.setInt(2, count);
				
				System.out.println("Prepared: " + stmt);
				
				ResultSet results = stmt.executeQuery();															

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
	
				
				String query = "SELECT * FROM accounts WHERE " + criteria + "= ? LIMIT ?, ?;";	

				PreparedStatement stmt = conn.prepareStatement(query);
				
				stmt.setString(1, search.toString());
				stmt.setInt(2, offset);
				stmt.setInt(3, count);
				
				System.out.println("Prepared: " + stmt);
				
				ResultSet results = stmt.executeQuery();															

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
		
		
	}
	
	public static ResultSet accountDetails(String userID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

			String query = "SELECT *, AES_DECRYPT(Password,?) FROM Accounts WHERE USERID = ?";
			System.out.println("Query: " + query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, "encrypt");
			stmt.setString(2, userID);
	
			
			System.out.println("Prepared: " + stmt);
			
			ResultSet results = stmt.executeQuery();															

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
	
	public static void updateFirstname(String currentUserID, String firstname)  {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT * FROM Accounts WHERE UserID = ?";
			System.out.println("Query: " + query);
		
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
	
			System.out.println("prepared: " + stmt);
		
			ResultSet results = stmt.executeQuery();
		
			
			if (results.next()) 
			{
				results.first();
				results.updateString("First Name", firstname);
	
			
				results.updateRow();
			} 
			else 
			{
				System.out.println("Record does not exist");
			}

			stmt.close();
			conn.close();			
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
	
		}
			
		
	}
	
	public static void updateSurname(String currentUserID, String surname)  {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT * FROM Accounts WHERE UserID = ?";
			System.out.println("Query: " + query);
		
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
	
			System.out.println("prepared: " + stmt);
		
			ResultSet results = stmt.executeQuery();
		
			
			if (results.next()) 
			{
				results.first();
				results.updateString("Last Name", surname);
	
			
				results.updateRow();
			} 
			else 
			{
				System.out.println("Record does not exist");
			}

			stmt.close();
			conn.close();			
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
	
		}
			
		
	}
	
	
	public static void updateIdentity(String currentUserID, String identity)  {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT * FROM Accounts WHERE UserID = ?";
			System.out.println("Query: " + query);
		
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
	
			System.out.println("prepared: " + stmt);
		
			ResultSet results = stmt.executeQuery();
		
			
			if (results.next()) 
			{
				results.first();
				results.updateString("Identity", identity);
	
			
				results.updateRow();
			} 
			else 
			{
				System.out.println("Record does not exist");
			}

			stmt.close();
			conn.close();			
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
	
		}
			
		
	}
	
	public static void updateDOB(String currentUserID, String DOB)  {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT * FROM Accounts WHERE UserID = ?";
			System.out.println("Query: " + query);
		
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
	
			System.out.println("prepared: " + stmt);
		
			ResultSet results = stmt.executeQuery();
		
			
			if (results.next()) 
			{
				results.first();
				results.updateString("Date Of Birth", DOB);
	
			
				results.updateRow();
			} 
			else 
			{
				System.out.println("Record does not exist");
			}

			stmt.close();
			conn.close();			
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
	
		}
			
		
	}
	
	public static void updateUsername(String currentUserID, String username)  {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT * FROM Accounts WHERE UserID = ?";
			System.out.println("Query: " + query);
		
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
	
			System.out.println("prepared: " + stmt);
		
			ResultSet results = stmt.executeQuery();
		
			
			if (results.next()) 
			{
				results.first();
				results.updateString("UserName", username);
	
			
				results.updateRow();
			} 
			else 
			{
				System.out.println("Record does not exist");
			}

			stmt.close();
			conn.close();			
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
	
		}
			
		
	}

	public static void updateEmail(String currentUserID, String email)  {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT * FROM Accounts WHERE UserID = ?";
			System.out.println("Query: " + query);
		
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
	
			System.out.println("prepared: " + stmt);
		
			ResultSet results = stmt.executeQuery();
		
			
			if (results.next()) 
			{
				results.first();
				results.updateString("Email", email);
	
			
				results.updateRow();
			} 
			else 
			{
				System.out.println("Record does not exist");
			}

			stmt.close();
			conn.close();			
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
	
		}
			
		
	}
	
	public static void updatePassword(String currentUserID, String password)  {
		
		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

			String query = "UPDATE Accounts Set Password = AES_ENCRYPT(?,?) WHERE UserID = ?";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
			stmt.setString(1, password);
			stmt.setString(2, "encrypt");
			stmt.setString(3, currentUserID);

	
			System.out.println("prepared: " + stmt);
	
			stmt.executeUpdate();

			stmt.close();
			conn.close();

			stmt.close();
			conn.close();			
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
	
		}
			
		
	}
	
	public static void deleteAccount(String currentUserID ) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");		
		
			String query = "DELETE FROM accounts WHERE UserID = ? ";		
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
			
			System.out.println("prepared: " + stmt);
			
			stmt.executeUpdate();	
	

			stmt.close();										
			conn.close();											
			
			
		}
		catch (ClassNotFoundException cnf) 
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());

		} 
		catch (SQLException sqe) 
		{
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
		}
			
		
	}
	
}
