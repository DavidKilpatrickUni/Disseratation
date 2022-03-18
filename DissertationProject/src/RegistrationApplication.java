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

public class RegistrationApplication {
	
	
	public static String checkRegistrationForm(String firstname, String surname, String myIdentity, Date date,  String username, String email, String password, String confirm) throws CustomException {
		
		
		System.out.println(date);
		
		if (Helper.checkBlank(firstname) ||  Helper.regexSQLInjection(firstname) )
		{
			System.out.println("firstname error");
			throw new CustomException("Valid First Name Input Required", "firstname");
			//return "firstname";
		}
		if (Helper.checkBlank(surname) ||  Helper.regexSQLInjection(surname))
		{
			System.out.println("lastname error");
			throw new CustomException("Valid Surname Input Required", "surname");
			//return "surname";
		}
		if (!checkIdentity(myIdentity))
		{
			System.out.println("identity error");
			throw new CustomException("Valid Identity Input Required", "identity");
			//return "username";
		}
		if (Helper.checkBlankDate(date)  ||  Helper.compareDates(date) || checkAge(date))
		{
			System.out.println("date error");
			throw new CustomException("Valid Date Input Required", "DOB");
			//return "username";
		}
		if (Helper.checkBlank(username) ||   Helper.regexSQLInjection(username))
		{
			System.out.println("username error");
			throw new CustomException("Valid User Input Required", "username");
			//return "username";
		}
		if (Helper.checkBlank(email) || !regexEmail(email) ||  Helper.regexSQLInjection(email))
		{
			System.out.println("email error");
			throw new CustomException("Valid Email Address Input Required", "email");
			//return "email";
		}
		if (Helper.checkBlank(password) || !regexPassword(password) ||  Helper.regexSQLInjection(password))
		{
			System.out.println("password error");
			throw new CustomException("Valid Password Input Required", "password");
			//return "password";
		}
		if (Helper.checkBlank(confirm) || Helper.regexSQLInjection(confirm) || !comparePassword(password, confirm))
		{
			System.out.println("confirm password error");
			throw new CustomException("Passwords Dont Match", "confirm");
			//return "confirm";
		}
		return "continue";
	
	}
	
	
	public static boolean comparePassword(String password, String confirmPassword)  {
		
		if (password.equals(confirmPassword))
		{
			return true;
		
		}
		else
		{
			return false;
		}
	}
	
	
	public static boolean regexPassword(String text) {
		
		System.out.print(text+"\n");
		String regex = "^(?=.*[0-9])"
                + "(?=.*[A-Z])"
                + "(?=.*[@#£$%^&+?!])"
                + "(?=\\S+$).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		boolean matchFound = matcher.find();
		
		if (matchFound)
		{
			return true;
		}
		else
		{
		
			return false;
		}
	}
	

	
	public static boolean regexEmail(String text)  {
		
		System.out.print(text+"\n");
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+"
				+ "(?:com|co.uk)$";
	
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		boolean matchFound = matcher.find();
		
		if (matchFound)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public static boolean checkIdentity(String identity) {
		
		switch (identity) {
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
	

	
	
	
public static boolean checkAge(Date date) {
	
	LocalDate birthDate = LocalDate.parse(Helper.changeDateFormat(date));
	LocalDate currentDate = LocalDate.now();
	
	
	System.out.println(Period.between(birthDate, currentDate).getYears());
	
	int years = Period.between(birthDate, currentDate).getYears();

	if (years  < 15 ) {
		System.out.println( "is under 16 \n");
	
		return true;
	}
	
	
	else
	{
		System.out.println( "is 16 or over \n");
		return false;
	}
}
	
	
	
	
	
	
	
	
	
	
	public static void createAccount(String firstName, String surname, String DOB, String identity, String userName, String password, String email) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into accounts VALUES (NULL ,'" + firstName +  "','" + surname + "','" + DOB + "','" + identity + "','" + userName + "','" + password + "','" + email + "', null, null, null, null, null, null )";		
		
			
			
			statement.executeUpdate(query);															// Return the results of query to this variable. ResultSet is special variable type for databases
		
		
			statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			
		
		} catch (SQLException sqlException) {
			System.err.println("Error in SQL Update");
			System.err.println(sqlException.getMessage());
			System.err.println(sqlException.getMessage().substring(0,16));
			
			
			if (sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Username"))
			{
				JOptionPane.showMessageDialog(null, "Username Already Taken", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
		
			}
			else if(sqlException.getMessage().substring(0,16).contains("Duplicate entry") & sqlException.getMessage().contains("Email"))
		{
				JOptionPane.showMessageDialog(null, "Email Already In Use", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
			}
			
			
		}
	}
	
	public static void createAccount() {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into accounts VALUES (NULL , 'dave', 'smith', 20220309, 'male', 'davesmith' , 'A1234567!' , 'dave@smith.com')";		
		
			
			
			statement.executeUpdate(query);															// Return the results of query to this variable. ResultSet is special variable type for databases
		
		
			statement.close();										// Close statement connection to database
			conn.close();											// Close connection to database
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		
		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
			System.exit(-1);
		}
	}
	
	

	

	
	

	
	

	
	
	/*
	public static boolean checkDateValid(Date date) throws ParseException {
		
		Date currentDate = new Date();
		String pattern ="yyyy-MM-dd";
		int compareDates;
	
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,Locale.ENGLISH);
		
		Date formattedDate = formatter.parse(changeDateFormat(date));
		Date formattedCurrentDate = formatter.parse(changeDateFormat(currentDate));
		

		
		long diffInMillies = Math.abs(formattedCurrentDate.getTime() - date.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
		System.out.println(diff + "\n");
		
		
	
			if (diff > 100 ) {
				System.out.println( "over 100 days \n");
				return true;
			}
			else
			{
				System.out.println("under 100 days\n");
				return false;
			}
			
	
	}
		*/
	

	
	
		

	
	/*
	public static boolean checkDate(String date) {
		
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-MM-dd");
	boolean result = format.parse(date) != null;	

		return result;
	
	}
	*/
	
	/*
	public static Boolean checkIdentity(Boolean female, Boolean male, Boolean NB) {
		
		String identity;
		
		if (female | male | NB)
		{
			return true;
		}

		else
		{
			return false;
		}
		
		
	}
	*/
	/*
	public static String getIdentity(Boolean female, Boolean male, Boolean NB) {
		
		String identity;
		
		if (female)
		{
			identity = "Female";
			return identity;
		}
		else if (male)
		{
			identity = "Male";
			return identity;
		}
		else
		{
			identity = "Non-binary";
			return identity;
		}
		
		
	}
*/
	

	

	


}
