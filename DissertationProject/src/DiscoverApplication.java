import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiscoverApplication {

	public static ResultSet search(String search, Object criteria, Object sort, String sortType) {
		
		
		if(checkBlank(search) == true)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");																	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
				Statement statement = conn.createStatement();
				System.out.println("SELECT * FROM songs ORDER BY " + sort + " " + sortType+ ", " + criteria +  " " + sortType);	
				String query = "SELECT * FROM songs ORDER BY " + sort + " " + sortType + ", " + criteria + " " + sortType;		
				
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
				System.out.println("SELECT * FROM songs where " + criteria + "='" + search + "'" + "ORDER BY " + sort + " " + sortType + "" );	
				String query = "SELECT * FROM songs where " + criteria + "='" + search + "'" + "ORDER BY " + sort + " " + sortType + "";	
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
	
	
	public static boolean checkBlank(String text) {
		
		if (text.strip().isBlank())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
