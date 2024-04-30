package com.luma.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductToCartTest 
{
	public static String baseurl="https://magento.softwaretestingboard.com/";
	public static WebDriver driver = null;
	
    @BeforeClass
    public void setUp() throws InterruptedException 
    {
    	
    	System.setProperty("webdriver.chrome.driver", "D:\\Exceler Classes Notes\\Eclipse Data\\ExcleRProjectLuma\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
		//Open the web application 
	    driver.get(baseurl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
    }

    @Test
    public void testAddProductToCart() {
        // Open the product page
    	
        driver.get("https://magento.softwaretestingboard.com/Jackets");

        // Click on the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.cssSelector(".add-to-cart-buttons button"));
        addToCartButton.click();

        // Wait for the product to be added to the cart (you may need to add an explicit wait here)

        // Verify that the product is added to the cart
        WebElement cartItem = driver.findElement(By.cssSelector(".header-minicart .product-name a"));
        Assert.assertTrue(cartItem.isDisplayed(), "Product is not added to the cart.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}