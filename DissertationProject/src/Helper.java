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

public class Helper {
	
	public static boolean checkBlank(String text)  {
		
		System.out.println("Helper - checkBlank");
		
		if (text.strip().isBlank())
		{
			
			return true;
			
		}
		else
		{
			
			return false;
			
		}
	}
	
	public static boolean checkBlankDate(Date date)  {
		
		System.out.println("Helper - checkBlankDate");
		
		if (date == null )
		{

			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	public static String properCase(String text) {
		
		System.out.println("Helper - properCase");
		
		text = text.substring(0,1).toUpperCase() + text.substring(1);	
		
		return text;
	
	}
	

	public static boolean checkLength(String text) {
		
		System.out.println("Helper - checkLength");
		
		if (text.strip().length() >= 8)
		{
			
			return true;
			
		}
		else
		{
			
			return false;
			
		}
	}
	
	public static String changeDateFormat(Date date) {
		
		System.out.println("Helper - changeDateFormat");
			
		String pattern ="yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String formattedDate = formatter.format(date);
	
		return formattedDate;
	}
	
	
	public static String changeLocalDateFormat(LocalDate localDate) {
		
		System.out.println("Helper - changeLocalDateFormat");
		
		DateTimeFormatter myPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = localDate.format(myPattern);

		return formattedDate;
	}
	
	
	public static String dateForDatabase(String date) {
		
		System.out.println("Helper - dateForDatabase");
			
		String replaceString = date.replace("-", "");
	
		return replaceString;
	}
	
	public static boolean compareDates(Date date){
		
		System.out.println("Helper - compareDates");
		
		Date currentDate = new Date();
		String pattern ="yyyy-MM-dd";
		int compareDates;
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,Locale.ENGLISH);
		
		try {
		
			Date formattedDate = formatter.parse(Helper.changeDateFormat(date));
			Date formattedCurrentDate = formatter.parse(Helper.changeDateFormat(currentDate));
		
			compareDates = formattedCurrentDate.compareTo(formattedDate);
			System.out.println( "compare Dates: " + compareDates);
	
				if (compareDates  < 0 ) {
			
					System.out.println( "date in future \n");
				
					return true;
				}
				else
				{
			
					System.out.println( "date in past \n");
					return false;
				}
		
			}
			catch(Exception e)
			{	
			
			}
		return false;
	
	}
	
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
