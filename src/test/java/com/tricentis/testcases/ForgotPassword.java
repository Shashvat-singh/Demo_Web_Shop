package com.tricentis.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tricentis.actiondriver.Action;
import com.tricentis.base.Base;
import com.tricentis.dataprovider.ForgotPasswordDataProvider;
import com.tricentis.pageobjects.ForgotPasswordPage;
import com.tricentis.pageobjects.HomePage;
import com.tricentis.pageobjects.LoginPage;
import com.tricentis.util.DataUtil;
import com.tricentis.util.MyXLSReader;

public class ForgotPassword extends Base{
	WebDriver driver;
	
	MyXLSReader excelReader;
	
	HomePage homePage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	
	
	@BeforeMethod
	public void startUp() {
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\TestData.xlsx");
		}catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (!DataUtil.isRunnable(excelReader, "ForgotPassword", "TestCases")) {
			throw new SkipException("Data(ForgotPassword Testcase) is not runnable.....!!skip!!");
		}
		driver = openBrowserAndRunApplicationURL();
		homePage = new HomePage(driver);
		homePage.clickOnLoginButton();
		loginPage = new LoginPage(driver);
		loginPage.clkOnForgotPasswordBtn();
		forgotPasswordPage = new ForgotPasswordPage(driver);
		
	}
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	@Test (dataProvider = "dataForVerRcyOfPwdWithWrongEmailText", dataProviderClass = ForgotPasswordDataProvider.class)
	public void verRcyOfPwdWithWrongEmailTxt(HashMap<String, String>hMapPwdWithWrongEmailText) {
		forgotPasswordPage.sendTxtToYourEmailAddress(hMapPwdWithWrongEmailText.get("Email"));
		forgotPasswordPage.cklOnRecoveryBtn();
		forgotPasswordPage.wrgEmailValidationTxtGet();
		Assert.assertEquals(forgotPasswordPage.wrgEmailValidationTxtGet(), hMapPwdWithWrongEmailText.get("ValidationError01"));
	}
	@Test (dataProvider = "dataForVerRcyOfPwdWithNotResEmailTxt", dataProviderClass = ForgotPasswordDataProvider.class)
	public void verRcyOfPwdWithNotResEmailTxt(HashMap<String, String>hMapPwdWithNotResEmailTxt) {
		forgotPasswordPage.sendTxtToYourEmailAddress(hMapPwdWithNotResEmailTxt.get("Email"));
		forgotPasswordPage.cklOnRecoveryBtn();
		forgotPasswordPage.emailNotFoundValTxtGet();
		System.out.println(forgotPasswordPage.emailNotFoundValTxtGet());
		Assert.assertEquals(forgotPasswordPage.emailNotFoundValTxtGet(), hMapPwdWithNotResEmailTxt.get("ValidationError01"));
	}
	@Test (dataProvider = "dataForVerRcyOfPwdWithVldResEmailAdd", dataProviderClass = ForgotPasswordDataProvider.class)
	public void verRcyOfPwdWithVldResEmailAdd(HashMap<String, String>hMapPwdWithVldResEmailAdd) {
		forgotPasswordPage.sendTxtToYourEmailAddress(hMapPwdWithVldResEmailAdd.get("Email"));
		forgotPasswordPage.cklOnRecoveryBtn();
		forgotPasswordPage.emailNotFoundValTxtGet();
		System.out.println(forgotPasswordPage.emailNotFoundValTxtGet());
		Assert.assertEquals(forgotPasswordPage.emailNotFoundValTxtGet(), hMapPwdWithVldResEmailAdd.get("ValidationError01"));
	}
	
}
