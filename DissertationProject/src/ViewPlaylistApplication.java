import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewPlaylistApplication {
	
public static ResultSet loadPlaylist(String playlistTitle, String userID ) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			//System.out.println("SELECT * FROM songs where SongID = '" + songID + "'");	
			//String query = "SELECT * FROM songs where SongID = '" + songID + "'";	
			String query = "SELECT playlists.* , songs.* from playlists inner join songs ON playlists.songID = songs.songID where playlists.PlaylistTitle = '" + playlistTitle + "' AND playlists.UserID = '" + userID + "'";
		
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
