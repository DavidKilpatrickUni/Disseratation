import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailServicesTest {

	@Test
	void test1() {
		
		String testObject = EmailServices.randomConfirmCode();
		
		assertNotNull(testObject);
	}
	


}
