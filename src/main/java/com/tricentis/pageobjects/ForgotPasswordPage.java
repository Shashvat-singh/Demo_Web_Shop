package com.tricentis.pageobjects;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tricentis.actiondriver.Action;

public class ForgotPasswordPage {
	WebDriver driver;
	Action action = new Action();
	
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement YourEamilAddress;
	@FindBy (xpath = "//input[@name='send-email']")
	private WebElement RecoveryBtn;
	@FindBy(xpath = "//span[text()='Wrong email']")
	private WebElement wrongEmailValAlert;
	@FindBy(xpath = "//div[@class='page password-recovery-page']/div[2]/div[1]")
	private WebElement emailNotFoundValAlert;
	
	public void sendTxtToYourEmailAddress(String txt) {
		action.explicitWait(driver, RecoveryBtn, Duration.ofSeconds(1000));
		action.type(YourEamilAddress, txt);
	}
	
	public void cklOnRecoveryBtn() {
		action.click(driver, RecoveryBtn);
	}
	
	public String wrgEmailValidationTxtGet() {
		return wrongEmailValAlert.getText();
	}
	
	public String emailNotFoundValTxtGet() {
		action.explicitWait(driver, emailNotFoundValAlert, Duration.ofSeconds(1000));
		return emailNotFoundValAlert.getText();
	}
	
	public String emailWithInstructionValTxtGet() {
		action.explicitWait(driver, emailNotFoundValAlert, Duration.ofSeconds(1000));
		return emailNotFoundValAlert.getText();
	}

}
