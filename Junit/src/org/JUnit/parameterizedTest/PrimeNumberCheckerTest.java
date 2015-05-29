package org.JUnit.parameterizedTest;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)//1
public class PrimeNumberCheckerTest {
   private Integer inputNumber;
   private Boolean expectedResult;
   private PrimeNumberChecker primeNumberChecker;

   //3.public constructor representing one row of the test data
//4. Create Instance variable inputNumber representing each column of the test data
   //row and column
    public PrimeNumberCheckerTest(Integer inputNumber, 
      Boolean expectedResult) {
      this.inputNumber = inputNumber;
      this.expectedResult = expectedResult;
   }
   
   @Before
   public void initialize() {
      primeNumberChecker = new PrimeNumberChecker();
   }

   //2. Create  public static method. return Object[] _ row and column
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
// 5.test case will run row of test data 5 times since we have 5 parameters defined
   //Get row and column arrray from public static method
   @Test
   public void testPrimeNumberChecker() {
      System.out.println("Parameterized Number is : " + inputNumber);
      assertEquals(expectedResult, 
      primeNumberChecker.validate(inputNumber));
   }
}

// Annotate test class with @RunWith(Parameterized.class) 
//Create a public static method annotated with @Parameters that returns a Collection of Objects (as Array) as test data set. 
// Create a public constructor that takes in what is equivalent to one "row" of test data. 
//Create an instance variable for each "column" of test data. 
//Create your tests case(s) using the instance variables as the source of the test data. 
