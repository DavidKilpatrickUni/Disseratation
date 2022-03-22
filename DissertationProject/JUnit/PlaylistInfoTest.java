import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlaylistInfoTest {

	@Test
	void testConstructor(){
		PlaylistInfo testObject = new PlaylistInfo();
		
		assertNotNull(testObject);
	}
	
	@Test
	void testOverloadedConstructor1(){
		
		PlaylistInfo testObject = new PlaylistInfo("1");
		
		assertNotNull(testObject);
	}
	
	@Test
	void testOverloadedConstructor2(){
		
		PlaylistInfo testObject = new PlaylistInfo("1","playlistTitle");
		
		assertNotNull(testObject);
	}

	@Test
	void testGetIDPass(){
		
		PlaylistInfo testObject = new PlaylistInfo("1", "playlistTitle");
		
		String testCase = "1";
		

		assertEquals(testCase,testObject.getCurrentPlaylistID());	
	}
	
	@Test
	void testGetIDFail(){
		
		PlaylistInfo testObject = new PlaylistInfo("1", "playlistTitle");
		
		String testCase = "2";
		

		assertNotEquals(testCase,testObject.getCurrentPlaylistID());	
	}
	
	@Test
	void testSetIDPass(){
		
		PlaylistInfo testObject = new PlaylistInfo();
		
		testObject.setCurrentPlaylistID("1");
		testObject.setCurrentPlaylistTitle("playlistTitle");
		
		String testCase = "1";

		assertEquals(testCase,testObject.getCurrentPlaylistID());	
	}
	
	@Test
	void testSetIDFail(){
		
		PlaylistInfo testObject = new PlaylistInfo();
		
		testObject.setCurrentPlaylistID("1");
		testObject.setCurrentPlaylistTitle("playlistTitle");
		
		String testCase = "2";

		assertNotEquals(testCase,testObject.getCurrentPlaylistID());	
	}
	
	@Test
	void testGetTitlePass(){
		
		PlaylistInfo testObject = new PlaylistInfo("1", "playlistTitle");
		
		String testCase = "playlistTitle";
		

		assertEquals(testCase,testObject.getCurrentPlaylistTitle());	
	}
	
	@Test
	void testGetTitleFail(){
		
		PlaylistInfo testObject = new PlaylistInfo("1", "playlistTitle");
		
		String testCase = "wrongTitle";
		

		assertNotEquals(testCase,testObject.getCurrentPlaylistTitle());	
	}
	
	
	@Test
	void testSetTitlePass(){
		
		PlaylistInfo testObject = new PlaylistInfo();
		
		testObject.setCurrentPlaylistID("1");
		testObject.setCurrentPlaylistTitle("playlistTitle");
		
		String testCase = "playlistTitle";

		assertEquals(testCase,testObject.getCurrentPlaylistTitle());	
	}
	
	@Test
	void testSetTitleFail(){
		
		PlaylistInfo testObject = new PlaylistInfo();
		
		testObject.setCurrentPlaylistID("1");
		testObject.setCurrentPlaylistTitle("playlistTitle");
		
		String testCase = "wrongTitle";

		assertNotEquals(testCase,testObject.getCurrentPlaylistTitle());	
	}
	
	
	
}
