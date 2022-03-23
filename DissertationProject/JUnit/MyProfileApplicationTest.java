import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyProfileApplicationTest {

	@Test
	void testThrowValidUsernameBlank() {
		

		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> MyProfileApplication.checkValidUsername("")
	    );

		String expectedMessage = "Valid Username Input Required";
		String expectedReason = "username";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);
	}
	
	
	// =sign
	@Test
	void testThrowValidUsernameInjection1() {
		

		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> MyProfileApplication.checkValidUsername("username=")
	    );

		String expectedMessage = "Valid Username Input Required";
		String expectedReason = "username";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);
	}
	
	// ' sign
	@Test
	void testThrowValidUsernameInjection2() {
		

		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> MyProfileApplication.checkValidUsername("username'")
	    );

		String expectedMessage = "Valid Username Input Required";
		String expectedReason = "username";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);
	}
	
	@Test
	void testMethod() throws CustomException {
		
		MyProfileApplication.checkValidUsername("username");

	}

}
