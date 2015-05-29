package executionProcedure_;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
public class ExecutionProcedureJunit 
{
	private Collection<Object> collection;

	//execute only once, in the starting 
	@BeforeClass
	public static void beforeClass() {
		System.out.println("in before class");
	}

	//execute only once, in the end
	@AfterClass
	public static void  afterClass() {
		System.out.println("in after class");
	}

	//execute for each test, before executing test
	@Before
	public void before() {
		//Create Object
		collection = new ArrayList<>();
		System.out.println("in before");
	}

	//execute for each test, after executing test
	@After
	public void after() {
		System.out.println("in after");
	}

	//test case 1
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}

	//test case 2
	@Test
	public void testCase2() {
		System.out.println("in testCase2");
	}

	@Test
	public  void runMe() {
		System.out.println("runMe  method is Executed....");
	}

	@Test
	public  void ExecuteMe() {
		System.out.println("ExecuteMe method is Executed....");
	}


	@Test
	public  void ExecuteMeAgain() {
		System.out.println("ExecuteMeAgain method  is Executed....");
	}

	@Test
	public void testEmptyCollection() {
		assertTrue(collection.isEmpty());
		System.out.println("Pass testEmptyCollection method");
	}

	@Test
	public void testTwoItemsCollection() {
		collection.add("itemA");
		assertEquals(1, collection.size());
		collection.add("itemB");
		assertEquals(2,collection.size());
		System.out.println("True in testTwoItemCollection");
	}

	@Ignore
	public void ignoreMethod(){
		Sysm
	}

}

/*public class OutputTest {

    private File output;

    @Before
    public voidcreateOutputFile() {
       output = new File(...);
    }

    @After
    public voiddeleteOutputFile() {
       output.delete();
    }

    @Test
    public voidtestSomethingWithFile() {
        ...
    }
}*/
//A test fixture is a common set of test data and collaboratingobjects shared 
//by many tests. Generally they are implemented asinstance variables 
//in the test class.
