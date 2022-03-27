/**
 * <h1> Class </h1>
 * 
 * <p>
 * Lower level part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * PlaylistInfo
 * </p>
 * 
 * <p>
 * An Object class to hold information about the playlist that is currently in use, created or selected - Currently playlistTitle and playlistID but this is open to further possibilities or requirements
 * <br> This provided a quick and easy way to access and add data to that is beneficial during runtime of this program.
 * <br> Was also decided as the best way to pass data between GUI elements to keep the data of the playlist consistent and produce expected screen content and SQL query returns.
 * </p>
 * 
 */
public class PlaylistInfo {

	// Variables
	
	private String currentPlaylistID;
	private String currentPlaylistTitle;
	
	// Constructors
	// Default 
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>PlaylistInfo</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Constructor to create a <code>PlaylistInfo</code> with no parameters.
	 * </p>
	 * 
	 * 
	 * @see PlaylistInfo
	 *
	 */
	public PlaylistInfo() {
		
	}

	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>PlaylistInfo</code> class with <code>String</code> parameters. 
	 * </p>
	 * 
	 * <p>
	 * Constructor to create a <code>PlaylistInfo</code> with parameter of playlistID.
	 * </p>
	 * 
	 *<p>
	 * Parameter is the playlistID of current playlist. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentPlaylistID			<code>String</code> object to store playlistID of user.

	 * 
	 * @see PlaylistInfo
	 * @see String
	 */
	public PlaylistInfo(String currentPlaylistID) {
		
		this.currentPlaylistID = currentPlaylistID;
	
	}

	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>PlaylistInfo</code> class with <code>String</code> parameters. 
	 * </p>
	 * 
	 * <p>
	 * Constructor to create a <code>PlaylistInfo</code> with parameters of playlistID and playlistTitle.
	 * </p>
	 * 
	 *<p>
	 * Parameter is the playlistID of current playlist. A <code>String</code> object is used to store the data.
	 * <br> Parameter is the playlistTitle of current playlist. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentPlaylistID				<code>String</code> object to store playlistID of user.
	 * @param currentPlaylistTitle			<code>String</code> object to store playlistTitle of user.
	 * 
	 * @see PlaylistInfo
	 * @see String
	 */
	public PlaylistInfo(String currentPlaylistID, String currentPlaylistTitle) {
	
		this.currentPlaylistID = currentPlaylistID;
		this.currentPlaylistTitle = currentPlaylistTitle;

	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To return playlistID for given <code>PlaylistInfo</code> instance.
	 * </p>
	 * 
	 *
	 * @see PlaylistInfo
	 * @see String
	 */
	public String getCurrentPlaylistID() {
	
		return currentPlaylistID;
	
	}

	/**
	 * <h1> Method </h1>
	 * <p>
	 * To set playlistID for given <code>PlaylistInfo</code> instance to given parameter.
	 * </p>
	 * <p>
	 * Parameter is the playlistID for current playlist. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentPlaylistID			<code>String</code> object to store playlistID.
	 *
	 *
	 * @see PlaylistInfo
	 * @see String
	 */
	public void setCurrentPlaylistID(String currentPlaylistID) {
	
		this.currentPlaylistID = currentPlaylistID;
	
	}


	/**
	 * <h1> Method </h1>
	 * <p>
	 * To return playlist title for given <code>PlaylistInfo</code> instance.
	 * </p>
	 * 
	 *
	 * @see PlaylistInfo
	 * @see String
	 */
	public String getCurrentPlaylistTitle() {
	
		return currentPlaylistTitle;
	
	}

	/**
	 * <h1> Method </h1>
	 * <p>
	 * To set playlist title for given <code>PlaylistInfo</code> instance to given parameter.
	 * </p>
	 * <p>
	 * Parameter is the playlist title for current playlist. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentPlaylistTitle			<code>String</code> object to store playlist title.
	 *
	 *
	 * @see PlaylistInfo
	 * @see String
	 */
	public void setCurrentPlaylistTitle(String currentPlaylistTitle) {
	
		this.currentPlaylistTitle = currentPlaylistTitle;
	
	}
	
	
	
	
}
