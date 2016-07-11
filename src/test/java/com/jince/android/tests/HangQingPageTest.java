package com.jince.android.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.pages.HangQingPage;
import com.jince.android.pages.MinePage;
import com.jince.android.pages.Mine_LoginPage;
import com.jince.android.utility.ConPrint;

public class HangQingPageTest extends BaseTest{
	private MinePage minePage;
	private Mine_LoginPage loginPage;
	private HangQingPage hangQingPage;
	public void beforeClass(){
		try {
			minePage = new MinePage(driver);
			minePage.GoToMinePage();
			loginPage = minePage.GoToLoginPage();
			if(loginPage.loginSuccess()){
				hangQingPage = minePage.GoToHangqingPage();
				hangQingPage.tip.click();
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
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
		boolean result = hangQingPage.Interface();
		Assert.assertTrue(result);
	}
	@Test
	public void SwitchHqTabTest(){
		boolean result = hangQingPage.SwitchHqTab();
		Assert.assertTrue(result);
	}
}
