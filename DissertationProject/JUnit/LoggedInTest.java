import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoggedInTest {

	@Test
	void testConstructor(){
		
		LoggedIn testObject = new LoggedIn();
		
		assertNotNull(testObject);
	}
	
	@Test
	void testOverloadedConstructor(){
		
		LoggedIn testObject = new LoggedIn("1", "testName");
		
		assertNotNull(testObject);
	}

	@Test
	void testGetIDPass(){
		
		LoggedIn testObject = new LoggedIn("1", "testName");
		
		String testCase = "1";
		

		assertEquals(testCase,testObject.getCurrentUserID());	
	}
	
	@Test
	void testGetIDFail(){
		
		LoggedIn testObject = new LoggedIn("1", "testName");
		
		String testCase = "2";
		

		assertNotEquals(testCase,testObject.getCurrentUserID());	
	}
	
	@Test
	void testSetIDPass(){
		
		LoggedIn testObject = new LoggedIn();
		
		testObject.setCurrentUserID("1");
		testObject.setCurrentUserName("testName");
		
		String testCase = "1";

		assertEquals(testCase,testObject.getCurrentUserID());	
	}
	
	@Test
	void testSetIDFail(){
		
		LoggedIn testObject = new LoggedIn();
		
		testObject.setCurrentUserID("1");
		testObject.setCurrentUserName("testName");
		
		String testCase = "2";

		assertNotEquals(testCase,testObject.getCurrentUserID());	
	}
	
	@Test
	void testGetUserNamePass(){
		
		LoggedIn testObject = new LoggedIn("1", "testName");
		
		String testCase = "testName";
		

		assertEquals(testCase,testObject.getCurrentUserName());	
	}
	
	@Test
	void testGetUserNameFail(){
		
		LoggedIn testObject = new LoggedIn("1", "testName");
		
		String testCase = "wrongName";
		

		assertNotEquals(testCase,testObject.getCurrentUserName());	
	}
	
	@Test
	void testSetUserNamePass(){
		
		LoggedIn testObject = new LoggedIn();
		
		testObject.setCurrentUserID("1");
		testObject.setCurrentUserName("testName");
		
		String testCase = "testName";

		assertEquals(testCase,testObject.getCurrentUserName());	
	}
	
	@Test
	void testSetUserNameFail(){
		
		LoggedIn testObject = new LoggedIn();
		
		testObject.setCurrentUserID("1");
		testObject.setCurrentUserName("testName");
		
		String testCase = "2";

		assertNotEquals(testCase,testObject.getCurrentUserName());	
	}

}
