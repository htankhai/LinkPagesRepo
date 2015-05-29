package org.JUnit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUnit1 {

	WebDriver driver = new FirefoxDriver();

	
	@Before
	public void beforetest() {
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	}

	
	@After
	public void aftertest() {
		driver.quit();

	}

	@Test
	public void test() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Bike']")).click();
		boolean str1 = driver.findElement(By.xpath("//input[@value='Bike']")).isSelected();
		if(str1 = true) {
			System.out.print("Checkbox is checked");
		}
		else
		{
			System.out.print("Checkbox is not checked");
		}

	}
}
