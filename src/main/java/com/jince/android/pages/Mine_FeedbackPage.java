package com.jince.android.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.jince.android.config.UIConfig;
import com.jince.android.utility.ConPrint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Mine_FeedbackPage extends BasePage {
	@AndroidFindBy(name ="意见反馈")
	private WebElement title;
	@AndroidFindBy(name = "联系客服")
	private WebElement contactBtn;
	@AndroidFindBy(name = "我要反馈")
	private WebElement wantFeedback;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/want_feedback_lay")
	private WebElement wantFeedbackBtn;
	@AndroidFindBy(name = "反馈历史")
	private WebElement feedbackHistory;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/feedback_history_lay")
	private WebElement feedbackHistoryBtn;
	@AndroidFindBy(name = "热门问题")
	private WebElement hotProblem;
	@AndroidFindBy(accessibility = "如何出入金？")
	private WebElement hotProblemX;
	@AndroidFindBy(xpath = "//android.view.View[contains(@index,1)]/android.view.View[contains(@index,1)]")
	private WebElement hotProblemXX;
	//***************反馈页面元素****************//
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/contact_info_et")
	private WebElement phoneField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/fl_feedback_input_lay")
	private WebElement feedbackContentField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/submit_feedback_btn")
	private WebElement submitFeedbackBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/feedback_back")
	private WebElement backBtn;
	//***************反馈历史页面元素****************//
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/question_title_iv")
	private List<WebElement> feedbackQns;
	public Mine_FeedbackPage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
	public boolean interfaceCheck() {
		try {
			if (!(title.isDisplayed()&&contactBtn.isDisplayed()&&wantFeedback.isDisplayed()&&feedbackHistory.isDisplayed()&&hotProblem.isDisplayed())) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean SubmitFeedback(String type,String phone,String content) {
		try {
			wantFeedbackBtn.click();
			phoneField.sendKeys(phone);
			feedbackContentField.sendKeys(content);
			UIConfig.feedbackContent = content;
			submitFeedbackBtn.click();
			if (type.equals("wrong")) {
				if (!submitFeedbackBtn.isDisplayed()) {
					return false;
				}
				backBtn.click();
			}else{
				return wantFeedbackBtn.isDisplayed();
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean FeedbackHistory() {
//		Mine_LoginPage loginPage = new Mine_LoginPage(driver);
		try {
			feedbackHistoryBtn.click();
//			loginPage.loginSuccess();
//			feedbackHistoryBtn.click();
			String firstQns = feedbackQns.get(0).getAttribute("text");
			if (!firstQns.equals(UIConfig.feedbackContent)) {
				backBtn.click();
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean HotProblem() {
		try {
			hotProblemX.click();
			if (!hotProblemXX.isDisplayed()) {
				backBtn.click();
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
}
