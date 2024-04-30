package com.luma.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomerLogin {

	public static String baseurl="https://magento.softwaretestingboard.com/";
	public static WebDriver driver = null;
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		
		
		//Test case A] to verify Login with Valid Credentials
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Exceler Classes Notes\\Eclipse Data\\ExcleRProjectLuma\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
		//Open the web application 
	    driver.get(baseurl);
		Thread.sleep(2000);
		driver.manage().window().maximize();

	    //Sign Up account link for Existing user 
		System.out.println("Navigate to Sign Up Account link");
		
		//driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
	
		WebElement signuplink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
		
		String SignUpaccountlink = signuplink.getAttribute("href");
        // Click on the signuplink
		signuplink.click();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// Verify if the current URL matches the expected link
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(SignUpaccountlink)) 
        {
            System.out.println("Clicking on the Sign Up account user redirects to the correct link: " + SignUpaccountlink+"\n");
        } 
        else 
        {
            System.out.println("Clicking on the the Sign Up account user does not redirect to the correct link."+"\n");
        }
        
        
        // Find the email input field and enter the email
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("varsha17690@gmail.com");

        // Find the password input field and enter the password
        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys("Test@123");

        // Find and click on the "Sign In" button
        WebElement signInButton = driver.findElement(By.id("send2"));
        signInButton.click();

        // Wait for the page to load after login 
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     // Verify if login was successful by checking for elements on the logged-in page
        WebElement userAccount = driver.findElement(By.cssSelector(".page-header .links li:first-child"));
        if (userAccount.isDisplayed()) 
        {
            System.out.println("Login successful. User is logged in.");
        } 
        else 
        {
            System.out.println("Login failed. User is not logged in.");
        }
         	     
        
        String loggedInUser = userAccount.getText();
        
        System.out.println("User Name: "+loggedInUser);

        // Expected username
        String expectedUsername = "Welcome, VarshaRani Kadam!"; // Change this to the expected username
        
     // Verify if the logged-in user is correct
        if (loggedInUser.contains(expectedUsername)) {
            System.out.println("Login successful. Logged-in user is correct: " + expectedUsername);
        } else {
            System.out.println("Login successful, but the logged-in user is incorrect. Expected: " + expectedUsername + ", Actual: " + loggedInUser);
        }     
        
      System.out.println("Task completed..........");
  	  System.out.println("Browser close");
  	  driver.close();
	}

	
	
}
