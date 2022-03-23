import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomExceptionTest {

	@Test
	void testConstructor(){
		CustomException testObject = new CustomException();
		
		assertNotNull(testObject);
	}
	
	@Test
	void testOverloadedConstructor1(){
		
		CustomException testObject = new CustomException("message");
		
		assertNotNull(testObject);
	}
	
	@Test
	void testOverloadedConstructor2(){
		
		CustomException testObject = new CustomException("message","reason");
		
		assertNotNull(testObject);
	}
	
	@Test
	void testGetMessagePass(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "message";
		

		assertEquals(testCase,testObject.getMessage());	
	}
	
	@Test
	void testGetMessageFail(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "egassne";
		

		assertNotEquals(testCase,testObject.getMessage());	
	}
	
	@Test
	void testSetMessagePass(){
		
		CustomException testObject = new CustomException();
		
		testObject.setMessage("message");
		String testCase = "message";

		assertEquals(testCase,testObject.getMessage());	
	}
	
	@Test
	void testSetMessageFail(){
		
		CustomException testObject = new CustomException();
		
		testObject.setMessage("message");
		String testCase = "egassne";
		

		assertNotEquals(testCase,testObject.getMessage());	
	}
	
	@Test
	void testToStringMessagePass(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "message";
		

		assertEquals(testCase,testObject.toStringMessage());	
	}
	
	@Test
	void testToStringMessageFail(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "egassne";
		

		assertNotEquals(testCase,testObject.toStringMessage());	
	}
	
	@Test
	void testToStringMessageSame(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "message";
		

		assertSame(testCase,testObject.toStringMessage());	
	}
	
	void testToStringMessageNotSame(){
		
		CustomException testObject = new CustomException("message","reason");
		
		int testCase = 1;
		

		assertNotSame(testCase,testObject.toStringMessage());	
	}
	
	@Test
	void testGetReasonPass(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "reason";
		

		assertEquals(testCase,testObject.getReason());	
	}
	
	@Test
	void testGetReasonFail(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "nosaer";
		

		assertNotEquals(testCase,testObject.getReason());	
	}
	
	@Test
	void testSetReasonPass(){
		
		CustomException testObject = new CustomException();
		
		testObject.setReason("reason");
		String testCase = "reason";

		assertEquals(testCase,testObject.getReason());	
	}
	
	@Test
	void testSetReasonFail(){
		
		CustomException testObject = new CustomException();
		
		testObject.setReason("reason");
		String testCase = "nosaer";
		

		assertNotEquals(testCase,testObject.getReason());	
	}
	
	@Test
	void testToStringReasonPass(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "reason";
		

		assertEquals(testCase,testObject.toStringReason());	
	}
	
	@Test
	void testToStringReasonFail(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "nosaer";
		

		assertNotEquals(testCase,testObject.toStringReason());	
	}
	
	@Test
	void testToStringReasonSame(){
		
		CustomException testObject = new CustomException("message","reason");
		
		String testCase = "reason";
		

		assertSame(testCase,testObject.toStringReason());	
	}
	
	void testToStringReasonNotSame(){
		
		CustomException testObject = new CustomException("message","reason");
		
		int testCase = 1;
		

		assertNotSame(testCase,testObject.toStringReason());	
	}
	
}
