package com.jince.android.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.data.FeedbackData;
import com.jince.android.pages.MinePage;
import com.jince.android.pages.Mine_FeedbackPage;
import com.jince.android.pages.Mine_LoginPage;
import com.jince.android.utility.ConPrint;

public class Mine_FeedbackPageTest extends BaseTest{
	private MinePage minePage;
	private Mine_FeedbackPage feedbackPage;
	private Mine_LoginPage loginPage;
	public void beforeClass(){
		try {
			minePage = new MinePage(driver);
			minePage.GoToMinePage();
			loginPage = minePage.GoToLoginPage();
			if(loginPage.loginSuccess()){
				feedbackPage = minePage.GoToFeedbackPage();
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
		boolean result = feedbackPage.interfaceCheck();
		Assert.assertTrue(result);
	}
	@Test(dataProvider="Feedback",dataProviderClass=FeedbackData.class)
	public void SubmitFeedbackTest(String type,String phone,String content){
		boolean result = feedbackPage.SubmitFeedback(type, phone, content);
		Assert.assertTrue(result);
	}
	@Test
	public void FeedbackHistoryTest(){
		boolean result = feedbackPage.FeedbackHistory();
		Assert.assertTrue(result);
	}
	@Test
	public void HotProblemTest(){
		boolean result = feedbackPage.HotProblem();
		Assert.assertTrue(result);
	}
}
