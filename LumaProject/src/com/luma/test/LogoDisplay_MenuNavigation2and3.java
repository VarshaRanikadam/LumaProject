package com.luma.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogoDisplay_MenuNavigation2and3 
{

	public static String baseurl="https://magento.softwaretestingboard.com/";
	public static WebDriver driver = null;
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch Website first
				
		System.setProperty("webdriver.chrome.driver", "D:\\Exceler Classes Notes\\Eclipse Data\\ExcleRProjectLuma\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		 // Navigate to the website
	    driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// Test Case: Verify Logo Display or not
		
        System.out.println("*********************Verify Logo Display or not*****************************");

		
		WebElement logoImage = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a"));
		Thread.sleep(2000);
		if (logoImage.isDisplayed()) 
		{
            System.out.println("Logo is displayed");
        } 
		else 
        {
            System.out.println("Logo is not displayed");
        }

			
		// Get the href attribute of the logo image
        String logoLink = logoImage.getAttribute("href");
        // Click on the logo image
        logoImage.click();
        
     //waiting for the page to load
        try 
        {
            Thread.sleep(2000);  
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        // Verify if the current URL matches the expected logo link
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(logoLink)) 
        {
            System.out.println("Clicking on the logo redirects to the correct link: " + logoLink+"\n");
        } 
        else 
        {
            System.out.println("Clicking on the logo does not redirect to the correct link."+"\n");
            System.out.println("Expected Link: " + logoLink+"\n");
            System.out.println("Actual Link: " + currentUrl+"\n");
        }
             
        driver.navigate().to(baseurl);
        Thread.sleep(2000); 
        
        // Test Case: Verify Navigation Menu
        
        
        System.out.println("*********************Test Case: Verify Navigation Main Menu*****************************");
        
        WebElement desiredMenuItem1 = driver.findElement(By.linkText("What's New"));
        desiredMenuItem1.click();Thread.sleep(2000);       
        /* Hard Assert */
        String curr_window_title1 = driver.getTitle();
        Assert.assertEquals(curr_window_title1, "What's New");
        System.out.println("AssertEquals Test What's New page Passed\n");
        driver.navigate().to(baseurl);
                
        WebElement desiredMenuItem2 = driver.findElement(By.linkText("Women"));
        desiredMenuItem2.click();Thread.sleep(2000);
        String curr_window_title2 = driver.getTitle();
        Assert.assertEquals(curr_window_title2, "Women");
        System.out.println("AssertEquals Test Women page Passed\n");
        driver.navigate().to(baseurl);
      
        
        WebElement desiredMenuItem3 = driver.findElement(By.linkText("Men"));
        desiredMenuItem3.click();Thread.sleep(2000);
        String curr_window_title3 = driver.getTitle();
        Assert.assertEquals(curr_window_title3, "Men");
        System.out.println("AssertEquals Test Men page Passed\n");
        driver.navigate().to(baseurl);
        
        WebElement desiredMenuItem4 = driver.findElement(By.linkText("Gear"));
        desiredMenuItem4.click();Thread.sleep(2000);
        String curr_window_title4 = driver.getTitle();
        Assert.assertEquals(curr_window_title4, "Gear");
        System.out.println("AssertEquals Test Gear page Passed\n");
        driver.navigate().to(baseurl);
        
        WebElement desiredMenuItem5 = driver.findElement(By.linkText("Training"));
        desiredMenuItem5.click();Thread.sleep(2000);
        String curr_window_title5 = driver.getTitle();
        Assert.assertEquals(curr_window_title5, "Training");
        System.out.println("AssertEquals Test Training page Passed\n");
        driver.navigate().to(baseurl);
        
        WebElement desiredMenuItem6 = driver.findElement(By.linkText("Sale"));
        desiredMenuItem6.click();Thread.sleep(2000);
        String curr_window_title6 = driver.getTitle();
        Assert.assertEquals(curr_window_title6, "Sale");
        System.out.println("AssertEquals Test Sale page Passed\n");
        driver.navigate().to(baseurl);
        
        System.out.println("Task completed..........");
    	System.out.println("Browser close");
    	driver.close();

	}
}
