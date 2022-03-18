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
		
		if (text.strip().isBlank())
		{
			//JOptionPane.showMessageDialog(null, "More Information Required", "Simply Rugby - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
			//throw new CustomException("More Input Required", "firstname");
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	public static boolean checkBlankDate(Date date)  {
		
		if (date == null )
		{
			//JOptionPane.showMessageDialog(null, "More Information Required", "Simply Rugby - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
			//throw new CustomException("More Input Required", "firstname");
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
	
	
	public static String changeLocalDateFormat(LocalDate localDate) {
		
		
		

		DateTimeFormatter myPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = localDate.format(myPattern);

		return formattedDate;
	}
	
	
	public static String dateForDatabase(String date) {
		
		
	String replaceString = date.replace("-", "");
	
	
	return replaceString;
	}
	
	public static boolean compareDates(Date date){
		
		
		Date currentDate = new Date();
		String pattern ="yyyy-MM-dd";
		int compareDates;
		
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern,Locale.ENGLISH);
		
		try {
		
		Date formattedDate = formatter.parse(Helper.changeDateFormat(date));
		Date formattedCurrentDate = formatter.parse(Helper.changeDateFormat(currentDate));
		
		compareDates = formattedCurrentDate.compareTo(formattedDate);
		System.out.println( "compare Dates: " +compareDates);
	
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
		
		System.out.print(text+"\n");
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



}
