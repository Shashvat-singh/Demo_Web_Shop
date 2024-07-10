package com.tricentis.actioninterface;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	
	void click(WebDriver driver, WebElement ele);
	void explicitWait(WebDriver driver, WebElement element, Duration timeout);
	void implicitWait(WebDriver driver, Duration timeout);
	boolean isDisplay(WebDriver driver, WebElement ele);
	boolean type(WebElement ele, String text);
	

}
