import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyEncryptionTest {

	@Test
	void getEncryptionKey1() {
		
		String testObject = MyEncryption.getEncryptionKey();

		String testCase = "encrypt";
		
		assertEquals(testCase,testObject);
		
	}
	
	@Test
	void getEncryptionKey2() {
		
		String testObject = MyEncryption.getEncryptionKey();

		
		
		assertNotNull(testObject);
		
	}

}
