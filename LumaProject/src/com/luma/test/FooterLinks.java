package com.luma.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterLinks {

	public static String baseurl="https://magento.softwaretestingboard.com/";
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException 
	{
		 
		System.setProperty("webdriver.chrome.driver", "D:\\Exceler Classes Notes\\Eclipse Data\\ExcleRProjectLuma\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
		//Open Home page using "https://magento.softwaretestingboard.com/" this url
	    driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Footer All Links verify its correct links added or not
        System.out.println("*********************Test Case: Footer Links checks****************************");
        
     // Find the footer element
        WebElement footer = driver.findElement(By.tagName("footer"));
     // Find all links within the footer
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

        // Print the text of each link
        System.out.println("Footer Links:");
        for (WebElement link : footerLinks) 
        {
            System.out.println(link.getText() + ": " + link.getAttribute("href"));
            System.out.println("\n");
        }
        
        
        
        System.out.println("***********************Verify Provided list of footer links are correct way or not *********************************");
        
     // Extract text from footer links
        List<String> extractedLinks = new ArrayList<>();
        for (WebElement link : footerLinks) {
            extractedLinks.add(link.getText());
        }

        Thread.sleep(2000);
        
        // Provided list of footer links
        List<String> providedLinks = Arrays.asList(
                "Notes ",
                "Practice API Testing using Magento 2",
                "Write for us",
                "Subscribe",
                "Search Terms",
                "Privacy and Cookie Policy",
                "Advanced Search",
                "Orders and Returns"
        );
        
        Thread.sleep(2000);

        // Check if all provided links are present in the extracted links
        boolean allLinksAddedCorrectly = true;
        for (String link : providedLinks) {
            if (!extractedLinks.contains(link)) {
                allLinksAddedCorrectly = false;
                System.out.println("Link '" + link + "' is missing in the footer.");
            }
        }

        // Report if all links were added correctly or not
        if (allLinksAddedCorrectly) {
            System.out.println("All provided links are added correctly to the footer.");
        } else {
            System.out.println("Some provided links are missing from the footer.");
        }
        
        System.out.println("Task completed..........");
    	System.out.println("Browser close");
    	driver.close();
		
	}

}
