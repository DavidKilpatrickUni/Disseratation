import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountApplicationTest {
	

	@Test
	void checkThrowValidFirstnameBlank() {

	
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidFirstname(""));

		String expectedMessage = "Valid First Name Input Required";
		String expectedReason = "firstname";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}
	
	// = sign
	@Test
	void checkThrowValidFirstnameInjection1() {

		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidFirstname("firstname="));

		String expectedMessage = "Valid First Name Input Required";
		String expectedReason = "firstname";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}

	// ' sign
		
	@Test
	void checkThrowValidFirstnameInjection2() {
		
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidFirstname("firstname'"));

		String expectedMessage = "Valid First Name Input Required";
		String expectedReason = "firstname";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	
	
	@Test
	void checkThrowValidSurnameBlank() {

	
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidSurname(""));

		String expectedMessage = "Valid Surname Input Required";
		String expectedReason = "surname";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}
	
	// = sign
	@Test
	void checkThrowValidSurnameInjection1() {

		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidSurname("surname="));

		String expectedMessage = "Valid Surname Input Required";
		String expectedReason = "surname";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}

	// ' sign
		
	@Test
	void checkThrowValidSurnameInjection2() {
		
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidSurname("surname'"));

		String expectedMessage = "Valid Surname Input Required";
		String expectedReason = "surname";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	
	@Test
	void checkThrowValidPasswordBlank() {

	
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidPassword(""));

		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}
	
	// = sign
	@Test
	void checkThrowValidPasswordInjection1() {

		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidPassword("A123456!="));

		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}

	// ' sign
		
	@Test
	void checkThrowValidPasswordInjection2() {
		
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidPassword("A123456!'"));

		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	
	// too short
	
	@Test
	void checkThrowValidPasswordRegex1() {
		
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidPassword("A12345!"));

		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	// too long
	
	@Test
	void checkThrowValidPasswordRegex2() {
		
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidPassword("A123dsfjkbweifiwefiwebfk456!"));

		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	// No Capital
	
	@Test
	void checkThrowValidPasswordRegex3() {
			
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidPassword("a123456!"));

		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}
	
	// No number
	
	@Test
	void checkThrowValidPasswordRegex4() {
			
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidPassword("ASDFGHJK!"));

		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}	
	
	// No Special character
	
	@Test
	void checkThrowValidPasswordRegex5() {
			
		CustomException thrown = assertThrows(CustomException.class, () -> AccountDetailsApplication.checkValidPassword("A1234567"));

		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}	
	
	@Test
	void testCheckFirstName() throws CustomException{
		
		String testFirstname= "firstname";
		
		AccountDetailsApplication.checkValidFirstname(testFirstname);
		
	}
	
	@Test
	void testCheckSurame() throws CustomException{
		
		String testSurname= "surname";
		
		AccountDetailsApplication.checkValidSurname(testSurname);
		
	}
	
	@Test
	void testCheckPassword() throws CustomException{
		
		String testPassword= "A123456!";
		
		AccountDetailsApplication.checkValidPassword(testPassword);
		
	}

}
