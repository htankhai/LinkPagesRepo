package TestSuite_RunWith_Suite_;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test 
@RunWith(Suite.class) 
@Suite.SuiteClasses({
	TestJunit2.class ,	TestJunit1.class }) 
public class JunitTestSuite {

}

