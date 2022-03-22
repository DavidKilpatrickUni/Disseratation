import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchPlaylistApplication {
	/*
	
	public static ResultSet search(Object search, Object criteria, int offset, int count) {
	
		if(search == null & criteria.equals("UserName"))
		{
		try
		{
			System.out.println("no search + username");
			
			Class.forName("com.mysql.cj.jdbc.Driver");																	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
			Statement statement = conn.createStatement();
		
			

			String query = "SELECT playlists.*, accounts.* FROM playlists INNER JOIN accounts ON playlists.userID = accounts.userID GROUP BY playlistTitle,playlists.userID ORDER BY playlists.userID DESC, playlistTitle LIMIT " + offset +" ," + count +"" ;
	
			
			//String query = "SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where '" + criteria +"' = '" + search + "' group by playlistTitle" ;

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
		
		else if (criteria.equals("UserName"))
		{
			try
			{
				
				System.out.println("just username");
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
				
				
			
				
				String query = "SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where " + criteria +" = '" + search + "' group by playlistTitle LIMIT " + offset +" ," + count + " " ;

				//String query = "SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where playlists.playlistTitle = '" + search + "' group by playlistTitle" ;
				
				
				
				
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
		
		else if (search == null  & criteria.equals("PlaylistTitle") )
		{
			try
			{
				
				System.out.println("no search + playlistTitle");
				
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
			
				

				String query = "SELECT playlists.*, accounts.* FROM playlists INNER JOIN accounts ON playlists.userID = accounts.userID GROUP BY playlistTitle,playlists.userID ORDER BY playlistTitle, playlists.userID DESC LIMIT " + offset +" ," + count +"" ;
		
				
				//String query = "SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where '" + criteria +"' = '" + search + "' group by playlistTitle" ;

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
				System.out.println("else");
				
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
				System.out.println("SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where " + criteria +"= '" + search + "' group by userName");	
				
			
				
				String query = "SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where " + criteria +" = '" + search + "' group by userName LIMIT " + offset +" ," + count + " " ;
				
				//String query = "SELECT playlists.*, accounts.* from playlists inner join accounts on playlists.userID = accounts.userID where playlists.playlistTitle = '" + search + "' group by playlistTitle" ;
				

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
	
	
	
	}


