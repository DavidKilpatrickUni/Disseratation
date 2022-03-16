import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchPlaylistApplication {
	
	public static ResultSet search(String search, String criteria) {
		
		
	
		
		if (criteria.strip().equals("UserName"))
		{

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
			//System.out.println("SELECT * FROM playlists where " + criteria + "='" + search + "'" + " GROUP BY PlaylistTitle");	
			

			
			
			
			String query = "SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where accounts.UserName = '" + search + "' group by playlistTitle" ;
			
			
			
			
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
		else 
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
				//System.out.println("SELECT * FROM playlists where " + criteria + "='" + search + "'" + " GROUP BY PlaylistTitle");	
				
			
				
				
				
				String query = "SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where playlists.playlistTitle = '" + search + "' group by playlistTitle" ;
				
				
				
				
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
		
	}


