import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Application part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * Suggest Song Application
 * </p>
 * 
 * <p>
 * Suggest Song Application of the program that stores methods/process/tasks quickly available to the SuggestSongScreen.
 * <br>Has a direct link with <code>SuggestSongScreen</code> that receives user input.
 * <br> Uses CustomException to throw exceptions - this is when validation errors occur to give user feedback onscreen 
 * </p>
 * 
 *
 * @see SuggestSongScreen
 * @see CustomException
 */

public class SuggestSongApplication {
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input from <code>SuggestSongScreen</code> and calls other methods to process and validate the inputs given.
	 * <br> This method itself is a quick and convenient way to process multiple input parameters.
	 * <br> Uses many methods from <code>Helper</code> class to validate the inputs.
	 * <br> Any validation error is thrown using <code>CustomException</code>
	 * </p>
	 * 
	 * <p>
	 * Parameter 1 is the user input for song title. A <code>String</code> object is used to store the data.
	 * <br>Parameter 2 is the user input for song artist. A <code>String</code> object is used to store the data.
	 * <br>Parameter 3 is the user input for song genre. A <code>String</code> object is used to store the data.
	 * <br>Parameter 4 is the user input for song length in minutes. A <code>Integer</code> object is used to store the data.
	 * <br>Parameter 5 is the user input for song length in seconds. A <code>Integer</code> object is used to store the data.
	 * <br>Parameter 6 is the user input for song released date. A <code>Date</code> object is used to store the data.
	 * <br>Parameter 7 is the user input for song album name. A <code>String</code> object is used to store the data.
	 * <br>Parameter 8 is the user input for song information text. A <code>String</code> object is used to store the data.
	 * <br>Parameter 9 is the user input for personal rating for song. A <code>Integer</code> object is used to store the data.
	 * </p>
	 * 
	 * @param title			<code>String</code> object to store song title input.
	 * @param artist		<code>String</code> object to store song artist input.
	 * @param genre			<code>String</code> object to store song genre input.
	 * @param comboMin		<code>Integer</code> object to store song length in minutes input.
	 * @param comboSec		<code>Integer</code> object to store song length in seconds input.
	 * @param released		<code>Date</code> object to store song release date input.
	 * @param album			<code>String</code> object to store song album input.
	 * @param songInfo		<code>String</code> object to store song information input.
	 * @param rating		<code>Integer</code> object to store personal rating input.
	 *
	 * @see SuggestSongApplication
	 * @see SuggestSongScreen
	 * @see CustomException
	 * @see Helper
	 * @see String
	 * @see Integer
	 * @see Date
	 */
	
	public static String checkSuggestionForm(String title, String artist, String genre, int comboMin, int comboSec,  Date released, String album, String songInfo, int rating) throws CustomException {
		
		
		
		if (Helper.checkBlank(title)  || Helper.regexSQLInjection(title))									// Check title input is not blank or passes SQL sanitisation - if fail throw  
		{
			System.out.println("title error");
			throw new CustomException("Valid Title Input Required", "title");
		}
		
		if (Helper.checkBlank(artist) || Helper.regexSQLInjection(artist) )									// Check artist input is not blank or passes SQL sanitisation - if fail throw 
		{
			System.out.println("artist error");
			throw new CustomException("Valid Artist Input Required", "artist");
		}
		
		if (Helper.checkBlank(genre) || Helper.regexSQLInjection(genre) )									// Check genre input is not blank or passes SQL sanitisation - if fail throw 
		{
			System.out.println("genre error");
			throw new CustomException("Valid Genre Input Required", "genre");
		}
		
		if (checkSongLength(comboMin, comboSec) )															// Check time input is realistic - if fail throw
		{
			System.out.println("songLength error");
			throw new CustomException("Valid SongLength Input Required", "songLength");
		}
		
		if (Helper.checkBlankDate(released)  ||  Helper.compareDates(released) )							// Check date input is realistic - if fail throw
		{
			System.out.println("released error");
			throw new CustomException("Valid Release Date Input Required", "released");
		}
		
		if (Helper.checkBlank(album)  || Helper.regexSQLInjection(album) )									// Check album input is not blank or passes SQL sanitisation - if fail throw 
		{
			System.out.println("album error");
			throw new CustomException("Valid Album Input Required", "album");
		}
		
		if (Helper.checkBlank(songInfo)  || Helper.regexSQLInjection(songInfo))								// Check songinfo input is not blank or passes SQL sanitisation - if fail throw 
		{
			System.out.println("songInfo error");
			throw new CustomException("Valid SongInfo Input Required", "songInfo");
		}
		
		if (checkRating(rating))																			// Check slider value has changed from initialisation - if fail throw 
		{
			System.out.println("rating error");
			throw new CustomException("Valid Rating Input Required - Rating Between 1 And 5", "rating");
		}
	
		return "continue";
	
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for checking user input is of a valid time. It takes the selected index of comboBoxes and checks them against certain values. 
	 * </p>
	 * <p>
	 * Parameter 1 is the user input for song length in minutes. A <code>Integer</code> object is used to store the data.
	 * <br>Parameter 2 is the user input for song length in seconds. A <code>Integer</code> object is used to store the data.
	 * </p>
	 * 
	 * @param comboMin			<code>Integer</code> object to store personal rating input.
	 * @param comboSec			<code>Integer</code> object to store personal rating input.
	 *
	 * @see SuggestSongApplication
	 * @see Integer
	 * @see Boolean
	 */
	
	public static boolean checkSongLength(int comboMin, int comboSec){
		
		System.out.println("SuggestSongApplication - checkSongLength");
		
		if (comboMin == 0 | comboSec == 0 | comboMin == 1 & comboSec == 1  ) 			// 0 would be '--' user input and 1 is '0', hence a song can not be 0:00 long or use invalid characters
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
	 * Method for checking user input is of a valid rating. It takes the selected value of a slider GUI element and checks them against certain values. 
	 * </p>
	 * 
	 * <p>
	 * <br>Parameter is the user input for my song rating. A <code>Integer</code> object is used to store the data.
	 * </p>
	 * 
	 * @param sliderValue			<code>Integer</code> object to store personal rating input.
	 * 
	 * @see SuggestSongApplication
	 * @see Integer
	 * @see Boolean
	 */
	
	public static boolean checkRating(int sliderValue){
	
		System.out.println("SuggestSongApplication - checkRating");
		
		if (sliderValue == 0 ) 										// A song rating must be between 1 and 5 as of design. A value of '0' means the user has not moved the slider to declare a value
																	// The minimum and maximum values are set at 1 and 5 and can not be exceeded because of how sliders work.
		{																											
			return true;
		}
		else
		{
			return false;
		}
	
	
	}
	

}
