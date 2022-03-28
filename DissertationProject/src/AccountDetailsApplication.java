/**
 * <h1> Class </h1>
 * 
 * <p>
 * Application Layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * AccountDetailsApplication
 * </p>
 * 
 * <p>
 * Account Details Application class of the program that stores methods/process/tasks quickly available to the <code>AccountDetailsScreen</code>.
 * <br>Has a direct link with <code>AccountDetailsScreen</code> that receives user input.
 * </p>
 * 
 *
 * @see AccountDetailsScreen
 */
public class AccountDetailsApplication {

	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for checking user firstname is valid . It takes the user input from <code>AccountDetailsScreen</code>as a parameter and checks its not blank and sql sanitises. 
	 * <br> Uses methods from <code>Helper</code>.
	 * <br> If invalid a CutomException is thrown for user feedback purposes.
	 * </p>
	 * <p>
	 * Parameter is the user input for firstname. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param firstname		<code>String</code> object to store current user input. 
	 * 
	 * @see AccountDetailsScreen
	 * @see AccountDetailsApplication
	 * @see Helper
	 * @see CustomException
	 * @see String
	 * @see Boolean
	 */ 
	public static void checkValidFirstname(String firstname) throws CustomException {
		
		if (Helper.checkBlank(firstname) |  Helper.regexSQLInjection(firstname)   )
		{
			System.out.println("firstname error");
			throw new CustomException("Valid First Name Input Required", "firstname");
		}
		
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for checking user surname is valid . It takes the user input from <code>AccountDetailsScreen</code>as a parameter and checks its not blank and sql sanitises. 
	 * <br> Uses methods from <code>Helper</code>.
	 * <br> If invalid a CutomException is thrown for user feedback purposes.
	 * </p>
	 * <p>
	 * Parameter is the user input for surname. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param surname		<code>String</code> object to store current user input. 
	 * 
	 * @see AccountDetailsScreen
	 * @see AccountDetailsApplication
	 * @see Helper
	 * @see CustomException
	 * @see String
	 * @see Boolean
	 */ 
	public static void checkValidSurname(String surname) throws CustomException {
		
		if (Helper.checkBlank(surname) |  Helper.regexSQLInjection(surname)   )
		{
			System.out.println("surname error");
			throw new CustomException("Valid Surname Input Required", "surname");
		}
		
	}
	

	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for checking user password is valid . It takes the user input from <code>AccountDetailsScreen</code>as a parameter and checks its not blank, meets password standard and sql sanitises. 
	 * <br> Uses methods from <code>Helper</code>.
	 * <br> If invalid a CutomException is thrown for user feedback purposes.
	 * </p>
	 * <p>
	 * Parameter is the user input for password. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param password		<code>String</code> object to store current user input. 
	 * 
	 * @see AccountDetailsScreen
	 * @see AccountDetailsApplication
	 * @see Helper
	 * @see CustomException
	 * @see String
	 * @see Boolean
	 */ 
	public static void checkValidPassword(String password) throws CustomException {
		
		if  (Helper.checkBlank(password) || !Helper.regexPassword(password) ||  Helper.regexSQLInjection(password))
		{
			System.out.println("password error");
			throw new CustomException("Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number", "password");
		}
		
	}
	
}
	

