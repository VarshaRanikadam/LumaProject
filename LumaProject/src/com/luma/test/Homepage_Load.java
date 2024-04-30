package com.luma.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homepage_Load {

	public static String baseurl="https://magento.softwaretestingboard.com/";
	public static WebDriver driver = null;
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Exceler Classes Notes\\Eclipse Data\\ExcleRProjectLuma\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
		//Open Home page using "https://magento.softwaretestingboard.com/" this url
	    driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		 System.out.println("Task completed..........");
	  	  System.out.println("Browser close");
	  	  driver.close();
	}

}
