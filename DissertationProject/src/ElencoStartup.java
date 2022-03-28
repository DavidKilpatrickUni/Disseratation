
/**
 * <h1> Program </h1>
 * 
 * <p>
 * A social and community driven prototype application called Elenco to fulfil the programming section of University dissertation.
 * </p>
 * <p>
 * This is the main(args) for this application. On startup it loads the first GUI. All other actions and navigation is user driven through multiple GUI screens.
 * There is a login system to allow user accounts access to the program or create a new account.
 * This leads to the main menu which allows access to the 4 key features of the program.
 * 1. Suggesting a song to Elenco - This is creating a new database entry with song information that can then be viewed, rated and commented on by fellow Elenco users.
 * 2. Search the existing Elenco song bank for songs based on a custom search. Search results can then be viewed for further information, rating of or commenting on the song.
 * 3. My playlists - This is a feature for allowing the user to store up to ten different song lists that they have created from scratch and then manage said palylists.
 * 4. Search for playlist. This allows users to use a custom search to find other users playlist and then view the songs of which they contain
 * </p>
 * 
 * @author David Kilpatrick
 * @version 1.0
 * @since 07/03/2022
 */

public class ElencoStartup {

	public static void main(String[] args) {

		LoginScreen gui = new LoginScreen();
		gui.setVisible(true);
	}

}
