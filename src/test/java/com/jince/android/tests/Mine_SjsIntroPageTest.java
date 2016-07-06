package com.jince.android.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.pages.MinePage;
import com.jince.android.pages.Mine_SjsIntroPage;
import com.jince.android.utility.ConPrint;

public class Mine_SjsIntroPageTest extends BaseTest{
	private MinePage minePage;
	private Mine_SjsIntroPage mineSjsIntroPage;
	public void beforeClass(){
		try {
			minePage = new MinePage(driver);
			minePage.GoToMinePage();
			mineSjsIntroPage = new Mine_SjsIntroPage(driver);
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}	
	}
	protected void beforeMethod() {
		minePage.sjsIntroBtn.click();
	}
	@Test
	public void heYueLinkTest(){
		boolean result = mineSjsIntroPage.heYueLink();
		Assert.assertTrue(result);
	}
	@Test
	public void kaiHuLinkTest(){
		boolean result = mineSjsIntroPage.kaiHuLink();
		Assert.assertTrue(result);
	}
	@Test
	public void jiaoYiLinkTest(){
		boolean result = mineSjsIntroPage.jiaoYiLink();
		Assert.assertTrue(result);
	}
	@Test
	public void qingSuanLinkTest(){
		boolean result = mineSjsIntroPage.qingSuanLink();
		Assert.assertTrue(result);
	}
	@Test
	public void fengKongLinkTest(){
		boolean result = mineSjsIntroPage.fengKongLink();
		Assert.assertTrue(result);
	}
	@Test
	public void jiaoGeLinkTest(){
		boolean result = mineSjsIntroPage.jiaoGeLink();
		Assert.assertTrue(result);
	}
	@Test
	public void reDianLinkTest(){
		boolean result = mineSjsIntroPage.reDianLink();
		Assert.assertTrue(result);
	}
}
