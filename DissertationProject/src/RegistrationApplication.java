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
		

		if (Helper.checkBlank(firstname) ||  Helper.regexSQLInjection(firstname) )
		{
			System.out.println("firstname error");
			throw new CustomException("Valid First Name Input Required", "firstname");
		}
		
		if (Helper.checkBlank(surname) ||  Helper.regexSQLInjection(surname))
		{
			System.out.println("lastname error");
			throw new CustomException("Valid Surname Input Required", "surname");
		}
		
		if (!checkIdentity(myIdentity))
		{
			System.out.println("identity error");
			throw new CustomException("Valid Identity Input Required", "identity");
		}
		
		if (Helper.checkBlankDate(date)  ||  Helper.compareDates(date) || checkAge(date))
		{
			System.out.println("date error");
			throw new CustomException("Valid Date Input Required - New Users Must Be 16+", "DOB");
		}
		
		if (Helper.checkBlank(username) ||   Helper.regexSQLInjection(username))
		{
			System.out.println("username error");
			throw new CustomException("Valid Username Input Required", "username");
		}
		
		if (Helper.checkBlank(email) || !regexEmail(email) ||  Helper.regexSQLInjection(email))
		{
			System.out.println("email error");
			throw new CustomException("Valid Email Address Input Required - Requires @ AND .com OR .co.uk", "email");
		}
		
		if (Helper.checkBlank(password) || !Helper.regexPassword(password) ||  Helper.regexSQLInjection(password))
		{
			System.out.println("password error");
			throw new CustomException("Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number", "password");
		}
		
		if (Helper.checkBlank(confirm) || Helper.regexSQLInjection(confirm) || !comparePassword(password, confirm))
		{
			System.out.println("confirm password error");
			throw new CustomException("Passwords Dont Match", "confirm");
		}
		
		return "continue";
	
	}
	
	
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
	
	public static boolean regexEmail(String text)  {
		
		System.out.println("RegistrationApplication - regexEmail");
		
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
		
		System.out.println("RegistrationApplication - checkIdentity");
		
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
		
		System.out.println("RegistrationApplication - checkAge");
	
		LocalDate birthDate = LocalDate.parse(Helper.changeDateFormat(date));
		LocalDate currentDate = LocalDate.now();
	
		System.out.println(Period.between(birthDate, currentDate).getYears());
	
		int years = Period.between(birthDate, currentDate).getYears();

		if (years  <= 15 ) {
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
