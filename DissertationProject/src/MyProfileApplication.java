import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyProfileApplication {


	
	
	public static void checkValidUsername(String username) throws CustomException {
	
		if (Helper.checkBlank(username) |  Helper.regexSQLInjection(username)   )
		{
			System.out.println("username error");
			throw new CustomException("Valid Username Input Required", "username");
		}
	
	}



}
	
	

