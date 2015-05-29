package ignoreTest_;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

//to ignore all test cases at class level
//@Ignore
public class TestJunit 
{
	String message = "Robert";	
	MessageUtil messageUtil = new MessageUtil(message);

	//to ignore the method level
	@Ignore
	@Test
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		//message = "Robert";
		//assertEquals(message,messageUtil.printMessage());
		System
	}


	@Test
	public void testgreetingMessage() {
		System.out.println("Inside testgreetingMessage()");
		message = "Hi!" + "Robert";
		assertEquals(message,messageUtil.greetingMessage());
	}
}
