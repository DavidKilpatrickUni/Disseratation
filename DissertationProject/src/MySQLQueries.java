import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class MySQLQueries {

	
	public static ResultSet attemptLogin(String username, String password) throws CustomException {
		
		String decrypt = MyEncryption.getEncryptionKey();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

			
			String query = "SELECT * FROM Accounts WHERE UserName = ? AND password = AES_ENCRYPT(?,?)";
			System.out.println("Query: " + query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
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
			throw new CustomException("Database Connection/SQL Query Issue", "sql");	
		}
		
		return null;	
	}
	
	
	public static void createAccount(String firstname, String surname, String DOB, String identity, String username, String password, String email) throws CustomException {
		
		String encrypt = MyEncryption.getEncryptionKey();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			
			String query = "INSERT INTO accounts VALUES (NULL , ? , ? , ? , ? , ? , AES_ENCRYPT(?,?) , ? , null, null, null, null, null, null )";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, firstname);
			stmt.setString(2, surname);
			stmt.setString(3, DOB);
			stmt.setString(4, identity);
			stmt.setString(5, username);
			stmt.setString(6, password);
			stmt.setString(7, encrypt);
			stmt.setString(8, email);
			
			System.out.println("prepared: " + stmt);
			
			stmt.executeUpdate();															
		
			stmt.close();										
			conn.close();									
			
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
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
				
		}
	}
	
	
	
	
	public static ResultSet checkIfSongExists(String title, String artist) throws CustomException {

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");				
			
			
			String query = "SELECT * FROM Songs WHERE Title = ? AND Artist = ?";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, artist);

			System.out.println("prepared: " + stmt);
			
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
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
	
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
		
		}
		
		return null;	
	}
	
	
	
	public static void suggestSong(String title, String artist, String genre, String songLength, String released, String album, String songInfo, int rating) throws CustomException {
		
		String uploaded = Helper.changeLocalDateFormat(LocalDate.now());
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
	
			String query = "INSERT INTO songs VALUES (NULL , ? , ? , ? , ? , ? , ? , ? , ? , FORMAT (?,2), 1 )";		
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, artist);
			stmt.setString(3, genre);
			stmt.setString(4, songLength);
			stmt.setString(5, released);
			stmt.setString(6, album);
			stmt.setString(7, songInfo);
			stmt.setString(8, uploaded);
			stmt.setInt(9, rating);

			
			System.out.println("prepared: " + stmt);
			
			stmt.executeUpdate();
			
			statement.close();										
			conn.close();											
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			
		
		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
		
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
		}
	}
	
	public static ResultSet getSongIDOfSuggestSong() throws CustomException {
		
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

			
			String query = "SELECT SongID FROM Songs ";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
			System.out.println("prepared: " + stmt);
			
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
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
	
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");	
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
		
		}
		return null;
	}
	
	
	public static ResultSet getAccountsDetail(String currentUserID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
															
			String query = "SELECT * FROM Accounts WHERE USERID = ?";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentUserID);

			System.out.println("prepared: " + stmt);
			
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
	
	public static ResultSet getAccountsDetailDecrypted(String currentUserID) {
		
		String decrypt = MyEncryption.getEncryptionKey();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
															
			String query = "SELECT *, AES_DECRYPT(Password,?) FROM Accounts WHERE USERID = ?";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setString(1, decrypt);
			stmt.setString(2, currentUserID);
			
			System.out.println("prepared: " + stmt);
			
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
	
	
	public static void updateGenre(String currentUserID, String genre1, String genre2, String genre3) {
		
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
				results.updateString("Genre One", genre1);
				results.updateString("Genre Two", genre2);
				results.updateString("Genre Three", genre3);
			
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
	

		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
	
		}
			
		
	}
	
	public static void updateArtist(String currentUserID, String artist1, String artist2, String artist3) {
		
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
				results.updateString("Artist One", artist1);
				results.updateString("Artist Two", artist2);
				results.updateString("Artist Three", artist3);
			
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
	

		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
	
		}
			
		
	}
	
	public static void updateUsername(String currentUserID, String username) throws CustomException {
		
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
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
	
		}
			
		
	}
	
	public static void updateFirstname(String currentUserID, String firstname) throws CustomException {
		
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
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
	
		}
			
		
	}
	
	
	
	public static void updateSurname(String currentUserID, String surname) throws CustomException {
		
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
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
	
		}
			
	}
	
	public static void updateIdentity(String currentUserID, String identity) throws CustomException {
	
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
		
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");	
	
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");

			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}

		}
		
	}
	
	public static void updatePassword(String currentUserID, String password) throws CustomException {
	
		String decrypt = MyEncryption.getEncryptionKey();
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

			String query = "UPDATE Accounts Set Password = AES_ENCRYPT(?,?) WHERE UserID = ?";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
			stmt.setString(1, password);
			stmt.setString(2, decrypt);
			stmt.setString(3, currentUserID);

	
			System.out.println("prepared: " + stmt);
	
			stmt.executeUpdate();

			stmt.close();
			conn.close();											
		
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());


		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
		
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
	
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}

		}
		
	}



	public static void createPlaylist( String userID, String songID, String playlistTitle) throws CustomException {
	
	
		String encrypt = MyEncryption.getEncryptionKey();
	
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				
			String query = "INSERT INTO playlists VALUES (NULL , ? , ? , ?, 0 )";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, userID);
			stmt.setString(2, songID);
			stmt.setString(3, playlistTitle);
	

			System.out.println("prepared: " + stmt);

			stmt.executeUpdate();												
	
			stmt.close();										
			conn.close();										
		
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

	
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");

			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}

		}
	}
	
	public static ResultSet search(Object search, Object criteria, Object sort, String sortType, int offset, int count) {
		
		
		if(search == null || search.equals(""))
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
				//String query = "SELECT * FROM songs ORDER BY " + criteria + " " + sortType + ", " + sort + " " + sortType + " LIMIT " + offset + "," + count +";";		
				

				
				
				String query = "SELECT * FROM songs ORDER BY " + criteria + " " + sortType + ", "+ sort + " " + sortType + " LIMIT ? , ?";
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
				Statement statement = conn.createStatement();
				
				String query = "SELECT * FROM songs WHERE " + criteria + "='" + search + "'" + "ORDER BY " + sort + " " + sortType  + " LIMIT " + offset + "," + count +";";	
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
	
	}
	
	public static ResultSet populateComboBox(Object comboBoxCriteria, Object comboBoxSort) {
	
		String sortType = "ASC";
	
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			System.out.println("SELECT * FROM songs GROUP BY "+ comboBoxCriteria.toString() + " ORDER BY " + comboBoxSort.toString() + " " + sortType + ", " + comboBoxCriteria.toString() +  " " + sortType);	
			String query = "SELECT * FROM songs GROUP BY " + comboBoxCriteria.toString() + " ORDER BY " + comboBoxSort.toString() + " " + sortType + ", " + comboBoxCriteria.toString() + " " + sortType;		

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
	
	public static ResultSet loadPlaylists(String userID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
			String query = "SELECT playlists.* , accounts.* FROM playlists INNER JOIN accounts ON playlists.userID = accounts.userID WHERE playlists.userID = ? GROUP BY PlaylistTitle";
			System.out.println("Query: " + query);
				
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setString(1, userID);
	
			
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
	
	public static ResultSet loadAPlaylist(String currentPlaylistTitle) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
		
			String query = "SELECT playlists.* , songs.* from playlists inner join songs on playlists.songID = songs.songID where playlists.playlistTitle = ? ORDER BY Ranking ASC";
		
			System.out.println("Query: " + query);
				
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentPlaylistTitle);
	
			
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
	
	
	public static void DeletePlaylist(String currentUserID, String currentPlaylistTitle ) {
		
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
			
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());

		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
		}
			
		
	}
	
	public static ResultSet getCurrentPlaylistTitle(String currentPlaylistID){
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
		
			String query = "SELECT * FROM  playlists WHERE playListID = ?";
			System.out.println("Query: " + query);

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentPlaylistID);
		
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
	
	public static void removeFromList(String currentUserID, String currentPlaylistID ) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			
	
			String query = "DELETE FROM playlists WHERE UserID = ? AND PlaylistID = ?";		
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, currentUserID);
			stmt.setString(2, currentPlaylistID);
			
			System.out.println("prepared: " + stmt);
			
			stmt.executeUpdate();
	
			stmt.close();										
			conn.close();											
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());


		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());

		}
			
		
	}
	
	public static void updatePlaylistTitle(String currentUserID, String currentPlaylistTitle, String newPlaylistTitle) {
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");																	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
		String query = "SELECT * FROM playlists WHERE UserID = ? AND PlaylistTitle = ?";		
		System.out.println("Query: " + query);
		
		PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt.setString(1, currentUserID);
		stmt.setString(2, currentPlaylistTitle);
		
		System.out.println("prepared: " + stmt);
		
	
		ResultSet results = stmt.executeQuery();	
		
			while (results.next()) 
			{
				results.updateString("PlayListTitle", newPlaylistTitle);
	
				results.updateRow();
			} 
		

		stmt.close();										// Close statement connection to database
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
	
	public static ResultSet playlistTitleExists(String currentUserID, String potentialPlaylistTitle) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

			String query = "SELECT * FROM  playlists WHERE userID = ? AND playlistTitle = ? ";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentUserID);
			stmt.setString(2, potentialPlaylistTitle);
		
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
	
	
	public static void swapRanking(String playlistID1, String playlistID2 ) {
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");																	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
	
		String query = "SELECT * FROM playlists WHERE PlaylistID = ?";	
		System.out.println("Query: " + query);
		
		PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt.setString(1, playlistID1);

		System.out.println("prepared: " + stmt);
		
		ResultSet results = stmt.executeQuery();
		
	
		while (results.next() ) 
			{

			int currentRanking = results.getInt("Ranking");
			System.out.println("Old rank: " + currentRanking) ;	
			
			
			int newRanking = (currentRanking -1);
			
			System.out.println("New rank: " + newRanking) ;	
			
			
			
			results.updateInt("Ranking", newRanking);
			results.updateRow();
			} 
		

		
		String query2 = "SELECT * FROM playlists WHERE PlaylistID = ?";	
		System.out.println("Query: " + query2);
	
		PreparedStatement stmt2 = conn.prepareStatement(query2,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt2.setString(1, playlistID2);

		System.out.println("prepared: " + stmt2);
		
		
		ResultSet results2 = stmt2.executeQuery();	
			
		while (results2.next() ) 
			{

			int currentRanking2 = results2.getInt("Ranking");
			System.out.println("Old rank2: " + currentRanking2) ;	
			
			int newRanking2 = (currentRanking2 +1);
			System.out.println("New rank2: " + newRanking2) ;	
			
			results2.updateInt("Ranking", newRanking2);
			results2.updateRow();
			} 


			stmt.close();										
			conn.close();											
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());

		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
		}
		
	}
	
}
