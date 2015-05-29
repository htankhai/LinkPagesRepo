package ResultAssert_;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
public class TestJunit {
  String message = "Hello World";	
   MessageUtil messageUtil = new MessageUtil(message);

   @Test
   public void testPrintMessage() {
      assertEquals(message,messageUtil.printMessage());
         }
      
         
        /*@Test
      public void testAnotherPrintMessage() {
         message = "New Word";
         assertEquals(message,messageUtil.printMessage());
      }*/
        
           
}