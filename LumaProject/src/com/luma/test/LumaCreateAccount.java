package com.luma.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LumaCreateAccount 
{
	public static String baseurl="https://magento.softwaretestingboard.com/";
	public static WebDriver driver = null;
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Exceler Classes Notes\\Eclipse Data\\ExcleRProjectLuma\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
		//Open the web application 
	    driver.get(baseurl);
		Thread.sleep(2000);
		driver.manage().window().maximize();

	    //create account link for create user 
		System.out.println("Navigate to create Account link");
		
		//driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
	
		WebElement craeteaccountlink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));

		 String craeteNewaccountlink = craeteaccountlink.getAttribute("href");
	        // Click on the create new Account image
		 craeteaccountlink.click();
		 driver.manage().window().maximize();
		 Thread.sleep(2000);

		// Verify if the current URL matches the expected link
	        String currentUrl = driver.getCurrentUrl();
	        if (currentUrl.equals(craeteNewaccountlink)) 
	        {
	            System.out.println("Clicking on the create new account user redirects to the correct link: " + craeteNewaccountlink+"\n");
	        } 
	        else 
	        {
	            System.out.println("Clicking on the create new account user does not redirect to the correct link."+"\n");
	        }
	        
	        
	     // Fill in registration form
	        WebElement firstNameInput = driver.findElement(By.id("firstname"));
	        firstNameInput.sendKeys("Varsha");

	        WebElement lastNameInput = driver.findElement(By.id("lastname"));
	        lastNameInput.sendKeys("Kadam");

	        WebElement emailInput = driver.findElement(By.id("email_address"));
	        emailInput.sendKeys("varsha17690@rediffmail.com");

	        WebElement passwordInput = driver.findElement(By.id("password"));
	        passwordInput.sendKeys("Test@123");

	        Thread.sleep(2000);
	        
	        WebElement confirmPasswordInput = driver.findElement(By.id("password-confirmation"));
	        confirmPasswordInput.sendKeys("Test@123");

	        Thread.sleep(4000);
	        
	        // Submit the registration form
	        WebElement registerButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
	        registerButton.click();
	        
	         System.out.println("Account create Newlly succesfully");	  
	         
	        List<WebElement> createAccountButtons = driver.findElements(By.cssSelector("button[title='Create an Account']"));

	        // Check if any elements are found
	        if (!createAccountButtons.isEmpty()) 
	        {
	            // Iterate through the list of found elements
	            for (WebElement button : createAccountButtons) {
	                // Print out the button text (or perform any other action)
	                System.out.println("Button Text: " + button.getText());
	            }
	        } 
	        else 
	        {
	            System.out.println("No 'Create an Account' button found on the page.");
	        }
	        
	        System.out.println("Task completed..........");
	    	  System.out.println("Browser close");
	    	  driver.close(); 
	}

}
