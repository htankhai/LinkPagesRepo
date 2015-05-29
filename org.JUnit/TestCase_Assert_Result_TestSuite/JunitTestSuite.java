package TestCase_Assert_Result_TestSuite;
import junit.framework.TestResult;
import junit.framework.TestSuite;
public class JunitTestSuite 
{
	public static void main(String[] a) 
	{
		// add the test's in the suite
		TestSuite suite = 
				new TestSuite(TestJunit1.class, TestJunit2.class, TestJunit3_.class );
		TestResult result = new TestResult();
		suite.run(result);
		System.out.println("Total number of test cases = " + result.runCount());
	}
}