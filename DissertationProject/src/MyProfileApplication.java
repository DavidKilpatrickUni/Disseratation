import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Application part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * MyProfileApplication
 * </p>
 * 
 * <p>
 * MyProfileApplication of the program that stores methods/process/tasks quickly available to the MyProfileScreen.
 * <br>Has a direct link with <code>MyProfileScreen</code> that receives user input.
 * </p>
 * 
 *
 * @see MyProfileScreen
 */
public class MyProfileApplication {

	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input from <code>MyProfileScreen</code> and checks that the username provided by user is valid.
	 * <br> Is a quick and convenient method that houses other methods from the <code>Helper</code> class relevant to the task of validating a username.
	 * <br> If the input is not valid, a CustomException is thrown to provide the user with feedback.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the username provided by user. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param username			<code>String</code> object to store user input.
	 *
	 * @see MyProfileApplication
	 * @see MyProfileScreen
	 * @see CustomException
	 * @see String
	 */
	public static void checkValidUsername(String username) throws CustomException {
	
		if (Helper.checkBlank(username) |  Helper.regexSQLInjection(username) )        // Checks if user input of username is valid
		{
			System.out.println("username error");
			throw new CustomException("Valid Username Input Required", "username");
		}
		System.out.println("username valid");
	}


}
	
	

