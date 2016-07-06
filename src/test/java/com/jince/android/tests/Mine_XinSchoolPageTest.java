package com.jince.android.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.pages.MinePage;
import com.jince.android.pages.Mine_XinSchoolPage;
import com.jince.android.utility.ConPrint;

public class Mine_XinSchoolPageTest extends BaseTest{
	private MinePage minePage;
	private Mine_XinSchoolPage xinSchoolPage;
	public void beforeClass(){
		try {
			minePage = new MinePage(driver);
			minePage.GoToMinePage();
			xinSchoolPage = new Mine_XinSchoolPage(driver);
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}	
	}
	public void beforeMethod() {
		minePage.xinSchoolBtn.click();
	}
	
	@Test
	public void XinLinkTest(){
		boolean result = xinSchoolPage.xinLink();
		Assert.assertTrue(result);
	}
	@Test
	public void GaoLinkTest(){
		boolean result = xinSchoolPage.gaoLink();
		Assert.assertTrue(result);
	}
	
}
