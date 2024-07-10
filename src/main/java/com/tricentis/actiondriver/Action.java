package com.tricentis.actiondriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tricentis.actioninterface.ActionInterface;
import com.tricentis.base.Base;

public class Action extends Base implements ActionInterface {

	@Override
	public void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	@Override
	public void explicitWait(WebDriver driver, WebElement element, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@Override
	public void implicitWait(WebDriver driver, Duration timeout) {
		driver.manage().timeouts().implicitlyWait(timeout);
	}

	@Override
	public boolean isDisplay(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		} finally {
			if (flag = true) {
				System.out.println("The element is Displayed");
			} else if (flag = false) {
				System.out.println("The element is not Displayed");
			}
		}
		return flag;
	}

	@Override
	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}
	

}
