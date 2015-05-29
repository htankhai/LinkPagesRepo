package parameterizedTest_;
public class PrimeNumberChecker 
{//Create your tests case(s) using the instance variables as the source of the test data.
	public Boolean validate(final Integer primeNumber) {
	      for (int i = 2; i < (primeNumber / 2); i++) {
	         if (primeNumber % i == 0) {
	            return false;
	         }
	      }
	      return true;
	   }
}
