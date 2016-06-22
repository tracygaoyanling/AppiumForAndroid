package com.jince.android.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	protected AndroidDriver<WebElement> driver;
	public BasePage(AndroidDriver<WebElement> driver){
		this.driver = driver;
	}
	public void GoBack(){
		driver.navigate().back();
	}
	
	public void HideKeyboard(){
		driver.hideKeyboard();
	}
		
}
