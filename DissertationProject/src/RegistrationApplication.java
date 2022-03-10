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

public class RegistrationApplication {
	
	public static void createAccount(String firstName, String surname, String DOB, String identity, String userName, String password, String email) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");																	// Set up java driver for working with mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	// Connect to certain database 'DE-Store'. User: root. Password: 
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);		// Create query statement connection with database
	
			String query = "Insert Into accounts VALUES (NULL ,'" + firstName +  "','" + surname + "','" + DOB + "','" + identity + "','" + userName + "','" + password + "','" + email + "' )";		
		
			
			
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
	
	
	public static boolean checkBlank(String text) {
		
		if (text.trim().isBlank())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static String properCase(String text) {
		
		
		text = text.substring(0,1).toUpperCase() + text.substring(1);	
		
		return text;
	
	}
	
	
	public static boolean checkLength(String text) {
		
		if (text.trim().length() >= 8)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static String changeDateFormat(Date date) {
		
		
	String pattern ="yyyy-MM-dd";
	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	String formattedDate = formatter.format(date);
	
	
	return formattedDate;
	}
	
	public static String dateForDatabase(String date) {
		
		
	String replaceString = date.replace("-", "");
	
	
	return replaceString;
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
	
	public static boolean checkAge(Date date) {
		
		LocalDate birthDate = LocalDate.parse(changeDateFormat(date));
		LocalDate currentDate = LocalDate.now();
		
		
		System.out.println(Period.between(birthDate, currentDate).getYears());
		
		int years = Period.between(birthDate, currentDate).getYears();
	
		if (years  > 15 ) {
			
			System.out.println( "is 16 or over \n");
			return true;
		}
		
		
		else
		{
			System.out.println( "is under 16 \n");
			return false;
		}
	}
	
	public static boolean compareDates(Date date){
		
		
		Date currentDate = new Date();
		String pattern ="yyyy-MM-dd";
		int compareDates;
		
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,Locale.ENGLISH);
		
		try {
		
		Date formattedDate = formatter.parse(changeDateFormat(date));
		Date formattedCurrentDate = formatter.parse(changeDateFormat(currentDate));
		
		compareDates = formattedCurrentDate.compareTo(formattedDate);
		System.out.println( "compare Dates: " +compareDates);
	
		if (compareDates  > 0 ) {
			
			System.out.println( "date in past \n");
			return true;
		}
		
		
		else
		{
			System.out.println( "date in future \n");
			return false;
		}
		}
		catch(Exception e)
		{	
		}
		return false;
	
	}
		

	
	/*
	public static boolean checkDate(String date) {
		
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-MM-dd");
	boolean result = format.parse(date) != null;	

		return result;
	
	}
	*/
	
	
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
	
	public static boolean regexCheck(String text) {
		
		System.out.print(text+"\n");
		String regex = "^(?=.*[0-9])"
                + "(?=.*[A-Z])"
                + "(?=.*[@#£$%^&+=?!])"
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
	
	public static boolean regexEmail(String text) {
		
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
	
	public static boolean comparePassword(String password, String confirmPassword) {
		
		if (password.equals(confirmPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
