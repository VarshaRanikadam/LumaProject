package com.luma.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_SearchBar {

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
		
		// Test Case: Verify Search Bar: Test if the search bar is present and operational.
		
        System.out.println("*********************Verify Search Bar: Test if the search bar is present and operational.*****************************");

     // Find the search input field
        WebElement searchInput = driver.findElement(By.id("search"));
        
     // Verify if the search input field is present
        if (searchInput.isDisplayed()) 
        {
            System.out.println("Search bar is present.");

            // Enter a search query and submit
            searchInput.sendKeys("Jackets");
            searchInput.sendKeys(Keys.ENTER);
    		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    		 WebElement searchResults = driver.findElement(By.cssSelector(".products-grid"));
     		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

             if (searchResults.isDisplayed()) 
             {
                 System.out.println("Search bar is operational. Search results are displayed.");
             } 
             else 
             {
                 System.out.println("Search bar is operational, but search results are not displayed.");
             }
         } 
	        else 
	        {
	             System.out.println("Search bar is not present.");
	         }

        System.out.println("Task completed..........");
    	  System.out.println("Browser close");
    	  driver.close();
	}

}
