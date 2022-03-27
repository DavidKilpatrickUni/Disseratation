import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.border.Border;


/**
 * <h1> Class </h1>
 * 
 * <p>
 * Lower level part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * Helper
 * </p>
 * 
 * <p>
 * A class for housing methods that are commonly used throughout the program. This makes them quick and convenient to access and removes duplicate and redundant code from program.  
 * </p>
 * 
 */
public class Helper {
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Checks if a <code>String</code> parameter has content (Not blank)
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param text					<code>String</code> object to store user input.
	 * 
	 * @see String
	 * @see Boolean
	 */
	
	public static boolean checkBlank(String text)  {
		
		System.out.println("Helper - checkBlank");
		
		if (text.strip().isBlank())								// Check if input blank
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
	 * Checks if a <code>Date</code> parameter has content (Not blank)
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param date					<code>Date</code> object to store user input.
	 * 
	 * @see Date
	 * @see Boolean
	 */
	
	public static boolean checkBlankDate(Date date)  {
		
		System.out.println("Helper - checkBlankDate");
		
		if (date == null )												// Check if not null - This is due to how the Calendar GUI element works. ie is either a valid date of null
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
	 * Alters a <code>String</code> parameter to have properCase - A capital first letter 
	 * <br> Method not currently used but is useful for future development. 
	 * <br> Decided not to use currently so that user input is more free and not restricted. Maybe change this in the future to keep program better organised, aesthetically better and uniformed. 
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param text					<code>String</code> object to store user input.
	 * 
	 * 
	 * @see String
	 * 
	 */
	
	public static String properCase(String text) {
		
		System.out.println("Helper - properCase");
		
		text = text.substring(0,1).toUpperCase() + text.substring(1);	// Sub string first letter and change it to upper case
		
		return text;
	
	}
	

	/**
	 * <h1> Method </h1>
	 * <p>
	 * Checks the length of <code>String</code> parameter 
	 * <br> Method not currently used but is useful for future development of limiting user input - length of comment or songInfo input etc
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param text					<code>String</code> object to store user input.
	 * 
	 * 
	 * @see String
	 * @see Boolean
	 */
	
	public static boolean checkLength(String text) {
		
		System.out.println("Helper - checkLength");
		
		if (text.strip().length() >= 8)		// Checks the length of String is 8 or greater
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
	 * Changes the format of a <code>Date</code> parameter - More suitable format for this program and how date is used.
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param date					<code>Date</code> object to store user input.
	 * 
	 * 
	 * @see Date
	 */
	
	public static String changeDateFormat(Date date) {
		
		System.out.println("Helper - changeDateFormat");
			
		String pattern ="yyyy-MM-dd";												// format
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String formattedDate = formatter.format(date);
	
		return formattedDate;
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Changes the format of a <code>LocalDate</code> parameter - More suitable format for this program and how date is used.
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param localDate					<code>LocalDate</code> object to store user input.
	 * 
	 * 
	 * @see LocalDate
	 */
	
	public static String changeLocalDateFormat(LocalDate localDate) {
		
		System.out.println("Helper - changeLocalDateFormat");
		
		DateTimeFormatter myPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");		// format
		String formattedDate = localDate.format(myPattern);

		return formattedDate;
	}
	
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Changes the format of a <code>String</code> parameter - Database only accepts and displays the date as format desired.
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param date					<code>String</code> object to store user input.
	 * 
	 * 
	 * @see String
	 */
	
	public static String dateForDatabase(String date) {
		
		System.out.println("Helper - dateForDatabase");
			
		String replaceString = date.replace("-", "");			// Remove character from String
	
		return replaceString;
	}
	
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Compares <code>Date</code> parameter to the current date - This is to check that date input from user is valid (Date not beyond current date).
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param date					<code>Date</code> object to store user input.
	 * 
	 * 
	 *  
	 * @see Date
	 * @see Boolean
	 */
	public static boolean compareDates(Date date){
		
		System.out.println("Helper - compareDates");
		
		Date currentDate = new Date();																// Create current date to compare to
		String pattern ="yyyy-MM-dd";
		int compareDates;
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,Locale.ENGLISH);
		
		try {
		
			Date formattedDate = formatter.parse(Helper.changeDateFormat(date));					// Format parameter
			Date formattedCurrentDate = formatter.parse(Helper.changeDateFormat(currentDate));		// format current date
		
			compareDates = formattedCurrentDate.compareTo(formattedDate);							// Sets variable to result of compareTo function 
			System.out.println( "compare Dates: " + compareDates);
	
				if (compareDates  < 0 ) {															
			
					System.out.println( "date in future \n");
				
					return true;
				}
				else if (compareDates > 0)
				{
			
					System.out.println( "date in past \n");
					return false;
				}
		
			}
			catch(Exception e)
			{	
				System.out.println(e);
			}
		return true;
	
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Checks <code>String</code> parameter for characters that can be harmful in mySQL queries - Sanitises input for sql injections ' =
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param text					<code>String</code> object to store user input.
	 * 
	 * 
	 * @see String
	 * @see Boolean
	 */
	
	public static boolean regexSQLInjection(String text)  {
		
		System.out.println("Helper - regexSQLInjection");
		
		String regex = "(?=.*[='])";
              
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
	
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Checks <code>String</code> parameter for characteristics of a password - Elenco passwords require length 8 - 20, 1 number, 1 capital letter and 1 special character 
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param text					<code>String</code> object to store user input.
	 * 
	 * @see String
	 * @see Boolean
	 */
	public static boolean regexPassword(String text) {
		
		System.out.println("Helper - regexPassword");
	
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
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Checks <code>String</code> parameter for valid playlist title
	 * <br> This is a convenient housing for two other <code>Helper</code> methods that carry out the actual process
	 * </p>
	 * <p>
	 * Parameter is user input.
	 * </p>
	 * 
	 * @param potentialPlaylistTitle					<code>String</code> object to store user input.
	 * 
	 * 
	 * @see String
	 * @see Boolean
	 * @see Helper
	 * 
	 */
	public static boolean checkPlaylistTitle(String potentialPlaylistTitle){
		
		if (Helper.checkBlank(potentialPlaylistTitle) || Helper.regexSQLInjection(potentialPlaylistTitle))
		{
			return true;
	
		}
		else
		{
			return false;
		}

	}


}
