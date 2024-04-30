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

import com.luma.Pages.createAccountPage;


public class createAccoutPageTest {

	createAccountPage ca;
	
	@BeforeMethod
	public void browserSetUp() {
		ca = new createAccountPage();
		ca.Initialize();
	}
	
	@Test (dataProvider = "getExcelDataNegative")
	public void Validate_Negative_CreateAccount(String fn) {
		ca.createAccountNegative(fn);
		String expErrorMessage = "This is a required field.";
		String actErrorMessage = ca.errorMessage();
		AssertJUnit.assertEquals(actErrorMessage, expErrorMessage);
	}
	
	@DataProvider
	public Object[][] getExcelDataNegative() {
		String filePath = "D:\\Exceler Classes Notes\\Eclipse Data\\LumaProject\\TestInfo.xlsx";
		String sheetName = "FailTest";
		return Utility.ExcelData.getData(filePath, sheetName);
		}
	
	@Test (dataProvider = "getExcelData")
	public void validate_CreateAccount(String fn, String ln, String email, String pass, String cpass) {
		ca.createAccount(fn, ln, email, pass, cpass);
		String expMessage = "Thank you for registering with Main Website Store.";
		String actMessage = ca.successMessage();
		AssertJUnit.assertEquals(expMessage, actMessage);
	}
	
	@DataProvider
	public Object[][] getExcelData() {
		String filePath = "D:\\Exceler Classes Notes\\Eclipse Data\\LumaProject\\TestInfo.xlsx";
		String sheetName = "CreateAccount";
		return Utility.ExcelData.getData(filePath, sheetName);
		}
	
	@AfterMethod
	public void closeBrowser() {
		ca.tearDown();
	}
}
