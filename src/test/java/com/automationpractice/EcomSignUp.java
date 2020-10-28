package com.automationpractice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

		public class EcomSignUp {

			 public String gridURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
			 boolean status = false;
					  	  
		//Setting up capabilities to run our test script
					 
		 WebDriver driver;
		 		 
		 public WebDriver getDriver()
			{
				System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/com/browserDrivers/chromedriver.exe");
				driver = new ChromeDriver();				
				driver.manage().window().maximize();
				driver.get(gridURL);
				return driver;
			}
		 
		 public void waitForPageLoaded() {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 }
			@BeforeMethod
			public void launch() throws IOException,InterruptedException{	
			driver= getDriver();
				
				  //Click on Sign in
				  driver.findElement(By.linkText("Sign in")).click();
				  
				  //Enter email address
				  driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("Shal@test12.com");
				  
				  //Click on "Create an account"
				  driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
			 			}
		 
		 //Verifying elements on Registration page
			
		  @Test
		  public void verifyElemntsOnPageTest()
		  {
		      waitForPageLoaded();
		      
		      //WebElement title = driver.findElement(By.xpath("//input[@id=\"id_gender1\"]"));
		      //title.isDisplayed();
		     
		      WebElement custfirstname = driver.findElement(By.name("customer_firstname"));
		      custfirstname.isDisplayed();
		      
		      WebElement custlastname = driver.findElement(By.name("customer_lastname"));
		      custlastname.isDisplayed();

		    //Enter your name and password
		      driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
		      driver.findElement(By.name("customer_firstname")).sendKeys("Test User"); 
		      driver.findElement(By.name("customer_lastname")).sendKeys("Vsoft");
		      driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");
		      		  
		     //Enter your address
		      driver.findElement(By.id("firstname")).sendKeys("Test User");
		      driver.findElement(By.id("lastname")).sendKeys("Vsoft");
		      driver.findElement(By.id("company")).sendKeys("Vsoft");
		      driver.findElement(By.id("address1")).sendKeys("Test 81/1,2nd cross");
		      driver.findElement(By.id("city")).sendKeys("XYZ");
		      
		     //Register without entering phone number
			  WebElement register = driver.findElement(By.id("submitAccount"));
			  register.click();

			  String expectedErrorMsg = "You must register at least one phone number.";
			  
			  waitForPageLoaded();
			  
			  WebElement exp1 = driver.findElement(By.xpath("//p[contains(text(),'at least one phone number')]"));
			  String actualErrorMsg = exp1.getText();

			  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
			  
			  waitForPageLoaded();
			  driver.close();
		 }
		//Few test scenarios as below
		// Verifying redirection to the terms and conditions page
		// Verifying Privacy policy page redirection
		// Verifying redirection to the Login page from Registration page
		// Verifying redirection to the landing page
		// Registration with all valid data
		// Registration without providing Company Name field
		// Registration without providing Name field
		// Registration without providing user email field
		// Registration with email id which already have account
		// Registration without providing password field
		// Registration with invalid password
		// Password should be at least 8 characters long
		// Registration without providing user phone number field
		// Registration with providing invalid user phone number field
		// Test for a valid Phone number
		// Registration without accepting terms and condition tickbox
		 
		  
		}
		

		  

	
