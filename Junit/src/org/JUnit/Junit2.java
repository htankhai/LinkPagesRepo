package org.JUnit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Junit2 {
	private static WebDriver driver;
	
	@Before
	public void openbrowser2() {
		System.out.print("\nBrowser open");
		driver = new FirefoxDriver(); 
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	}

	@After
	public void closebrowser2() {
		System.out.print("\nBrowser close");
		driver.quit();
	}

	@Test
	public void test1() throws InterruptedException{  
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test1");
		System.out.print("\njunittest2 class-test1 method is executed");
		Thread.sleep(2000);
	}

	@Test
	public void test2() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='fname']")).clear();
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test2");
		Thread.sleep(2000);
		System.out.print("\njunittest2 class-test2 method is executed");
	}


}
//Console Output :
/*Browser open
junittest2 class-test1 method is executed
Browser close
Browser open
junittest2 class-test2 method is executed
Browser close*/


//replace @Before annotation with @BeforeClass and @After annotation with @AfterClass 
/*@BeforeClass
public static void openbrowser() {
 System.out.print("\nBrowser open");
 driver = new FirefoxDriver(); 
 driver.manage().window().maximize();
 driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
}

@AfterClass
public static void closebrowser() {
 System.out.print("\nBrowser close");
 driver.quit();
}*/

/*Console Output :
Browser open
junittest2 class-test1 method is executed
junittest2 class-test2 method is executed
Browser close*/