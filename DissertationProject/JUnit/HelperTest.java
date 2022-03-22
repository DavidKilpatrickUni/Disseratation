import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;

class HelperTest {

	

	@Test
	void testCheckBlankTrue1(){
		
		String testString = "";
		
		assertTrue(Helper.checkBlank(testString));
		
	}
	

	@Test
	void testCheckBlankTrue2(){
		
		String testString = "     ";
		
		assertTrue(Helper.checkBlank(testString));
		
	}
	

	@Test
	void testCheckBlankFalse1(){
		
		String testString = "not blank";
		
		assertFalse(Helper.checkBlank(testString));
		
	}

	
	@Test
	void testCheckBlankFalse2(){
		
		String testString = "    not blank    ";
		
		assertFalse(Helper.checkBlank(testString));
		
	}
	

	
	@Test
	void testCheckBlankDateTrue(){
		
		Date date = new Date();
		date = null;
		
		assertTrue(Helper.checkBlankDate(date));
		
	}
	
	
	
	@Test
	void testCheckBlankDateFalse(){
		
		Date date = new Date();
		
		assertFalse(Helper.checkBlankDate(date));
		
	}
	
	@Test
	void testCheckBlankNotNull(){
		
		Date date = new Date();
		
		assertNotNull(Helper.checkBlankDate(date));
		
	}
	
	@Test
	void testProperCasePass1(){
		
		String testCase = "Case";
		String testObject = Helper.properCase("case");
		
		assertEquals(testCase,testObject);
			
	}
	
	@Test
	void testProperCaseFail1(){
		
		String testCase = "case";
		String testObject = Helper.properCase("case");
		
		assertNotEquals(testCase,testObject);
			
	}
	//border
	@Test
	void testCheckLenthPass1(){
		
		String testCase = "12345678";
		
		assertTrue(Helper.checkLength(testCase));
			
	}
	//normal
	@Test
	void testCheckLenthPass2(){
		
		String testCase = "123456789";
		
		assertTrue(Helper.checkLength(testCase));
			
	}
	//normal
	@Test
	void testCheckLenthPass3(){
		
		String testCase = "    123456789   ";
		
		assertTrue(Helper.checkLength(testCase));
			
	}
	//extreme
	@Test
	void testCheckLenthPass4(){
		
		String testCase = "1234567283572365827365782";
		
		assertTrue(Helper.checkLength(testCase));
			
	}
	
	@Test
	void testCheckLenthFail1(){
		
		String testCase = "1234567";
		
		assertFalse(Helper.checkLength(testCase));
			
	}
	
	@Test
	void testCheckLenthFail2(){
		
		String testCase = "   1234567  ";
		
		assertFalse(Helper.checkLength(testCase));
			
	}
	
	@Test
	void testChangeLocalDateFormatPass(){
		
		String testCase = "2022-03-21";
		LocalDate testObject = LocalDate.now();
		
		assertEquals(Helper.changeLocalDateFormat(testObject), testCase);
			
	}
	
	void testChangeLocalDateFormatFail(){
		
		String testCase = "2022-03-20";
		LocalDate testObject = LocalDate.now();
		
		assertNotEquals(Helper.changeLocalDateFormat(testObject), testCase);
			
	}
	
	@Test
	void testDateForDatabasePass(){
		
		String testCase = "20220321";
		String testObject = "2022-03-21";
		
		assertEquals(Helper.dateForDatabase(testObject), testCase);
			
	}
	
	@Test
	void testDateForDatabaseFail(){
		
		String testCase = "2022-03-21";
		String testObject = "2022-03-21";
		
		assertNotEquals(Helper.dateForDatabase(testObject), testCase);
			
	}
	
	//banned character '
	@Test
	void testRegexSQLInjectionTrue1(){
		
		String testCase = "test'";
	
		
		assertTrue(Helper.regexSQLInjection(testCase));
			
	}

	//banned character =
	@Test
	void testRegexSQLInjectionTrue2(){
		
		String testCase = "test=";
	
		
		assertTrue(Helper.regexSQLInjection(testCase));
			
	}
	
	@Test
	void testRegexSQLInjectionFalse1(){
		
		String testCase = "test";
	
		
		assertFalse(Helper.regexSQLInjection(testCase));
			
	}
	
	// min 8
	@Test
	void testRegexPasswordTrue1(){
		
		String testCase = "A123456!";
	
		
		assertTrue(Helper.regexPassword(testCase));
			
	}

	// max 20
	@Test
	void testRegexPasswordTrue2(){
		
		String testCase = "A123456789123456789!";
	
		
		assertTrue(Helper.regexPassword(testCase));
			
	}
	
	@Test
	void testRegexPasswordTrue3(){
		
		String testCase = "A123456@";
	
		
		assertTrue(Helper.regexPassword(testCase));
			
	}

	@Test
	void testRegexPasswordTrue4(){
		
		String testCase = "A123456£";
	
		
		assertTrue(Helper.regexPassword(testCase));
			
	}
	
	// too short
	
	@Test
	void testRegexPasswordFalse1(){
		
		String testCase = "A12345!";
	
		
		assertFalse(Helper.regexPassword(testCase));
			
	}
	
	// No special character
	@Test
	void testRegexPasswordFalse2(){
		
		String testCase = "A1234567";
	
		assertFalse(Helper.regexPassword(testCase));
			
	}
	
	// No Capital letter
	@Test
	void testRegexPasswordFalse3(){
		
		String testCase = "1234567!";
		
		assertFalse(Helper.regexPassword(testCase));
			
	}
	
	// No Capital letter
	@Test
	void testRegexPasswordFalse4(){
			
		String testCase = "a1234567!";
			
		assertFalse(Helper.regexPassword(testCase));
				
	}
	
	// no number
	@Test
	void testRegexPasswordFalse5(){
			
		String testCase = "aDGHJSNWKE!";
			
		assertFalse(Helper.regexPassword(testCase));
				
	}
	
	// Too long
	@Test
	void testRegexPasswordFalse6(){
		
		String testCase = "12345FUVUVU*GAIGIGNJNIC^67!";
	
		
		assertFalse(Helper.regexPassword(testCase));
			
	}
	
	// Banned Character '
	@Test
	void testCheckPlaylistTitleTrue1(){
		
		String testCase = "Title'";
	
		
		assertTrue(Helper.checkPlaylistTitle(testCase));
			
	}
	
	// Banned Character =
	@Test
	void testCheckPlaylistTitleTrue2(){
		
		String testCase = "Title=";
	
		
		assertTrue(Helper.checkPlaylistTitle(testCase));
			
	}
	@Test
	void testCheckPlaylistTitleTrue3(){
		
		String testCase = "";
	
		
		assertTrue(Helper.checkPlaylistTitle(testCase));
			
	}
	
	
	@Test
	void testCheckPlaylistTitleFalse1(){
		
		String testCase = "Title";
	
		
		assertFalse(Helper.checkPlaylistTitle(testCase));
			
	}
	


}
