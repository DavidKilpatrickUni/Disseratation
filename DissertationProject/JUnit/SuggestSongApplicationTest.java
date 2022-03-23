import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class SuggestSongApplicationTest {

	Date date = new Date();

	// ("title", "artist", "genre", 2, 2, date, "album", "songInfo", 1)

	
	@Test
	void testMethod() throws CustomException {

		date.setYear(100);
		String method =   SuggestSongApplication.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "album", "songInfo", 1);

		String expectedMessage = "continue";
		

		assertEquals(method, expectedMessage);
	
	}
	
	@Test
	void testThrowTitleBlank() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("", "artist", "genre", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Title Input Required";
		String expectedReason = "title";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// = sign
	@Test
	void testThrowTitleInjection1() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title=", "artist", "genre", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Title Input Required";
		String expectedReason = "title";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// ' sign
	@Test
	void testThrowTitleInjection2() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title'", "artist", "genre", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Title Input Required";
		String expectedReason = "title";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowArtistBlank() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "", "genre", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Artist Input Required";
		String expectedReason = "artist";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// = sign
	@Test
	void testThrowArtistInjection1() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist=", "genre", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Artist Input Required";
		String expectedReason = "artist";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// ' sign
	@Test
	void testThrowArtistInjection2() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist'", "genre", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Artist Input Required";
		String expectedReason = "artist";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowGenreBlank() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Genre Input Required";
		String expectedReason = "genre";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// = sign
	@Test
	void testThrowGenreInjection1() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre=", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Genre Input Required";
		String expectedReason = "genre";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// ' sign
	@Test
	void testThrowGenreInjection2() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre'", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Genre Input Required";
		String expectedReason = "genre";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowSongLength1() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 0, 0, date, "album", "songInfo", 1));

		String expectedMessage = "Valid SongLength Input Required";
		String expectedReason = "songLength";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowSongLength2() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 0, 1, date, "album", "songInfo", 1));

		String expectedMessage = "Valid SongLength Input Required";
		String expectedReason = "songLength";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowSongLength3() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 1, 0, date, "album", "songInfo", 1));

		String expectedMessage = "Valid SongLength Input Required";
		String expectedReason = "songLength";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowSongLength4() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 1, 1, date, "album", "songInfo", 1));

		String expectedMessage = "Valid SongLength Input Required";
		String expectedReason = "songLength";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowSongLength5() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 0, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid SongLength Input Required";
		String expectedReason = "songLength";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowSongLength6() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 0, date, "album", "songInfo", 1));

		String expectedMessage = "Valid SongLength Input Required";
		String expectedReason = "songLength";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowReleasedBlank() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, null, "album", "songInfo", 1));

		String expectedMessage = "Valid Release Date Input Required";
		String expectedReason = "released";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// date after today
	@Test
	void testThrowReleasedCompare() {

		date.setYear(200);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "album", "songInfo", 1));

		String expectedMessage = "Valid Release Date Input Required";
		String expectedReason = "released";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowAlbumBlank() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "", "songInfo", 1));

		String expectedMessage = "Valid Album Input Required";
		String expectedReason = "album";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// = sign
	@Test
	void testThrowAlbumInjection1() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "album=", "songInfo", 1));

		String expectedMessage = "Valid Album Input Required";
		String expectedReason = "album";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// ' sign
	@Test
	void testThrowAlbumInjection2() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "album'", "songInfo", 1));

		String expectedMessage = "Valid Album Input Required";
		String expectedReason = "album";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowSongInfoBlank() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "album", "", 1));

		String expectedMessage = "Valid SongInfo Input Required";
		String expectedReason = "songInfo";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// = sign
	@Test
	void testThrowSongInfoInjection1() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "album", "songInfo=", 1));

		String expectedMessage = "Valid SongInfo Input Required";
		String expectedReason = "songInfo";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// ' sign
	@Test
	void testThrowSongInfoInjection2() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "album", "songInfo'", 1));

		String expectedMessage = "Valid SongInfo Input Required";
		String expectedReason = "songInfo";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testThrowRating() {

		date.setYear(100);
		CustomException thrown = assertThrows(CustomException.class, () -> SuggestSongApplication
				.checkSuggestionForm("title", "artist", "genre", 2, 2, date, "album", "songInfo", 0));

		String expectedMessage = "Valid Rating Input Required - Rating Between 1 And 5";
		String expectedReason = "rating";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	@Test
	void testCheckSongLengthTrue1() {

		int testMin = 0;
		int testSec = 0;

		assertTrue(SuggestSongApplication.checkSongLength(testMin, testSec));

	}

	@Test
	void testCheckSongLengthTrue2() {

		int testMin = 0;
		int testSec = 1;

		assertTrue(SuggestSongApplication.checkSongLength(testMin, testSec));

	}

	@Test
	void testCheckSongLengthTrue3() {

		int testMin = 1;
		int testSec = 0;

		assertTrue(SuggestSongApplication.checkSongLength(testMin, testSec));

	}

	@Test
	void testCheckSongLengthTrue4() {

		int testMin = 1;
		int testSec = 1;

		assertTrue(SuggestSongApplication.checkSongLength(testMin, testSec));

	}

	@Test
	void testCheckSongLengthTrue5() {

		int testMin = 2;
		int testSec = 0;

		assertTrue(SuggestSongApplication.checkSongLength(testMin, testSec));

	}

	@Test
	void testCheckSongLengthTrue6() {

		int testMin = 0;
		int testSec = 2;

		assertTrue(SuggestSongApplication.checkSongLength(testMin, testSec));

	}

	@Test
	void testCheckSongLengthFalse1() {

		int testMin = 2;
		int testSec = 2;

		assertFalse(SuggestSongApplication.checkSongLength(testMin, testSec));

	}

	@Test
	void testCheckSongLengthFalse2() {

		int testMin = 1;
		int testSec = 2;

		assertFalse(SuggestSongApplication.checkSongLength(testMin, testSec));

	}

	@Test
	void testCheckSongLengthFalse3() {

		int testMin = 2;
		int testSec = 1;

		assertFalse(SuggestSongApplication.checkSongLength(testMin, testSec));

	}
	
	@Test
	void testCheckRatingTrue() {

		int testRating = 0;
	

		assertTrue(SuggestSongApplication.checkRating(testRating));

	}
	
	@Test
	void testCheckRatingFalse1() {

		int testRating = 1;
	

		assertFalse(SuggestSongApplication.checkRating(testRating));

	}

	@Test
	void testCheckRatingFalse2() {
		
		int testRating = 5;
	

		assertFalse(SuggestSongApplication.checkRating(testRating));

	}
	

}
