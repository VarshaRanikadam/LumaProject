package com.luma.Pages;


import java.time.Duration;

import org.openqa.selenium.By;

import com.luma.base.LumaBase;

public class createAccountPage extends LumaBase {

	
	
	public void createAccount(String fn, String ln, String email, String pass, String cpass) {		
		driver.findElement(By.partialLinkText("Create an Account")).click();
		driver.findElement(By.id("firstname")).sendKeys(fn);
		driver.findElement(By.id("lastname")).sendKeys(ln);
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("password_confirmation")).sendKeys(cpass);
		driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
		Utility.Screenshot.captureScreenshot("Create Accout", driver);
	}
	
	public String successMessage() {
		return driver.findElement(By.xpath("//div[@class='messages']/div/div[text()= 'Thank you for registering with Main Website Store.']")).getText();
	}
	
	public void createAccountNegative(String fn) {
		driver.findElement(By.partialLinkText("Create an Account")).click();
		driver.findElement(By.id("firstname")).sendKeys(fn);
		driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
		Utility.Screenshot.captureScreenshot("Negative_Create Accout", driver);
	}
	
	public String errorMessage() {
		return driver.findElement(By.id("lastname-error")).getText();
	}
	
 
}
