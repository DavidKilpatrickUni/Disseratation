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
			//Statement statement = conn.createStatement();				
			
			//String query = "SELECT * FROM Accounts where UserName = '" + userName + "' AND Password = '" + password + "'";
			
			String query = "SELECT * FROM Accounts WHERE UserName = ? AND password = AES_ENCRYPT(?,?)";
			//System.out.println(query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, decrypt);
			
			System.out.println("prepared: " + stmt);
			
			ResultSet results = stmt.executeQuery();															
			//System.out.println("this here " + results);
			
			
			
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
				//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
			}
			else 
			{
				throw new CustomException("Database Connection/SQL Query Issue", "sql");
			}
		}
		
		return null;	
	}
	
	public static void createAccount(String firstname, String surname, String DOB, String identity, String username, String password, String email) throws CustomException {
		
		
		String encrypt = MyEncryption.getEncryptionKey();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			//Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			//String query = "Insert Into accounts VALUES (NULL ,'" + firstname +  "','" + surname + "','" + DOB + "','" + identity + "','" + username + "','" + password + "','" + email + "', null, null, null, null, null, null )";		
		
			String query = "Insert Into accounts VALUES (NULL , ? , ? , ? , ? , ? , AES_ENCRYPT(?,?) , ? , null, null, null, null, null, null )";
			
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
			
			//ResultSet results = stmt.executeQuery();
			
			
			stmt.executeUpdate();															// Return the results of query to this variable. ResultSet is special variable type for databases
		
		
			stmt.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
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
				//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
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
			//Statement statement = conn.createStatement();				
			
			//String query = "SELECT * FROM Accounts where UserName = '" + userName + "' AND Password = '" + password + "'";
			
			String query = "SELECT * FROM Songs WHERE Title = ? AND Artist = ?";
			//System.out.println(query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, artist);
			
			
			System.out.println("prepared: " + stmt);
			
			ResultSet results = stmt.executeQuery();															
			//System.out.println("this here " + results);
			
			
		
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
			//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
	
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
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
		//uploaded = dateForDatabase(uploaded);
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into songs VALUES (NULL ,'" + title +  "','" + artist + "','" + genre + "','" + songLength + "','" + released + "','" + album + "','" + songInfo + "','" + uploaded + "', FORMAT ('" + rating + "',2),'" + 1 + "')";		
		
			
			
			statement.executeUpdate(query);															// Return the results of query to this variable. ResultSet is special variable type for databases
		
		
			statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			
		
		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
		
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
				//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
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
			//Statement statement = conn.createStatement();				
			
			//String query = "SELECT * FROM Accounts where UserName = '" + userName + "' AND Password = '" + password + "'";
			
			String query = "SELECT SongID FROM Songs ";
			//System.out.println(query);
			
			
			PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
			
			
			System.out.println("prepared: " + stmt);
			
			ResultSet results = stmt.executeQuery();															
			//System.out.println("this here " + results);
			
			
		
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
			//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
	
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
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
			//Statement statement = conn.createStatement();																
			
			
			
			
			//String query = "SELECT * FROM Accounts where UserID = '" + currentUserID  + "'";	
			String query = "SELECT * FROM Accounts WHERE USERID = ?";
			
			System.out.println(query);
			//ResultSet results = statement.executeQuery(query);															
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
			//Statement statement = conn.createStatement();																
			
			
			
			
			//String query = "SELECT * FROM Accounts where UserID = '" + currentUserID  + "'";	
			String query = "SELECT *, AES_DECRYPT(Password,?) FROM Accounts WHERE USERID = ?";
			
			//String query = "SELECT * FROM Accounts WHERE USERID = ?";
			
			System.out.println(query);
			//ResultSet results = statement.executeQuery(query);															
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
		//Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		
		
		
		//String query = "SELECT * FROM Accounts WHERE UserID = '"+ userID + "'";									
		//ResultSet results = statement.executeQuery(query);			
		
		String query = "SELECT * FROM Accounts WHERE UserID = ?";
		
		
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

			//statement.close();										// Close statement connection to database
		stmt.close();
			conn.close();											// Close connection to database
			
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
		//Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		
		
		
		//String query = "SELECT * FROM Accounts WHERE UserID = '"+ userID + "'";									
		//ResultSet results = statement.executeQuery(query);	
		
	String query = "SELECT * FROM Accounts WHERE UserID = ?";
		
		
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
			//statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
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
		//Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		
		
		
		//String query = "SELECT * FROM Accounts WHERE UserID = '"+ userID + "'";									
		//ResultSet results = statement.executeQuery(query);	
		
	String query = "SELECT * FROM Accounts WHERE UserID = ?";
		
		
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
			//statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
				//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
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
		//Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		
		
		
		//String query = "SELECT * FROM Accounts WHERE UserID = '"+ userID + "'";									
		//ResultSet results = statement.executeQuery(query);	
		
	String query = "SELECT * FROM Accounts WHERE UserID = ?";
		
		
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
			//statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
				//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
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
		//Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		
		
		
		//String query = "SELECT * FROM Accounts WHERE UserID = '"+ userID + "'";									
		//ResultSet results = statement.executeQuery(query);	
		
	String query = "SELECT * FROM Accounts WHERE UserID = ?";
		
		
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
			//statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
	

		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
			{
				throw new CustomException("Username Already Taken", "sql");
				//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
			{
				throw new CustomException("Email Already In Use", "sql");
				//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
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
	//Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
	
	
	
	//String query = "SELECT * FROM Accounts WHERE UserID = '"+ userID + "'";									
	//ResultSet results = statement.executeQuery(query);	
	
String query = "SELECT * FROM Accounts WHERE UserID = ?";
	
	
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
		//statement.close();										// Close statement connection to database
		conn.close();											// Close connection to database
		
	} catch (ClassNotFoundException cnf) {
		System.err.println("Could not load driver");
		System.err.println(cnf.getMessage());


	} catch (SQLException sqlException) {
		System.err.println("Error in SQL Update");
		System.err.println(sqlException.getMessage());
		
		if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
		{
			throw new CustomException("Username Already Taken", "sql");
			//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
	
		}
		else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
		{
			throw new CustomException("Email Already In Use", "sql");
			//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
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
	//Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		
	
	
	
	//String query = "SELECT * FROM Accounts WHERE UserID = '"+ userID + "'";									
	//ResultSet results = statement.executeQuery(query);	
	
//String query = "SELECT *,  AES_DECRYPT(Password,encrypt)  FROM Accounts WHERE UserID = ?";
	String query = "UPDATE Accounts Set Password = AES_ENCRYPT(?,?) WHERE UserID = ?";
	
	PreparedStatement stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
	stmt.setString(1, password);
	stmt.setString(2, decrypt);
	stmt.setString(3, currentUserID);

	
	System.out.println("prepared: " + stmt);
	
	stmt.executeUpdate();

	stmt.close();
		//statement.close();										// Close statement connection to database
		conn.close();											// Close connection to database
		
	} catch (ClassNotFoundException cnf) {
		System.err.println("Could not load driver");
		System.err.println(cnf.getMessage());


	} catch (SQLException sqlException) {
		System.err.println("Error in SQL Update");
		System.err.println(sqlException.getMessage());
		
		if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("UserName"))
		{
			throw new CustomException("Username Already Taken", "sql");
			//JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
	
		}
		else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
		{
			throw new CustomException("Email Already In Use", "sql");
			//JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		}
		else 
		{
			throw new CustomException("Database Connection/SQL Query Issue", "sql");
		}

	}
		
}
	
	
}
