package TestCase_Assert_Result_TestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class TestRunner3_ {
	 public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(TestJunit3_.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }
}
