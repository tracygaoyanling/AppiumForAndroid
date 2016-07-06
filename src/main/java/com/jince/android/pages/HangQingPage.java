package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HangQingPage extends BasePage{
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tip")
	public WebElement tip;
	@AndroidFindBy(name = "自选")
	public WebElement zixuan;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_title")
	public WebElement hqtitle;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/iv_left")
	public WebElement backBtn;
	public HangQingPage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10,TimeUnit.SECONDS), this);
	}

}
