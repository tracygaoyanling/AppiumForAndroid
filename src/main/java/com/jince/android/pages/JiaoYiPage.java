package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class JiaoYiPage extends BasePage{
	@AndroidFindBy(name = "交易登录")
	public WebElement tradeLoginTitle;
	@AndroidFindBy(name ="交易密码")
	public WebElement tradePwd;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/trade_password_et")
	public WebElement tradePwdField;
	public JiaoYiPage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
}
