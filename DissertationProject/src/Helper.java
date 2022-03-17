import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public static String dateForDatabase(String date) {
		
		
	String replaceString = date.replace("-", "");
	
	
	return replaceString;
	}
	



}
