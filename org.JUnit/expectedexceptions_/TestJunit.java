package expectedexceptions_;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
public class TestJunit 
{
	String message = "Robert";	
	MessageUtil messageUtil = new MessageUtil(message);

	@Test(expected = ArithmeticException.class)
	public void testPrintMessage() {	
		System.out.println("Inside testPrintMessage()");     
		messageUtil.printMessage();     
	}

	@Test
	public void greetingMessage() {
		System.out.println("Inside greetingMessage()");
		message = "Hi!" + "Robert";
		assertEquals(message,messageUtil.greetingMessage());
	}
}
