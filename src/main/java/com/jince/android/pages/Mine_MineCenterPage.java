package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.apache.regexp.recompile;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jince.android.utility.ConPrint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Mine_MineCenterPage extends BasePage{
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/actionbar_back")
	public WebElement backBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/person_info_header")
	public WebElement headerBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/person_info_nickname")
	public WebElement nickNameBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/person_info_changepwd")
	public WebElement changePwdBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/exit_login_btn")
	public WebElement logoutBtn;
	@AndroidFindBy(id ="com.jincehuangjin.jindashi:id/modify_nickname_et")
	public WebElement nickNameField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/modify_nickname_cancel")
	public WebElement changeNameCancelBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/modify_nickname_save")
	public WebElement changeNameSaveBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/old_password_et")
	public WebElement oldPwdField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/new_password_et")
	public WebElement newPwdField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/confirm_password_et")
	public WebElement confirmPwdField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/modify_password_back")
	public WebElement changePwdCancelBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/modify_password_conf_btn")
	public WebElement changePwdConfBtn;
	public Mine_MineCenterPage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
	//修改昵称-》取消
	public boolean changeNickNameCancel(){
		try {
			nickNameBtn.click();
			if (changeNameCancelBtn.isDisplayed()) {
				changeNameCancelBtn.click();
			}
			if (!(nickNameBtn.isDisplayed())) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	/*
	 * 功能：修改昵称-》保存
	 * 参数：用例类型type,昵称name
	 */
	public boolean changeNickNameSave(String type,String name) {
		try {
			nickNameBtn.click();
			nickNameField.sendKeys(name);
			changeNameSaveBtn.click();
			if (type.equals("wrong")) {
				if (!changeNameCancelBtn.isDisplayed()) {
					return false;
				}
			}else{
				if (!(logoutBtn.isDisplayed()&&nickNameBtn.getAttribute("text").equals(name))) {
					return false;
				}
			}
			if (type.equals("wrong")) {
				changeNameCancelBtn.click();
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	//修改密码-》取消
	public boolean changePwdCancel() {
		try {
			changePwdBtn.click();
			changePwdCancelBtn.click();
			if (!logoutBtn.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	/*
	 * 功能：修改密码-》保存
	 * 参数：测试类型type,旧密码old,新密码newp,确认密码cof
	 */
	public boolean changePwdSave(String type,String old,String newp, String cof) {
		try {
			changePwdBtn.click();
			oldPwdField.sendKeys(old);
			newPwdField.sendKeys(newp);
			confirmPwdField.sendKeys(cof);
//			HideKeyboard();
			changePwdConfBtn.click();
			if (type.equals("wrong")) {
				if (!changePwdConfBtn.isDisplayed()) {
					return false;
				}
			}else{
				if (!logoutBtn.isDisplayed()) {
					return false;
				}
			}
			if (type.equals("wrong")) {
				changePwdCancelBtn.click();
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}
		return true;
	}
	//退出登录
	public boolean logOut(){
		try {
			logoutBtn.click();			
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
}
