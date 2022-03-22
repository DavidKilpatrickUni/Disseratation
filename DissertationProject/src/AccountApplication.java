import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountApplication {

	public static void checkValidFirstname(String firstname) throws CustomException {
		
		if (Helper.checkBlank(firstname) |  Helper.regexSQLInjection(firstname)   )
		{
			System.out.println("firstname error");
			throw new CustomException("Valid First Name Input Required", "firstname");
		}
		
	}
	
	public static void checkValidSurname(String surname) throws CustomException {
		
		if (Helper.checkBlank(surname) |  Helper.regexSQLInjection(surname)   )
		{
			System.out.println("surname error");
			throw new CustomException("Valid Surname Input Required", "surname");
		}
		
	}
	
	public static void checkValidPassword(String password) throws CustomException {
		
		if  (Helper.checkBlank(password) || !Helper.regexPassword(password) ||  Helper.regexSQLInjection(password))
		{
			System.out.println("password error");
			throw new CustomException("Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number", "password");
		}
		
	}
			
}
	

