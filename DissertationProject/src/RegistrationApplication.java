import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

import javax.swing.JOptionPane;  


/**
 * <h1> Class </h1>
 * 
 * <p>
 * Application Layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * RegistrationApplication
 * </p>
 * 
 * <p>
 * Registration Application class of the program that stores methods/process/tasks quickly available to the RegistrationScreen.
 * <br>Has a direct link with <code>RegistrationScreen</code> that receives user input.
 * <br> Uses CustomException to throw exceptions - this is when validation errors occur to give user feedback onscreen 
 * </p>
 * 
 *
 * @see RegistrationScreen
 * @see CustomException
 */
public class RegistrationApplication {
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input from <code>RegistrationScreen</code> and calls other methods to process and validate the inputs given.
	 * <br> Uses many methods from <code>Helper</code> class.
	 * <br> Any validation error is thrown using <code>CustomException</code>
	 * </p>
	 * 
	 * <p>
	 * Parameter 1 is the user input for firstname. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the user input for surname. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the user input for identity. A <code>String</code> object is used to store the data.
	 * <br>Parameter 4 is the user input for date of birth. A <code>Date</code> object is used to store the data.
	 * <br>Parameter 5 is the user input for username. A <code>String</code> object is used to store the data.
	 * <br>Parameter 6 is the user input for email. A <code>String</code> object is used to store the data.
	 * <br>Parameter 7 is the user input for password. A <code>String</code> object is used to store the data.
	 * <br>Parameter 8 is the user input for confirm password. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param firstname			<code>String</code> object to store firstname input.
	 * @param surname			<code>String</code> object to store surname input.
	 * @param myIdentity		<code>String</code> object to store identity input.
	 * @param date				<code>Date</code> object to store date of birth input.
	 * @param username			<code>String</code> object to store username input.
	 * @param email				<code>String</code> object to store email input.
	 * @param password			<code>String</code> object to store password input.
	 * @param confirm			<code>String</code> object to store confirm password input.
	 *
	 * @see RegistrationApplication
	 * @see RegistrationScreen
	 * @see CustomException
	 * @see Helper
	 * @see String
	 * @see Date
	 */
	
	public static String checkRegistrationForm(String firstname, String surname, String myIdentity, Date date,  String username, String email, String password, String confirm) throws CustomException {
	

		if (Helper.checkBlank(firstname) ||  Helper.regexSQLInjection(firstname) )				// Check firstname input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("firstname error");
			throw new CustomException("Valid First Name Input Required", "firstname");
		}
		
		if (Helper.checkBlank(surname) ||  Helper.regexSQLInjection(surname))					// Check surname input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("lastname error");
			throw new CustomException("Valid Surname Input Required", "surname");
		}
		
		if (!checkIdentity(myIdentity))															// Check identity input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("identity error");
			throw new CustomException("Valid Identity Input Required", "identity");
		}
		
		if (Helper.checkBlankDate(date)  ||  Helper.compareDates(date) || checkAge(date))		// Check date of birth input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("date error");
			throw new CustomException("Valid Date Input Required - New Users Must Be 16+", "DOB");
		}
		
		if (Helper.checkBlank(username) ||   Helper.regexSQLInjection(username))				// Check username input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("username error");
			throw new CustomException("Valid Username Input Required", "username");
		}
		
		if (Helper.checkBlank(email) || !regexEmail(email) ||  Helper.regexSQLInjection(email))				// Check email input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("email error");
			throw new CustomException("Valid Email Address Input Required - Requires @ AND .com OR .co.uk", "email");
		}
		
		if (Helper.checkBlank(password) || !Helper.regexPassword(password) ||  Helper.regexSQLInjection(password))		// Check password input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("password error");
			throw new CustomException("Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number", "password");
		}
		
		if (Helper.checkBlank(confirm) || Helper.regexSQLInjection(confirm) || !comparePassword(password, confirm))		// Check confirm password input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("confirm password error");
			throw new CustomException("Passwords Dont Match", "confirm");
		}
		
		return "continue";
	
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for comparing 2 user inputs of password and confirm password match each other.  
	 * </p>
	 * <p>
	 * Parameter 1 is the user password input. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the user confirm password input. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param password			<code>String</code> object to store personal rating input.
	 * @param confirmPassword			<code>String</code> object to store personal rating input.
	 *
	 * @see RegistrationApplication
	 * @see String
	 * @see Boolean
	 */
	public static boolean comparePassword(String password, String confirmPassword)  {
		
		System.out.println("RegistrationApplication - comparePassword");
		
		if (password.equals(confirmPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for checking user input has email characteristics - Covers use of certain characters, contains an @ sign and .com or .co.uk ending.  
	 * </p>
	 * <p>
	 * Parameter is the user email input. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param text			<code>String</code> object to store personal rating input.
	 *
	 * @see RegistrationApplication
	 * @see String
	 * @see Boolean
	 */
	public static boolean regexEmail(String text)  {
		
		System.out.println("RegistrationApplication - regexEmail");
		
		System.out.print(text+"\n");
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+"
				+ "(?:com|co.uk)$";
	
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		boolean matchFound = matcher.find();					// Search through string to find elements declared in the regex variable 
		
		if (matchFound)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for checking user input for identity is a valid input - Is Male, Female or Non-binary.  
	 * </p>
	 * <p>
	 * Parameter is the user identity input. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param identity			<code>String</code> object to store personal rating input.
	 *
	 * @see RegistrationApplication
	 * @see String
	 * @see Boolean
	 */
	public static boolean checkIdentity(String identity) {
		
		System.out.println("RegistrationApplication - checkIdentity");
		
		switch (identity) {																	// Use switch statement to return without question that a valid identity type has been selected 
			case "Male":
				return true;
				
			case "Female":
				return true;
			
			case "Non-binary":
				return true;
			
			default:
				return false;
				
		}		
		
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for checking user input for date of birth is within design of the program - Users must be of 16 years of age to have an Elenco account.  
	 * <br> This is obviously not a fail safe way to determined a users age but is a start and shows intention of this project of making it safe and secure.
	 * </p>
	 * <p>
	 * Parameter is the user date of birth input. A <code>Date</code> object is used to store the data.
	 * </p>
	 * 
	 * @param date			<code>Date</code> object to store personal rating input.
	 *
	 * @see RegistrationApplication
	 * @see String
	 * @see Boolean
	 */
	public static boolean checkAge(Date date) {
		
		System.out.println("RegistrationApplication - checkAge");
	
		LocalDate birthDate = LocalDate.parse(Helper.changeDateFormat(date));
		LocalDate currentDate = LocalDate.now();
	
		System.out.println(Period.between(birthDate, currentDate).getYears());
	
		int years = Period.between(birthDate, currentDate).getYears();							// Compares the user input and generated todays date, and returns it in terms of years

		if (years  <= 15 ) {																	// If value less then 15 dont allow the creation of account - True triggers a CustomException
			System.out.println( "is under 16 \n");
	
			return true;
		}
	
		else
		{
			System.out.println( "is 16 or over \n");
			return false;
		}
	}
	
}
