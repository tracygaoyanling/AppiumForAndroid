package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class LoginPage extends BasePage{

	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/login_back_btn")
	public WebElement backBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/login_account_et")
	public WebElement accountField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/login_password_et")
	public WebElement passwordField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/user_login_btn")
	public WebElement loginBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/fast_register_btn")
	public WebElement registerBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/forget_password_btn")
	public WebElement forgetPwdBtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
}
