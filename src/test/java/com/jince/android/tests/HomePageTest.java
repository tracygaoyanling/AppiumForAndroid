package com.jince.android.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.pages.HomePage;
import com.jince.android.pages.MinePage;
import com.jince.android.pages.Mine_LoginPage;
import com.jince.android.utility.ConPrint;

public class HomePageTest extends BaseTest{
	private MinePage minePage;
	private Mine_LoginPage loginPage;
	private HomePage homePage;
	public void beforeClass(){
		try {
			minePage = new MinePage(driver);
			minePage.GoToMinePage();
			loginPage = minePage.GoToLoginPage();
			if(loginPage.loginSuccess()){
				homePage = minePage.GoToHomePage();
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
	public void InterfaceTest() {
		boolean result = homePage.Interface();
		Assert.assertTrue(result);
	}
	@Test
	public void HotMarketTest() throws InterruptedException {
		boolean result = homePage.HotMarket();
		Assert.assertTrue(result);
	}
	@Test
	public void LiveRoomTest() throws InterruptedException {
		boolean result1 = homePage.LiveRoomEnter1();
		Assert.assertTrue(result1);
		boolean result2 = homePage.LiveRoomEnter2();
		Assert.assertTrue(result2);
		boolean result3 = homePage.LiveRoom();
		Assert.assertTrue(result3);
	}
	@Test
	public void NewsTest() throws InterruptedException{
		boolean result = homePage.News();
		Assert.assertTrue(result);
	}
	@Test 
	public void FinanceTest() throws InterruptedException {
		boolean result = homePage.Finance();
		Assert.assertTrue(result);
	}
}
