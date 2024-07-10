package com.tricentis.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResisterPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='gender']/input")
	private List<WebElement> rdo_Gender;
	@FindBy(id = "FirstName")
	private WebElement FirstName;
	@FindBy(id = "LastName")
	private WebElement LastName;
	@FindBy(id = "Email")
	private WebElement Email;
	@FindBy(id = "Password")
	private WebElement Password;
	@FindBy(id = "ConfirmPassword")
	private WebElement ConPass;
	
	@FindBy(id = "register-button")
	private WebElement register_btn;
	
	
	@FindBy(xpath = "//span[@class='field-validation-error']/span[@for='FirstName']")
	private WebElement valRmkFirstName;
	
	@FindBy(xpath = "//div[@class='validation-summary-errors']/ul/li")
	private WebElement valRmkForAlreadyUsedEmail;
	
	@FindBy(xpath = "//span[@class='field-validation-error']/span[@for='Password']")
	private WebElement valRmkPassword;
	
	@FindBy(xpath = "//span[@class='field-validation-error']/span[@for='ConfirmPassword']")
	private WebElement valRmkConfPassword;
	
	

	public ResisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectRadioButtonByValue(String GenderValue) {
		for (WebElement radioButton : rdo_Gender) {
			if (radioButton.getAttribute("value").equals(GenderValue)) {
				radioButton.click();
				break;
			}
		}
	}
	
	public void enterFirstName(String FirstNameValue) {
		FirstName.clear();
		FirstName.sendKeys(FirstNameValue);
	}
	public void enterLastName(String LastNameValue) {
		LastName.clear();
		LastName.sendKeys(LastNameValue);
	}
	public void enterEmail(String email) {
		Email.clear();
		Email.sendKeys(email);
	}
	public void enterPassword(String Pass) {
		Password.clear();
		Password.sendKeys(Pass);
	}
	public void enterConfPass(String Conpass) {
		ConPass.clear();
		ConPass.sendKeys(Conpass);
	}
	public void clickOnResisterButton() {
		register_btn.click();
	}
	
	
	public String getValidationRemarkFirstName() {
		String validationFirstName = valRmkFirstName.getText();
		return validationFirstName;
	}
	public String getValidationRemarkForAlreadyUsedEmail() {
		String validationAlreadyUsedEmail = valRmkForAlreadyUsedEmail.getText();
		return validationAlreadyUsedEmail;
	}
	
	public String getValidationRemarkPassword() {
		String validationPassword = valRmkPassword.getText();
		return validationPassword;
	}
	public String getValidationRemarkConfPassword() {
		String validationConfPassword = valRmkConfPassword.getText();
		return validationConfPassword;
	}

}
