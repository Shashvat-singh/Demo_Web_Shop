package com.tricentis.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tricentis.actiondriver.Action;


public class LoginPage {
	WebDriver driver;
	Action action = new Action();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement emailField;
	@FindBy(id = "Password")
	private WebElement passwordField;
	@FindBy(id = "RememberMe")
	private WebElement rememberMeCheckbox;
	@FindBy(xpath = "//a[text()='Forgot password?']")
	private WebElement forgotPasswordBtn;
	@FindBy(xpath = "//input[@class='button-1 login-button' and @value='Log in']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//div[@class='validation-summary-errors']/span")
	private WebElement loginMsgError01;
	@FindBy (xpath = "//div[@class=\"validation-summary-errors\"]/ul/li")
	private WebElement loginMsgError02;
	
	
	@FindBy(xpath = "//a[@href ='/customer/info']")
	private WebElement userNameButtonAfterLogin;
	
	
	public void sendTextToEmailField(String text) {
		action.explicitWait(driver, emailField, Duration.ofSeconds(1000));
		action.type(emailField, text);
	}
	public void sendTextToPasswordField(String passwordText) {
		action.type(passwordField, passwordText);
	}
	
	
	
	public HomePage clickOnLoginButton() {
		action.click(driver, loginButton);
		return new HomePage(driver);
	}
	public ForgotPasswordPage clkOnForgotPasswordBtn() {
		action.explicitWait(driver, forgotPasswordBtn, Duration.ofSeconds(1000));
		action.click(driver, forgotPasswordBtn);
		return new ForgotPasswordPage(driver);
	}
	
	public String validationOneForLoginWithValidEmailInvalidPass() {
		action.explicitWait(driver, loginMsgError01, Duration.ofSeconds(1000));
		return loginMsgError01.getText();
	}
	
	public String validationSecoundForLoginWithValidEmailInvalidPass() {
		return loginMsgError02.getText();
	}
	
	
	

}
