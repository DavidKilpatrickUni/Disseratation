import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyPlaylistsApplication {
	
	public static ResultSet loadPlaylists(String userID) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			//System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
			//String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
			String query = "SELECT playlists.* , accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where playlists.userID = '" + userID + "' group by PlaylistTitle";
		
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
