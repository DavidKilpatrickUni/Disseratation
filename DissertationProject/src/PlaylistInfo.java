
public class PlaylistInfo {

	private String currentPlaylistID;
	private String currentPlaylistTitle;
	
	public PlaylistInfo() {
		
	}

	public PlaylistInfo(String currentPlaylistID) {
		
		this.currentPlaylistID = currentPlaylistID;
	
	}

	public PlaylistInfo(String currentPlaylistID, String currentPlaylistTitle) {
	
		this.currentPlaylistID = currentPlaylistID;
		this.currentPlaylistTitle = currentPlaylistTitle;

	}
	
	public String getCurrentPlaylistID() {
	
		return currentPlaylistID;
	
	}

	public void setCurrentPlaylistID(String currentPlaylistID) {
	
		this.currentPlaylistID = currentPlaylistID;
	
	}


	public String getCurrentPlaylistTitle() {
	
		return currentPlaylistTitle;
	
	}

	public void setCurrentPlaylistTitle(String currentPlaylistTitle) {
	
		this.currentPlaylistTitle = currentPlaylistTitle;
	
	}
	
	
	
	
}
