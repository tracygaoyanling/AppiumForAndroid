package com.jince.android.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.data.MineCenterData;
import com.jince.android.pages.MinePage;
import com.jince.android.pages.Mine_LoginPage;
import com.jince.android.pages.Mine_MineCenterPage;
import com.jince.android.utility.ConPrint;

public class Mine_MineCenterPageTest extends BaseTest{
	private Mine_LoginPage loginPage;
	private MinePage minePage;
	private Mine_MineCenterPage mineCenterPage;
	public void beforeClass(){
		try {
			minePage = new MinePage(driver);
			minePage.GoToMinePage();
			loginPage = minePage.GoToLoginPage();
			if(loginPage.loginSuccess()){
				mineCenterPage = minePage.GoToMineCenterPage();
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}	
	}
	@Test
	public void changeNickNameCancelTest(){
		boolean result = mineCenterPage.changeNickNameCancel();
		Assert.assertTrue(result);
	}
	@Test(dataProvider="NickName",dataProviderClass=MineCenterData.class)
	public void changeNickNameSaveTest(String type, String name){
		boolean result = mineCenterPage.changeNickNameSave(type, name);
		Assert.assertTrue(result);
	}
	@Test
	public void changePwdCancelTest(){
		boolean result = mineCenterPage.changePwdCancel();
		Assert.assertTrue(result);
	}
	@Test(dataProvider="PwdData",dataProviderClass=MineCenterData.class)
	public void changePwdSaveTest(String type,String old,String newp,String cof){
		boolean result = mineCenterPage.changePwdSave(type, old, newp, cof);
		Assert.assertTrue(result);
	}
	@Test
	public void logOutTest(){
		boolean result = mineCenterPage.logOut();
		Assert.assertTrue(result);
	}
}
