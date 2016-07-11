package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jince.android.utility.ConPrint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
/*
 * 功能：基本Page类，所有的子Page类都要继承于该父类，主要是规定了driver类型为AndroidDriver以及常用方法
 * 作者：Make
 */
public class BasePage {
	protected AndroidDriver<WebElement> driver;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_home")
	public WebElement homeBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_hq")
	public WebElement hangqingBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_jy")
	public WebElement jiaoyiBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_customer")
	public WebElement kefuBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_wd")
	public WebElement mineBtn;
	public BasePage(AndroidDriver<WebElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
	public void GoBack(){
		driver.navigate().back();
	}
	public void HideKeyboard(){
		driver.hideKeyboard();
	}
	
	public HomePage GoToHomePage(){
		try {
			homeBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}
		return new HomePage(driver);
	}
	
	public HangQingPage GoToHangqingPage(){
		try {
			hangqingBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}
		return new HangQingPage(driver);
	}
	
	public boolean GoToMinePage() {
		try {
			mineBtn.click();		
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}	
}
