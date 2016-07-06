package com.jince.android.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.pages.MinePage;
import com.jince.android.pages.Mine_LoginPage;
import com.jince.android.utility.ConPrint;
/*
 * 功能：【我的】页面的测试类，调用【我的】页面的方法进行测试
 * 作者：Make
 */
public class MinePageTest extends BaseTest{
	MinePage minePage;
	Mine_LoginPage loginPage;
	public void beforeClass(){
		minePage = new MinePage(driver);
		minePage.GoToMinePage();
		loginPage = minePage.GoToLoginPage();
		if(loginPage.loginSuccess()){
			ConPrint.info("Login Success...");
		}else{
			ConPrint.fail("Login Failed...");
		}
	}
	public void afterClass() {
		try {
			minePage.logOut();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}
	}
	@Test
	public void InterfaceTest(){
		String tx1 = "我的";
		String tx2 = "上金所介绍";
		String tx3 = "新手学堂";
		String tx4 = "意见反馈";
		String tx5 = "电话服务";
		String tx6 = "推送设置";
		String tx7 = "清除缓存";
		String tx8 = "分享APP";
		String tx9 = "关于";
		boolean result = minePage.InterfaceCheck(tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8,tx9);
		Assert.assertTrue(result);
	}
	@Test
	public void PushSettingTest(){
		boolean result = minePage.pushSetting();
		Assert.assertTrue(result);
	}
}
