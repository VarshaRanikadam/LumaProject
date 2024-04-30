package com.luma.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifySearchProduct {

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
		
        System.out.println("*********************Search for Product by Name: Test the search functionality by entering a product name and verifying the search results.*****************************");

     // Find the search input field
        WebElement searchInput = driver.findElement(By.id("search"));
        
     // Enter the product name to search for
        String productName = "Bags"; // Change this to the desired product name
        searchInput.sendKeys(productName);
        // Submit the search query
        searchInput.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("Loading and searching information regarding to search result.................");

		 
 		 // Find the related search information section
 		 WebElement relatedSearchSection = driver.findElement(By.cssSelector(".products-grid"));
        //WebElement relatedSearchSection = driver.findElement(By.cssSelector(".block-related-search"));
		Thread.sleep(2000);


		
         // Find all related search terms
         List<WebElement> relatedSearchTerms = relatedSearchSection.findElements(By.tagName("li"));
 		Thread.sleep(2000);


         // Display related search information
         System.out.println("Related Search Information:");
         for (WebElement term : relatedSearchTerms) {
             System.out.println(term.getText());
         }
        
     
       
    }
}
