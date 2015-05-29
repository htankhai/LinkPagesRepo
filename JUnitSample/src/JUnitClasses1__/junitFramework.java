package JUnitClasses1__;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class junitFramework {
	
	@BeforeClass
	public static void beforeClass1(){
		System.out.println("This is the first method will be executed ");
		System.out.println();
	}
	@Before
	public void beforeMethod1(){
		System.out.println("Execute Before method.....");
	}
	
	
	
	@Test
	public  void runMe() {
		System.out.println("Run me is Executed....");
	}
	
	@Test
	public  void ExecuteMe() {
		System.out.println("Execute me is Executed....");
	}
	
	
	@Test
	public  void ExecuteMeAgain() {
		System.out.println("ExecuteMeAgain is Executed....");
	}
	
	@After
	public void afterMethod(){
		System.out.println("Executes After Method..");
		System.out.println();
	}
	@Ignore
	public void ignoreMethod(){}
	
	
	@AfterClass
	public static void afterClass(){
		System.out.println("Last method will be exected...");
	}

}
