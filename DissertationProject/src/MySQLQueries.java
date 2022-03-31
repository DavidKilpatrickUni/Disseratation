import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Utility Layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * MySQLQueries
 * </p>
 * 
 * <p>
 * Class created to house all the mySQL queries used throughout the Elenco program. 
 * <br> Having queries on every application layer meant code was being rewritten, cluttering up the code and making the size of the program code excessively larger.
 * <br> This method removes duplicate and redundant code and makes all the sql queries accessible at one location.
 * <br> All the queries that are suitable or require prepared statements has so.
 * <br> Many mySQL reserved words have been used with some of the queries being very completed.  
 * </p>
 * 

 */
public class MySQLQueries {

	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the accounts table equal to the user parameters.
  	 * <br> Used during a login attempt.
	 * </p>
	 * <p>
	 * Parameter 1 is the user input of username. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the user input of password. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param username			<code>String</code> object to store username data.
	 * @param password			<code>String</code> object to store password data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
	public static ResultSet attemptLogin(String username, String password) throws CustomException {
		
		String decrypt = MyEncryption.getEncryptionKey();
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

		
			String query = "SELECT * FROM Accounts WHERE BINARY UserName = ? AND password = AES_ENCRYPT(?,?)";
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to insert values into the account Table.
  	 * <br> Used during a successful registration attempt.
	 * </p>
	 * <p>
	 * Parameter 1 is the user input of firstname. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the user input of surname. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the user input of date of birth. A <code>String</code> object is used to store the data.
	 * <br>Parameter 4 is the user input of identity. A <code>String</code> object is used to store the data.
	 * <br>Parameter 5 is the user input of username. A <code>String</code> object is used to store the data.
	 * <br>Parameter 6 is the user input of password. A <code>String</code> object is used to store the data.
	 * <br>Parameter 7 is the user input of email. A <code>String</code> object is used to store the data.
	 *      
	 * </p>
	 * 
	 * @param username			<code>String</code> object to store username data.
	 * @param password			<code>String</code> object to store password data.
	 * @param DOB				<code>String</code> object to store date of birth data.
	 * @param identity			<code>String</code> object to store identity data.
	 * @param username			<code>String</code> object to store username data.
	 * @param password			<code>String</code> object to store password data.
	 * @param email				<code>String</code> object to store email data.
	 *
	 * @see MySQLQueries
	 * @see String
	 */
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
	
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the song table equal to the user parameters.
  	 * <br> Used to determine if song already uploaded to Elenco.
	 * </p>
	 * <p>
	 * Parameter 1 is the user input of song title. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the user input of song artist. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param title				<code>String</code> object to store song title data.
	 * @param artist			<code>String</code> object to store song artist data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to insert values into the songs Table.
  	 * <br> Used during a suggest song attempt.
	 * </p>
	 * <p>
	 * Parameter 1 is the user input of title. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the user input of artist. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the user input of genre. A <code>String</code> object is used to store the data.
	 * <br>Parameter 4 is the user input of song length. A <code>String</code> object is used to store the data.
	 * <br>Parameter 5 is the user input of release date. A <code>String</code> object is used to store the data.
	 * <br>Parameter 6 is the user input of album. A <code>String</code> object is used to store the data.
	 * <br>Parameter 7 is the user input of song Info. A <code>String</code> object is used to store the data.
	 * <br>Parameter 8 is the user input of rating. A <code>Integer</code> object is used to store the data.
	 *      
	 * </p>
	 * 
	 * @param title					<code>String</code> object to store song title data.
	 * @param artist				<code>String</code> object to store song artist data.
	 * @param genre					<code>String</code> object to store song genre data.
	 * @param songLength			<code>String</code> object to store song length data.
	 * @param released				<code>String</code> object to store release date data.
	 * @param album					<code>String</code> object to store album data.
	 * @param songInfo				<code>String</code> object to store song information data.
	 * @param rating				<code>Integer</code> object to store rating data.
	 *
	 *
	 * @see MySQLQueries
	 * @see Integer
	 * @see String
	 */
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the song table.
  	 * <br> Used to determine what the songID of a newly created database entry is - Use .last() to get last row of ResultSet.
  	 * <br> Required after <code>suggestSong</code> method.
	 * </p>
	 *
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the accounts table equal to the user parameters.
  	 * <br> Used to get account details of parameterised userID.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the accounts table equal to the user parameters.
  	 * <br> Used to get account details of parameterised userID when wanting password String decrypted.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update all database entries from the accounts table equal to the user parameter.
  	 * <br> Used to update favourite genres for given userID to specified parameters.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the user input for genre slot 1. A <code>String</code> object is used to store the data.
	 * <br> Parameter 3 is the user input for genre slot 2. A <code>String</code> object is used to store the data.
	 * <br> Parameter 4 is the user input for genre slot 3. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 * @param genre1					<code>String</code> object to store genre slot 1 data.
	 * @param genre2					<code>String</code> object to store genre slot 2 data.
	 * @param genre3					<code>String</code> object to store genre slot 3 data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update all database entries from the accounts table equal to the user parameter.
  	 * <br> Used to update favourite artist for given userID to specified parameters.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the user input for artist slot 1. A <code>String</code> object is used to store the data.
	 * <br> Parameter 3 is the user input for artist slot 2. A <code>String</code> object is used to store the data.
	 * <br> Parameter 4 is the user input for artist slot 3. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 * @param artist1					<code>String</code> object to store artist slot 1 data.
	 * @param artist2					<code>String</code> object to store artist slot 2 data.
	 * @param artist3					<code>String</code> object to store artist slot 3 data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update the single database entry from the accounts table equal to the user parameter.
  	 * <br> Used to update username for given userID to specified parameters.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the user input for desired username. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 * @param username					<code>String</code> object to store desired username data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update the single database entry from the accounts table equal to the user parameter.
  	 * <br> Used to update first name for given userID to specified parameters.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the user input for desired first name. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 * @param firstname					<code>String</code> object to store desired firstname data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update the single database entry from the accounts table equal to the user parameter.
  	 * <br> Used to update surname for given userID to specified parameters.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the user input for desired surname. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 * @param surname					<code>String</code> object to store desired surname data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update the single database entry from the accounts table equal to the user parameter.
  	 * <br> Used to update identity for given userID to specified parameters.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the user input for desired identity. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 * @param identity					<code>String</code> object to store desired identity data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update the single database entry from the accounts table equal to the user parameter.
  	 * <br> Used to update password for given userID to specified parameters using encryption.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the user input for desired password. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID				<code>String</code> object to store userID data.
	 * @param password					<code>String</code> object to store desired password data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
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


	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to insert values into the playlist Table.
  	 * <br> Used during creating a playlist or adding a song to playlist.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the songID of song. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the user input of playlist Title or current playlist title. A <code>String</code> object is used to store the data.
	 *      
	 * </p>
	 * 
	 * @param userID					<code>String</code> object to store userID data.
	 * @param songID					<code>String</code> object to store songID data.
	 * @param playlistTitle				<code>String</code> object to store playlist Title data.
	 *
	 * @see MySQLQueries
	 * @see String
	 */
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the songs table equal to the user parameters.
  	 * <br> Used during a custom search - One path for with valid search parameter and one without valid search parameter.
	 * </p>
	 * <p>
	 * Parameter 1 is the user selected search. A <code>Object</code> object is used to store the data.
	 * <br>Parameter 2 is the user selected criteria. A <code>Object</code> object is used to store the data.
	 * <br>Parameter 3 is the user selected sort. A <code>Object</code> object is used to store the data.
	 * <br>Parameter 4 is direction to order qeury - Asc/Desc. A <code>Object</code> object is used to store the data.
	 * <br>Parameter 5 is the row start point of query. A <code>Integer</code> object is used to store the data.
	 * <br>Parameter 6 is the amount of database rows to return. A <code>Integer</code> object is used to store the data.
	 * </p>
	 * 
	 * @param search			<code>Object</code> object to store search data.
	 * @param criteria			<code>Object</code> object to store criteria data.
	 * @param sort				<code>Object</code> object to store sort data.
	 * @param sortType			<code>Object</code> object to store sortType data.
	 * @param offset			<code>Integer</code> object to store offset data.
	 * @param count				<code>Integer</code> object to store row count data.
	 *
	 * @see MySQLQueries
	 * @see Integer
	 * @see Object
	 * @see ResultSet
	 */
	public static ResultSet search(Object search, Object criteria, Object sort, String sortType, int offset, int count) {
		
		
		if(search == null || search.equals(""))						// Check for valid search parameter
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
				//String query = "SELECT * FROM songs ORDER BY " + criteria + " " + sortType + ", "+ sort + " " + sortType + " LIMIT ? , ?";
				String query = "SELECT * FROM songs ORDER BY " + sort + " " + sortType + ", "+ criteria + " ASC  LIMIT ? , ?";
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
	
				
				String query = "SELECT * FROM songs WHERE " + criteria + "= ? ORDER BY " + sort + " " + sortType  + " LIMIT ?, ?;";	

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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the songs table equal to the user parameters.
  	 * <br> Used to populate search comboBox with data from the database - populate with titles/genres/artists
	 * </p>
	 * <p>
	 * Parameter 1 is the user selected criteria. A <code>Object</code> object is used to store the data.
	 * <br>Parameter 2 is the user selected sort. A <code>Object</code> object is used to store the data.
	 * </p>
	 * 
	 * @param comboBoxCriteria			<code>Object</code> object to store criteria data.
	 * @param comboBoxSort				<code>Object</code> object to store sort data.

	 *
	 * @see MySQLQueries
	 * @see Object
	 * @see ResultSet
	 */
	public static ResultSet populateComboBox(Object comboBoxCriteria, Object comboBoxSort) {
	
		String sortType = "ASC";
	
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			
			//String query = "SELECT * FROM songs GROUP BY " + comboBoxCriteria.toString() + " ORDER BY " + comboBoxSort.toString() + " " + sortType + ", " + comboBoxCriteria.toString() + " " + sortType;		
			String query = "SELECT * FROM songs GROUP BY " + comboBoxCriteria.toString() + " ORDER BY " + comboBoxCriteria.toString() + " " + sortType;		

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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the playlist table equal to the user parameters.
  	 * <br> Used to populate GUI with all playlists owned by current userID. Highlighted when loading content for <code>MyplaylistsScreen</code>
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param userID			<code>String</code> object to store userID data.

	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the playlist table equal to the user parameters.
  	 * <br> Used to populate GUI with a playlist owned by current userID with specified playlist Title. Highlighted when loading content for <code>ManagePlaylistScreen</code>
	 * </p>
	 * <p>
	 * Parameter 1 is the current currentPlaylistTitle. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the current userID. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentPlaylistTitle			<code>String</code> object to store playlist title data.
	 * @param userID						<code>String</code> object to store userID data.
	 *
	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
	public static ResultSet loadAPlaylist(String currentPlaylistTitle, String currentUserID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
		
			String query = "SELECT playlists.* , songs.* FROM playlists INNER JOIN songs on playlists.songID = songs.songID WHERE playlists.playlistTitle = ? AND playlists.userID = ? ORDER BY Ranking ASC";
		
			System.out.println("Query: " + query);
				
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentPlaylistTitle);
			stmt.setString(2, currentUserID);
	
			
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to delete all database entries from the playlist table equal to the user parameters.
	 * </p>
	 * <p>
	 * Parameter 1 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the current currentPlaylistTitle. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param userID						<code>String</code> object to store userID data.
	 * @param currentPlaylistTitle			<code>String</code> object to store playlist title data.
	 *
	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the playlist table equal to the user parameters.
  	 * <br> Helpful when playlistID is known and want the playlist title
	 * </p>
	 * <p>
	 * Parameter 1 is the current currentPlaylistID. A <code>String</code> object is used to store the data.

	 * </p>
	 * 
	 * @param currentPlaylistID			<code>String</code> object to store playlistID data.
	 *
	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to delete a database entries from the playlist table equal to the user parameters.
  	 * <br> Removing a song from current playlist.
	 * </p>
	 * <p>
	 * Parameter 1 is the current current UserID. A <code>String</code> object is used to store the data.
	 * Parameter 2 is the current current PlaylistID. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID					<code>String</code> object to store userID data.
	 * @param currentPlaylistID				<code>String</code> object to store playlistID data.
	 *
	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update all database entries from the playlist table equal to the user parameters.
  	 * <br> Used to rename a playlist.
	 * </p>
	 * <p>
	 * Parameter 1 is the current PlaylistID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the current current Playlist Title. A <code>String</code> object is used to store the data.
	 * <br> Parameter 3 is the desired PlaylisTitle. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID					<code>String</code> object to store userID data.
	 * @param currentPlaylistTitle			<code>String</code> object to store current playlist title data.
	 * @param newPlaylistTitle				<code>String</code> object to store desired playlist title data.
	 *
	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
		

		stmt.close();									
		conn.close();										
			
		} 
		catch (ClassNotFoundException cnf) 
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);

		} 
		catch (SQLException sqe) 
		{
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
			System.exit(-1);
		}
	}
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the playlist table equal to the user parameters.
  	 * <br> Used to see if the current userID already has a playlist of desired title - All playlists for a userID must be unique.
	 * </p>
	 * <p>
	 * Parameter 1 is the current UserID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the desired playlist title. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID						<code>String</code> object to store UserID data.
	 * @param potentialPlaylistTitle			<code>String</code> object to store desired playlist title data.
	 *
	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the playlist table equal to the user parameters.
  	 * <br> Used to swap the ranking of songs on a playlist. Basically swap two different playlistIDs ranking numbers - a songs position on the ranking list.
	 * </p>
	 * <p>
	 * Parameter 1 is the playlistID of first song on playlist. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the playlistID of second song on playlist. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param playlistID1						<code>String</code> object to store playlistID data.
	 * @param playlistID2						<code>String</code> object to store playlistID data.
	 *
	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the song table equal to the user parameters.
     * <br> Can be used for finding out song details, a specific thing or as a method to load content on to screen.
	 * </p>
	 * <p>
	 * Parameter 1 is the songID of desired song. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param songID						<code>String</code> object to store desired songID data.
	 *
	 * @see String
	 * @see MySQLQueries
	 * @see ResultSet
	 */
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the comments table equal to the user parameters.
  	 * <br> Used to populate a view song screen with all the comments about the song, showing user who commented and their comment.
	 * </p>
	 * <p>
	 * Parameter 1 is the user selected search. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the row start point of query. A <code>Integer</code> object is used to store the data.
	 * <br>Parameter 3 is the amount of database rows to return. A <code>Integer</code> object is used to store the data.
	 * </p>
	 * 
	 * @param songID			<code>String</code> object to store songID data.
	 * @param offset			<code>Integer</code> object to store offset data.
	 * @param count				<code>Integer</code> object to store row count data.
	 *
	 * @see MySQLQueries
	 * @see Integer
	 * @see String
	 * @see ResultSet
	 */
	public static ResultSet getComments(String songID, int offset, int count) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
			String query = "SELECT songs.* , comments.*, accounts.* FROM comments INNER JOIN accounts on accounts.UserID = comments.UserID INNER JOIN songs on songs.SongID = comments.SongID where songs.songID = ? LIMIT ? , ? ;";
			System.out.println("Query: " + query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, songID);
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to insert values into the comment Table.
  	 * <br> Used when uploading a comment about a song.
	 * </p>
	 * <p>
	 * Parameter 1 is the current songID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the current userID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the user input of comment. A <code>String</code> object is used to store the data.  
	 * </p>
	 * 
	 * @param currentSongID			<code>String</code> object to store songID data.
	 * @param currentUserID			<code>String</code> object to store userID data.
	 * @param comment				<code>String</code> object to store user comment data.
	 *
	 * @see MySQLQueries
	 * @see String
	 */
	public static void addComment(String currentSongID, String currentUserID, String comment) {
		
		String posted = Helper.changeLocalDateFormat(LocalDate.now());

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	

			String query = "INSERT INTO comments VALUES (NULL , ? , ? , ? , ?)";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentSongID);
			stmt.setString(2, currentUserID);
			stmt.setString(3, comment);
			stmt.setString(4, posted);
	

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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return a database entry from the ratings table equal to the user parameters.
  	 * <br> Used to populate a view song screen with the current users rating for the song.
	 * </p>
	 * <p>
	 * Parameter 1 is the current songID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the current userID. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentSongID			<code>String</code> object to store songID data.
	 * @param currentUserID			<code>String</code> object to store userID data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
	public static ResultSet myRating(String currentSongID, String currentUserID) {
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
			String query = "SELECT * FROM ratings WHERE SongID = ? AND UserID = ?";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentSongID);
			stmt.setString(2, currentUserID);
		

		
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
	

	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to insert values into the ratings Table.
  	 * <br> Used when initially suggesting a song or when a user sets a song rating for first time.
	 * </p>
	 * <p>
	 * Parameter 1 is the current songID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the current userID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the user input of rating. A <code>String</code> object is used to store the data.  
	 * </p>
	 * 
	 * @param currentSongID			<code>String</code> object to store songID data.
	 * @param currentUserID			<code>String</code> object to store userID data.
	 * @param rating				<code>String</code> object to store user rating data.
	 *
	 * @see MySQLQueries
	 * @see String
	 */
	public static void createRating(String currentSongID, String currentUserID, String rating) {
	

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "INSERT INTO ratings VALUES (NULL , ? , ? , ? )";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentSongID);
			stmt.setString(2, currentUserID);
			stmt.setString(3, rating);
		

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

	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update a database entry from the ratings table equal to the user parameters.
  	 * <br> Used to update a users rating of a song.
	 * </p>
	 * <p>
	 * Parameter 1 is the current songID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the current userID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the user input of rating. A <code>String</code> object is used to store the data.  
	 * </p>
	 * 
	 * @param currentSongID			<code>String</code> object to store songID data.
	 * @param currentUserID			<code>String</code> object to store userID data.
	 * @param rating				<code>String</code> object to store user rating data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
	public static void updateRating(String currentSongID, String currentUserID, String rating) {
		

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
			String query = "UPDATE ratings SET Rating = ? WHERE songID = ? AND userID = ?";	
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
			stmt.setString(1, rating);
			stmt.setString(2, currentSongID);
			stmt.setString(3, currentUserID);

	
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the ratings table equal to the user parameters.
  	 * <br> Used to gather all ratings so variable ( total rows) can be used in math equation - so a total average rating can be established.
	 * </p>
	 * <p>
	 * Parameter 1 is the current songID. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentSongID			<code>String</code> object to store songID data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
	public static ResultSet getAllRatings(String currentSongID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT * FROM ratings WHERE SongID = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentSongID);
	
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to update a database entry from the songs table equal to the user parameters.
  	 * <br> Used to set overall rating and total reviews to values found through math equations.
	 * </p>
	 * <p>
	 * Parameter 1 is the current songID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the new overall rating. A <code>Double</code> object is used to store the data - This is because dividing a number can result in decimal places.
	 * <br> Parameter 3 is the new total reviews count. A <code>Integer</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentSongID			<code>String</code> object to store songID data.
	 * @param overallRating			<code>String</code> object to store new overall ratings data.
	 * @param totalReviews			<code>String</code> object to store new total reviews data.
	 *
	 * @see MySQLQueries
	 * @see String
	 * @see Integer
	 * @see Double
	 * @see ResultSet
	 */
	public static void updateTotals(String currentSongID, double overallRating, int totalReviews) {

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "UPDATE songs SET OverallRating = FORMAT(?,2) , TotalReviews = ? WHERE songID = ?";	
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
			stmt.setDouble(1, overallRating);
			stmt.setInt(2, totalReviews);
			stmt.setString(3, currentSongID);

	
			System.out.println("prepared: " + stmt);
	
			stmt.executeUpdate();
		
			stmt.close();										
			conn.close();
			
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the accounts or playlists table .
  	 * <br> Used to populate search comboBox with data from the database - populate with usernames
	 * </p>
	 *
	 * @see MySQLQueries
	 * @see ResultSet
	 */
	public static ResultSet popoulateWithUserName() {

		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			System.out.println("SELECT accounts.* , playlists.* FROM accounts INNER JOIN playlists on accounts.UserID = playlists.UserID GROUP BY accounts.UserName");	
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the accounts or playlists table.
  	 * <br> Used to populate search comboBox with data from the database - populate with playlist titles.
	 * </p>
	 *
	 * @see MySQLQueries
	 * @see ResultSet
	 */
	public static ResultSet popoulateWithPlaylistTitle() {

		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			System.out.println("SELECT accounts.* , playlists.* FROM accounts INNER JOIN playlists on accounts.UserID = playlists.UserID GROUP BY playlists.PlaylistTitle");	
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the playlists and accounts table equal to the user parameters.
  	 * <br> Used during a custom search - Multiple paths dependant on parameters that were passed.
	 * </p>
	 * <p>
	 * Parameter 1 is the user selected search. A <code>Object</code> object is used to store the data.
	 * <br>Parameter 2 is the user selected criteria. A <code>Object</code> object is used to store the data.
	 * <br>Parameter 3 is the row start point of query. A <code>Integer</code> object is used to store the data.
	 * <br>Parameter 4 is the amount of database rows to return. A <code>Integer</code> object is used to store the data.
	 * </p>
	 * 
	 * @param search			<code>Object</code> object to store search data.
	 * @param criteria			<code>Object</code> object to store criteria data.
	 * @param offset			<code>Integer</code> object to store offset data.
	 * @param count				<code>Integer</code> object to store row count data.
	 *
	 * @see MySQLQueries
	 * @see Integer
	 * @see Object
	 * @see ResultSet
	 */
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the accounts table equal to user parameter.
  	 * <br> Used to to get the username of the currently viewed playlist using creator of the playlist userID.
	 * </p>
	 * <p>
	 * Parameter 1 is the userID of creator of the playlist. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param IDOfUser			<code>String</code> object to store creator userID data.
	 * 
	 * @see MySQLQueries
	 * @see ResultSet
	 */
	
	public static ResultSet getCurrentUsername(String IDOfUser)  {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT UserName FROM accounts WHERE UserID = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, IDOfUser);
	
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the playlist table equal to user parameter.
  	 * <br> Used to determine if song is on the current playlist or not.
	 * </p>
	 * <p>
	 * Parameter 1 is the songID of song potentially being added to playlist. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the current userID. A <code>String</code> object is used to store the data.
	 * <br> Parameter 3 is the playlist title. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param checkSongID			<code>String</code> object to store potential songID data.
	 * @param currentUserID			<code>String</code> object to store current userID data.
	 * @param playlistTitle			<code>String</code> object to store playlist title data.
	 * 
	 * @see MySQLQueries
	 * @see ResultSet
	 */
	public static ResultSet songOnPlaylist(String checkSongID, String currentUserID, String playlistTitle) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
		
			String query = "SELECT * FROM playlists where songID = ? AND userID = ? AND playlistTitle = ?";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, checkSongID);
			stmt.setString(2, currentUserID);
			stmt.setString(3, playlistTitle);
	
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
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to insert values into the playlist Table.
  	 * <br> Adds a song to a playlist.
	 * </p>
	 * <p>
	 * Parameter 1 is the current UserID. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the songID of song being added. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the playlist title the song is being added to. A <code>String</code> object is used to store the data.
	 * <br>Parameter 4 is the ranking value of song on playlist determined by GUI button row number. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID						<code>String</code> object to store userID data.
	 * @param selectedSongID					<code>String</code> object to store songID data.
	 * @param currentPlayListTitle				<code>String</code> object to store playList Title data.
	 * @param ranking							<code>Integer</code> object to store ranking data.
	
	 * @see MySQLQueries
	 * @see String
	 * @see Integer
	 */
	public static void addSong(String currentUserID, String selectedSongID, String currentPlayListTitle, int ranking) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
			String query = "INSERT INTO playlists VALUES (NULL , ? , ? , ? , ?)";
			System.out.println("Query: " + query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentUserID);
			stmt.setString(2, selectedSongID);
			stmt.setString(3, currentPlayListTitle);
			stmt.setInt(4, ranking);
	
			
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
	
	
	/**
	 * <h1> Method </h1>
	 * 
	 * <p>
     * Establishes connection to the correct local host database using the JDBC driver.
     * <br> With a connection created, a new query can be sent to the database.
     * <br> This query is designed to return all database entries from the playlist table equal to user parameter.
  	 * <br> Used to determine playlistID , ideal when a new playlist has been created and we need the playlistID to populate the GUI correctly.
	 * </p>
	 * <p>
	 * Parameter 1 is the userID of playlist. A <code>String</code> object is used to store the data.
	 * <br> Parameter 2 is the title of playlist. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentUserID					<code>String</code> object to store userID data.
	 * @param currentPlaylistTitle			<code>String</code> object to store current playlist title data.
	 * 
	 * @see MySQLQueries
	 * @see String
	 * @see ResultSet
	 */
	public static ResultSet getPlaylistID(String currentUserID, String currentPlaylistTitle) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
	
			String query = "SELECT * FROM playlists WHERE userID = ? AND PlaylistTitle = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, currentUserID);
			stmt.setString(2, currentPlaylistTitle);
			
	
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
	

