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
		
		
		
		if (Helper.checkBlank(title)  || Helper.regexSQLInjection(title))
		{
			System.out.println("title error");
			throw new CustomException("Valid Title Input Required", "title");
		}
		
		if (Helper.checkBlank(artist) || Helper.regexSQLInjection(artist) )
		{
			System.out.println("artist error");
			throw new CustomException("Valid Artist Input Required", "artist");
		}
		
		if (Helper.checkBlank(genre) || Helper.regexSQLInjection(genre) )
		{
			System.out.println("genre error");
			throw new CustomException("Valid Genre Input Required", "genre");
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
		}
		
		if (Helper.checkBlank(album)  || Helper.regexSQLInjection(album) )
		{
			System.out.println("album error");
			throw new CustomException("Valid Album Input Required", "album");
		}
		
		if (Helper.checkBlank(songInfo)  || Helper.regexSQLInjection(songInfo))
		{
			System.out.println("songInfo error");
			throw new CustomException("Valid SongInfo Input Required", "songInfo");
		}
		
		if (checkRating(rating))
		{
			System.out.println("rating error");
			throw new CustomException("Valid Rating Input Required - Rating Between 1 And 5", "rating");
		}
	
		return "continue";
	
	}
	
	
	
	public static boolean checkSongLength(int comboMin, int comboSec){
		
		System.out.println("SuggestSongApplication - checkSongLength");
		
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
	
		System.out.println("SuggestSongApplication - checkRating");
		
		if (sliderValue == 0 ) 
		{																											
			return true;
		}
		else
		{
		return false;
		}
	
	
	}
	

}
