package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.luma.Pages.signInPage;

public class signInPageTest {
	
	signInPage sp ;
	
	@BeforeMethod
	public void browserSetUp() {
		sp = new signInPage();
		sp.Initialize();
	}
	
	
	@Test (dataProvider = "getExcelData")
	public void validate_SignIn(String email, String pass) {
		sp.signIn(email, pass);
		String actMessage = sp.successLoginpage();
		String expMessage = "Welcome, Varsha Kadam Test!";
		AssertJUnit.assertEquals(actMessage, expMessage);
	}
	
	@DataProvider
	public Object[][] getExcelData() {
		String filePath = "D:\\Exceler Classes Notes\\Eclipse Data\\LumaProject\\TestInfo.xlsx";
		String sheetName = "SignIn";
		return Utility.ExcelData.getData(filePath, sheetName);
		}
		
	@Test
	public void validate_PasswordReset() {
		sp.forgotPassword();
		String actMessage = "If there is an account associated with you will receive an email with a link to reset your password.";
		String expMessage = sp.passwordReset();
		AssertJUnit.assertEquals(actMessage, expMessage);
	}
	@AfterMethod
	public void closeBrowser() {
		sp.tearDown();
	}
}
