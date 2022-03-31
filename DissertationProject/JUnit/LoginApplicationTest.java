import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginApplicationTest {


	
	
	@Test
	void testThrowEnterLoginUserBlank() {
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> LoginApplication.enterLogin("", "passwords")
	    );

		String expectedMessage = "Enter Valid Details To Attempt Login";
		System.out.println(thrown.getMessage());
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	  
	}
	
	@Test
	void testThrowEnterLoginUserInjection1() {
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> LoginApplication.enterLogin("username=", "passwords")
	    );

		String expectedMessage = "Enter Valid Details To Attempt Login";
		System.out.println(thrown.getMessage());
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	  
	}
	
	@Test
	void testThrowEnterLoginUserInjection2() {
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> LoginApplication.enterLogin("username-", "passwords")
	    );

		String expectedMessage = "Enter Valid Details To Attempt Login";
		System.out.println(thrown.getMessage());
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	  
	}
	
	@Test
	void testThrowEnterLoginPasswordBlank() {
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> LoginApplication.enterLogin("username", "")
	    );

		String expectedMessage = "Enter Valid Details To Attempt Login";
		System.out.println(thrown.getMessage());
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	  
	}
	
	@Test
	void testThrowEnterLoginPasswordInjection1() {
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> LoginApplication.enterLogin("username", "passwords=")
	    );

		String expectedMessage = "Enter Valid Details To Attempt Login";
		System.out.println(thrown.getMessage());
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	  
	}
	
	@Test
	void testThrowEnterLoginPasswordInjection2() {
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> LoginApplication.enterLogin("username", "passwords'")
	    );

		String expectedMessage = "Enter Valid Details To Attempt Login";
		System.out.println(thrown.getMessage());
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	  
	}
	
	@Test
	void testThrowEnterLoginInvalid() {
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> LoginApplication.enterLogin("username", "password")
	    );

		String expectedMessage = "Enter Valid Details To Attempt Login";
		System.out.println(thrown.getMessage());
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	  
	}
	
	@Test
	void testCheckFieldsTrue() throws CustomException{
		
		String testUsername = "username";
		String testPassword= "password";
		
		assertTrue(LoginApplication.checkFields(testUsername , testPassword));
		
	}
	

	
	
}
