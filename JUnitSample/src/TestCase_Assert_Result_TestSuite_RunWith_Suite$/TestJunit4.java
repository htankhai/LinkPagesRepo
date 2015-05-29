package TestCase_Assert_Result_TestSuite_RunWith_Suite$;

import org.junit.Test; 
import static org.junit.Assert.assertEquals; 

public class TestJunit4 { 
	String message = "Hello World"; 
	MessageUtil messageUtil = new MessageUtil(message); 

	@Test 
	public void testPrintMessage() 
	{ message = "New Word"; 
	assertEquals(message,messageUtil.printMessage()); 
	}
}