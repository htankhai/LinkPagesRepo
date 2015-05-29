package JUnitrunClasses_;
import org.junit.Test; 
import static org.junit.Assert.assertEquals; 
public class TestEmployeeDetails 
{ 
	EmpBusinessLogic empBusinessLogic =new EmpBusinessLogic(); 
	EmployeeDetails employee = new EmployeeDetails(); 

	// test to check yearly salary
	@Test 
	public void testCalculateYearlySalary() { 
		employee.setName("Htan Khai"); 
		employee.setAge(39); 
		employee.setMonthlySalary(8000); 
		double salary = empBusinessLogic.calculateYearlySalary(employee); 
		assertEquals(96000, salary, 0.0);
	}

	//test to check appraisal 
	@Test 
	public void testCalculateAppriasal() { 
		employee.setName("Aung"); 
		employee.setAge(35); 
		employee.setMonthlySalary(8000); 
		double appraisal= empBusinessLogic.calculateAppraisal(employee); 
		assertEquals(500, appraisal, 0.0); 
	} 


}

//public static void assertEquals(double expected, double actual,double delta)