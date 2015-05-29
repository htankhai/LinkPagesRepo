package parameterizedTest_;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

//1. Annotate test class with @RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest 
{
	private Integer inputNumber;
	private Boolean expectedResult;
	private PrimeNumberChecker primeNumberChecker;

	//2. Create a public static method annotated with @Parameters that returns
	//a Collection of Objects (as Array) as test data set.
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{ 2, true },
				{ 6, false },
				{ 19, true },
				{ 22, false },
				{ 23, true }
		});
	}

	//3. Create a public constructor that takes in what is equivalent to one "row"
	// of test data.
	//4. Create an instance variable for each "column" of test data.
	// Each parameter should be placed as an argument here
	// Every time runner triggers, it will pass the arguments
	// from parameters we defined in primeNumbers() method
	public PrimeNumberCheckerTest(Integer inputNumber, Boolean expectedResult) {
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}

	@Before
	public void initialize() {
		primeNumberChecker = new PrimeNumberChecker();
	}


	// This test will run 5 times since we have 5 parameters defined
	@Test
	public void testPrimeNumberChecker() {
		System.out.println("Parameterized Number is : " + inputNumber);
		assertEquals(expectedResult, 
				primeNumberChecker.validate(inputNumber));
	}
}

/*There are five steps to create Parameterized tests. 
 Annotate test class with @RunWith(Parameterized.class)
 Create a public static method annotated with @Parameters that returns a Collection 
of Objects (as Array) as test data set. 
 Create a public constructor that takes in what is equivalent to one "row" of test 
data. 
 Create an instance variable for each "column" of test data. 
 Create your tests case(s) using the instance variables as the source of the test data.
The test case will be invoked once per each row of data. */