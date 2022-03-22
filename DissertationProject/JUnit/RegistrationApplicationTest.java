import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class RegistrationApplicationTest {
	
	Date date = new Date();
	
	
	
	//RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date, "username", "test@email.com", "A123456!", "A123456!")

	
	
	@Test
	void testThrowFirstnameBlank() {
		
		date.setYear(200);
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("", "surname", "Male", date, "username", "test@email.com", "A123456!", "A123456!")
	    );

		String expectedMessage = "Valid First Name Input Required";
		String expectedReason = "firstname";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);
	}
	
	// ' sign
	@Test
	void testThrowFirstnameInjection1() {

		date.setYear(200);
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname'", "surname", "Male", date, "username", "test@email.com", "A123456!", "A123456!")
	    );

		String expectedMessage = "Valid First Name Input Required";
		String expectedReason = "firstname";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);

	}
	
	// = sign
	@Test
	void testThrowFirstnameInjection2() {

		date.setYear(200);
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname=", "surname'", "Male", date, "username", "test@email.com", "A123456!", "A123456!")
	    );

		String expectedMessage = "Valid First Name Input Required";
		String expectedReason = "firstname";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);

	}
	
	@Test
	void testThrowSurnameBlank() {
		
		date.setYear(200);
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "", "Male", date, "username", "test@email.com", "A123456!", "A123456!")
	    );

		String expectedMessage = "Valid Surname Input Required";
		String expectedReason = "surname";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);

	}
	
	// ' sign
	@Test
	void testThrowSurnameInjection1() {

		date.setYear(200);
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname=", "Male", date, "username", "test@email.com", "A123456!", "A123456!")
	    );

		String expectedMessage = "Valid Surname Input Required";
		String expectedReason = "surname";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);

	}
	
	// = sign
	@Test
	void testThrowSurnameInjection2() {

		date.setYear(200);
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname'", "Male", date, "username", "test@email.com", "A123456!", "A123456!")
	    );

		String expectedMessage = "Valid Surname Input Required";
		String expectedReason = "surname";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);

	}
	
	
	@Test
	void testThrowIdentity() {
		
		date.setYear(200);
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "", date, "username", "test@email.com", "A123456!", "A123456!")
	    );

		String expectedMessage = "Valid Identity Input Required";
		String expectedReason = "identity";
		
	    assertEquals(thrown.getMessage(), expectedMessage);
	    assertEquals(thrown.getReason(), expectedReason);

	}
	

	
	// compareDates true - Date after today
	@Test
	void testThrowDateCompareDates() {

		date.setYear(200);
		
		System.out.println(date);
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Date Input Required - New Users Must Be 16+";
		String expectedReason = "DOB";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}
	
	// age true - not 16 years old
	@Test
	void testThrowDateCheckAge() {

		date.setYear(110);
		
		System.out.println(date);
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Date Input Required - New Users Must Be 16+";
		String expectedReason = "DOB";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}
	
	// age true - null
	@Test
	void testThrowDateBlank() {

		date.setYear(100);
		
		System.out.println(date);
		
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", null , "username", "test@email.com", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Date Input Required - New Users Must Be 16+";
		String expectedReason = "DOB";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	}
	
	@Test
	void testThrowUsernameBlank() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "", "test@email.com", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Username Input Required";
		String expectedReason = "username";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	// = sign
	@Test
	void testThrowUsernameInjection1() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username=", "test@email.com", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Username Input Required";
		String expectedReason = "username";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	// ' sign
	@Test
	void testThrowUsernameInjection2() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username'", "test@email.com", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Username Input Required";
		String expectedReason = "username";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	@Test
	void testThrowEmailBlank() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Email Address Input Required - Requires @ AND .com OR .co.uk";
		String expectedReason = "email";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	// no @
	@Test
	void testThrowEmailRegex1() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "testemail.com", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Email Address Input Required - Requires @ AND .com OR .co.uk";
		String expectedReason = "email";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	// no .com or .co.uk
	@Test
	void testThrowEmailRegex2() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.co", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Email Address Input Required - Requires @ AND .com OR .co.uk";
		String expectedReason = "email";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	// = sign
	@Test
	void testThrowEmailInjection1() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com=", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Email Address Input Required - Requires @ AND .com OR .co.uk";
		String expectedReason = "email";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	// ' sign
	@Test
	void testThrowEmailInjection2() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	           CustomException.class,
	           () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com'", "A123456!", "A123456!")
	    );
		
		String expectedMessage = "Valid Email Address Input Required - Requires @ AND .com OR .co.uk";
		String expectedReason = "email";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
	
	}
	
	
	@Test
	void testThrowPasswordBlank() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	         CustomException.class,
	         () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "", "A123456!")
		);
		
		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}
	
	// too short
	@Test
	void testThrowPasswordRegex1() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	         CustomException.class,
	         () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A12345!", "A123456!")
		);
		
		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}
	
	// too long
	@Test
	void testThrowPasswordRegex2() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	         CustomException.class,
	         () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A12345978wye9fgh9fg2398g!", "A123456!")
		);
		
		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}
	
	// No special character
	@Test
	void testThrowPasswordRegex3() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
	         CustomException.class,
	         () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A1234567", "A123456!")
		);
		
		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
		
	}
	
	// No number
	@Test
	void testThrowPasswordRegex4() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
		     CustomException.class,
		      () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "ASDFGHJKHF!", "A123456!")
		);
			
		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
			
	}
	
	
	// No capital
	@Test
	void testThrowPasswordRegex5() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
		     CustomException.class,
		      () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "a123456!", "A123456!")
		);
			
		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
			
	}
	
	// ' sign
	@Test
	void testThrowPasswordInjection1() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
		     CustomException.class,
		      () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A123456!'", "A123456!")
		);
			
		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
			
	}
	
	// = sign
	@Test
	void testThrowPasswordInjection2() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
		     CustomException.class,
		      () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A123456!=", "A123456!")
		);
			
		String expectedMessage = "Valid Password Input Required - Must Be 8-15 Length AND Have 1 Capital Letter, 1 Legal Special Character , 1 Number";
		String expectedReason = "password";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
			
	}
	
	@Test
	void testThrowConfirmBlank() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
		     CustomException.class,
		      () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A123456!", "")
		);
			
		String expectedMessage = "Passwords Dont Match";
		String expectedReason = "confirm";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
			
	}
	// = sign
	@Test
	void testThrowConfirmInjection1() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
		     CustomException.class,
		      () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A123456!", "A123456!=")
		);
			
		String expectedMessage = "Passwords Dont Match";
		String expectedReason = "confirm";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
			
	}
	// ' sign
	@Test
	void testThrowConfirmInjection2() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
		     CustomException.class,
		      () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A123456!", "A123456!'")
		);
			
		String expectedMessage = "Passwords Dont Match";
		String expectedReason = "confirm";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
			
	}
	
	@Test
	void testThrowConfirmCompare() {

		date.setYear(100);;
		CustomException thrown = assertThrows(
		     CustomException.class,
		      () -> RegistrationApplication.checkRegistrationForm("firstname", "surname", "Male", date , "username", "test@email.com", "A123456!", "!654321A")
		);
			
		String expectedMessage = "Passwords Dont Match";
		String expectedReason = "confirm";

		assertEquals(thrown.getMessage(), expectedMessage);
		assertEquals(thrown.getReason(), expectedReason);
			
	}
	

	@Test
	void testComparePasswordTrue(){
		
		String testCase = "password";
		String testObject = "password";
		
		assertTrue(RegistrationApplication.comparePassword(testCase,testObject));
		
	}
	
	@Test
	void testComparePasswordFalse(){
		
		String testCase = "password";
		String testObject = "drowssap";
		
		assertFalse(RegistrationApplication.comparePassword(testCase,testObject));
		
	}
	
	@Test
	void testRegexEmailTrue1(){
		
		String testCase = "test@email.com";
		
		assertTrue(RegistrationApplication.regexEmail(testCase));
		
	}
	
	@Test
	void testRegexEmailTrue2(){
		
		String testCase = "test@email.co.uk";
		
		assertTrue(RegistrationApplication.regexEmail(testCase));
		
	}
	
	
	@Test
	void testRegexEmailFalse1(){
		
		String testCase = "test@email.co";
		
		assertFalse(RegistrationApplication.regexEmail(testCase));
		
	}
	
	@Test
	void testRegexEmailFalse2(){
		
		String testCase = "testemail.com";
		
		assertFalse(RegistrationApplication.regexEmail(testCase));
		
	}
	
	@Test
	void testcheckIdentityTrue1(){
		
		String testCase = "Male";
		
		assertTrue(RegistrationApplication.checkIdentity(testCase));
		
	}
	
	@Test
	void testcheckIdentityTrue2(){
		
		String testCase = "Female";
		
		assertTrue(RegistrationApplication.checkIdentity(testCase));
		
	}
	
	@Test
	void testcheckIdentityTrue3(){
		
		String testCase = "Non-binary";
		
		assertTrue(RegistrationApplication.checkIdentity(testCase));
		
	}
	
	@Test
	void testcheckIdentityFalse1(){
		
		String testCase = "male";
		
		assertFalse(RegistrationApplication.checkIdentity(testCase));
		
	}
	
	@Test
	void testcheckIdentityFalse2(){
		
		String testCase = "female";
		
		assertFalse(RegistrationApplication.checkIdentity(testCase));
		
	}
	
	@Test
	void testcheckIdentityFalse3(){
		
		String testCase = "non-binary";
		
		assertFalse(RegistrationApplication.checkIdentity(testCase));
		
	}
	
	@Test
	void testcheckIdentityFalse4(){
		
		String testCase = "";
		
		assertFalse(RegistrationApplication.checkIdentity(testCase));
		
	}
	// future date - 2100
	@Test
	void testcheckAgeTrue1(){
		
		date.setYear(200);
		
		System.out.println(date);
		
		Date testCase = date;
		
		assertTrue(RegistrationApplication.checkAge(testCase));
		
	}
	
	// too young - 2007
	@Test
	void testcheckAgeTrue2(){
		
		date.setYear(107);
		
		System.out.println(date);
		
		Date testCase = date;
		
		assertTrue(RegistrationApplication.checkAge(testCase));
		
	}
	
	// old enough - 2006
	@Test
	void testcheckAgeFalse1(){
		
		date.setYear(106);
		
		System.out.println(date);
		
		Date testCase = date;
		
		assertFalse(RegistrationApplication.checkAge(testCase));
		
	}
	
	// old enough - 1902
	@Test
	void testcheckAgeFalse2(){
			
		date.setYear(2);
			
		System.out.println(date);
			
		Date testCase = date;
			
		assertFalse(RegistrationApplication.checkAge(testCase));
			
	}
	
		

}
