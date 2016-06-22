package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jince.android.config.UIConfig;
import com.jince.android.utility.ConPrint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class Mine_LoginPage extends BasePage{
	MinePage minePage = new MinePage(driver);
	@AndroidFindBy(xpath ="//android.widget.TextView[contains(@index,2)]")
	public WebElement loginTitle;
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
	public Mine_LoginPage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	public boolean GoToLoginPage(){
		try {
			ConPrint.test("GoToLoginPage");
			minePage.nicknameBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		ConPrint.success();
		return true;
	}
	public boolean ExitLoginPage(){
		try {
			ConPrint.test("ExitLoginPage");
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		ConPrint.success();
		return true;
	}
	public boolean InterfaceCheck(String tx1,String tx2,String tx3,String tx4,String tx5){
		try {
			ConPrint.test("InterfaceCheck");
			String accountText = accountField.getAttribute("text");
			String loginTitleText = loginTitle.getAttribute("text");
			String loginBtnText = loginBtn.getAttribute("text");
			String regText = registerBtn.getAttribute("text");
			String forgetText = forgetPwdBtn.getAttribute("text");
			if(!(accountText.equals(tx1)
					&&loginTitleText.equals(tx2)
					&&loginBtnText.equals(tx3)
					&&regText.equals(tx4)
					&&forgetText.equals(tx5))){
				return false;
			}
			if (loginBtn.isEnabled()) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		ConPrint.success();
		return true;
	}
	public boolean LoginTest(String account,String password){
		try {
			ConPrint.test("LoginTest with account = "+account+", password = "+password);
			if (account==""||password=="") {
				accountField.sendKeys(account);
				passwordField.sendKeys(password);
				if (loginBtn.isEnabled()) {
					return false;
				}
			}else if (account.equals(UIConfig.account+"1")||password.equals(UIConfig.password+"1")) {
				accountField.sendKeys(account);
				passwordField.sendKeys(password);
				HideKeyboard();
				loginBtn.click();
				if (!loginBtn.isDisplayed()) {
					return false;
				}
			}else {
				accountField.sendKeys(account);
				passwordField.sendKeys(password);
				HideKeyboard();
				loginBtn.click();
				if (!minePage.nicknameBtn.isDisplayed()) {
					return false;
				}
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		ConPrint.success();
		return true;
	}
		
}
