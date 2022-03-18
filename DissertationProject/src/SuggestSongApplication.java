import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SuggestSongApplication {
	
	public static String checkSuggestionForm(String title, String artist, String genre, int comboMin, int comboSec,  Date released, String album, String songInfo, int rating) throws CustomException {
		
		
		
		if (Helper.checkBlank(title)  )
		{
			System.out.println("title error");
			throw new CustomException("Valid Title Input Required", "title");
			//return "firstname";
		}
		if (Helper.checkBlank(artist) )
		{
			System.out.println("artist error");
			throw new CustomException("Valid Artist Input Required", "artist");
			//return "surname";
		}
		if (Helper.checkBlank(genre) )
		{
			System.out.println("genre error");
			throw new CustomException("Valid Genre Input Required", "genre");
			//return "surname";
		}
		
		if (checkSongLength(comboMin, comboSec) )
		{
			System.out.println("songLength error");
			throw new CustomException("Valid SongLength Input Required", "songLength");
		}
		
		if (Helper.checkBlankDate(released)  ||  Helper.compareDates(released) )
		{
			System.out.println("released error");
			throw new CustomException("Valid Release Date Input Required", "released");
			//return "username";
		}
		if (Helper.checkBlank(album))
		{
			System.out.println("album error");
			throw new CustomException("Valid Album Input Required", "album");
			//return "username";
		}
		if (Helper.checkBlank(songInfo))
		{
			System.out.println("songInfo error");
			throw new CustomException("Valid SongInfo Input Required", "songInfo");
			//return "username";
		}
		if (checkRating(rating))
		{
			System.out.println("rating error");
			throw new CustomException("Valid Rating Input Required - Rating Between 1 And 5", "rating");
			//return "username";
		}
	

		return "continue";
	
	}
	
	
	
public static boolean checkSongLength(int comboMin, int comboSec){
		
	if (comboMin == 0 | comboSec == 0 | comboMin == 1 & comboSec == 1  ) 
	{																											
		

		return true;
	}
	else
	{
		return false;
	}
	
	
	}
	
	
public static boolean checkRating(int sliderValue){
	
	if (sliderValue == 0 ) 
	{																											
		
		return true;
	}
	else
	{
		return false;
	}
	
	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
public static boolean checkBlank(String text) {
		
		if (text.strip().isBlank())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static String changeDateFormat(LocalDate localDate) {
	
	
	

		DateTimeFormatter myPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = localDate.format(myPattern);

		return formattedDate;
	}

	public static String dateForDatabase(String date) {
	
	
		String replaceString = date.replace("-", "");


		return replaceString;
	}



}
