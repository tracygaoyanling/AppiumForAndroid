package com.jince.android.control;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class GeneralMethod {
	
	public void LongPress(AndroidDriver<WebElement> driver,WebElement el){
		TouchAction action = new TouchAction(driver);
		action.longPress(el).perform();
	}
	public void Press(AndroidDriver<WebElement> driver,WebElement el,int ms){
		TouchAction action = new TouchAction(driver);
		action.press(el).waitAction(ms);
		action.perform();
	}
}
