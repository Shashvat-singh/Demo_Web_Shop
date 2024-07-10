package com.tricentis.pageobjects;


import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tricentis.actiondriver.Action;


public class HomePage {
	WebDriver driver;
	
	Action action = new Action();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	// Login Button for move on login page:--
	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginButton;
	
	//Register Button for sign-up:--
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement resisterButton;
	
	//Search Store Box :--
	@FindBy(xpath = "//input[@id='small-searchterms']")
	private WebElement searchBoxInput;
	//"Search" button for search box :-
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchBoxSearchBtn;

	//Visible UserName Field after Login :-
	@FindBy(xpath = "//a[@href ='/customer/info']")
	private WebElement userNameButtonAfterLogin;
	@FindBy(xpath="//a[text()='Log out']")
	private WebElement logoutBtn;
	
	// WebElement of Featured Product list :---
	@FindBy(xpath = "//div[@class='product-item']")
	private List<WebElement> productAsFeatureProductAtHomePage;
	// "Add to Cart" button for 'Featured Product" :---
	@FindBy(xpath = "//input[@value='Add to cart']")
	private List<WebElement> AddToCartBtn;
	
	
	
	public int numberOfFeaturedProd() {
		return productAsFeatureProductAtHomePage.size();
	}
	public int numberOfAddToCartBtn() {
		return AddToCartBtn.size();
	}
	
	
	public LoginPage clickOnLoginButton() {
		action.isDisplay(driver, loginButton);
		action.click(driver, loginButton);
		return new LoginPage(driver);
	}
	public AccountPage clickOnUserNameButton() {
		action.explicitWait(driver, logoutBtn, Duration.ofSeconds(1000));
		userNameButtonAfterLogin.click();
		return new AccountPage(driver);
	}
	
	public ResisterPage clickOnResisterButton() {
		resisterButton.click();
		return new ResisterPage(driver);
	}
	
	public void enterProductDescInSearchBox(String value) {
		searchBoxInput.click();
		searchBoxInput.clear();
		searchBoxInput.sendKeys(value);
	}
	public SearchPage clickOnTheSearchBtn() {
		searchBoxSearchBtn.click();
		return new SearchPage(driver);
	}
	
	public void acceptAlert() {
		 driver.switchTo().alert().dismiss();
	}
	
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}
	


}
