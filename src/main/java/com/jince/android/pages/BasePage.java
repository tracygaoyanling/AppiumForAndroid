package com.jince.android.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
/*
 * 功能：基本Page类，所有的子Page类都要继承于该父类，主要是规定了driver类型为AndroidDriver以及常用方法
 * 作者：Make
 */
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
