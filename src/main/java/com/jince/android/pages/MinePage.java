package com.jince.android.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.jince.android.utility.ConPrint;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
/*
 * 功能：通过PageFactory封装【我的】页面元素以及方法
 * 作者：Make
 */
public class MinePage extends BasePage {
	
	//using Android UI selectors, accessibility, id, name, class name, tag and xpath to findElement
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/customer_actionbar_title")
	public WebElement title;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_user_nickname_textview")
	public WebElement nicknameBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_segdetails")
	public WebElement sjsIntroBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_newbie")
	public WebElement xinSchoolBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_feedback")
	public WebElement feedbackBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_hotline")
	public WebElement hotlineBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_push_settings")
	public WebElement pushSetBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_clear_cache")
	public WebElement clearCacheBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_shareapp")
	public WebElement shareBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_aboutus")
	public WebElement aboutBtn;
//	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_home")
//	public WebElement homeBtn;
//	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_hq")
//	public WebElement hangqingBtn;
//	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_jy")
//	public WebElement jiaoyiBtn;
//	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_customer")
//	public WebElement kefuBtn;
//	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_wd")
//	public WebElement mineBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/pushsettings_togglebutton")
	private WebElement pushToggleBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/actionbar_back")
	private WebElement backBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/exit_login_btn")
	public WebElement logoutBtn;
	public MinePage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
	
	public boolean InterfaceCheck(String tx1,String tx2,String tx3,
			String tx4,String tx5,String tx6,String tx7,String tx8,String tx9){
		try {
			String titleText = title.getAttribute("text");
			String sjsIntroText = sjsIntroBtn.getAttribute("text");
			String xinSchoolText = xinSchoolBtn.getAttribute("text");
			String feedbackText = feedbackBtn.getAttribute("text");
			String hotlineText = hotlineBtn.getAttribute("text");
			String pushText = pushSetBtn.getAttribute("text");
			String clearText = clearCacheBtn.getAttribute("text");
			String shareText = shareBtn.getAttribute("text");
			String aboutText = aboutBtn.getAttribute("text");
			if (!(titleText.equals(tx1)
					&&sjsIntroText.equals(tx2)
					&&xinSchoolText.equals(tx3)
					&&feedbackText.equals(tx4)
					&&hotlineText.equals(tx5)
					&&pushText.equals(tx6)
					&&clearText.equals(tx7)
					&&shareText.equals(tx8)
					&&aboutText.equals(tx9)
					)) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}

	public Mine_LoginPage GoToLoginPage(){
		try {
			nicknameBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}
		return new Mine_LoginPage(driver);
	}
	
	public Mine_MineCenterPage GoToMineCenterPage(){
		try {
			nicknameBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}
		return new Mine_MineCenterPage(driver);
	}
	
	public Mine_SjsIntroPage GoToSjsIntroPage(){
		try {
			sjsIntroBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}
		return new Mine_SjsIntroPage(driver);
	}
	public Mine_FeedbackPage GoToFeedbackPage(){
		try {
			feedbackBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
		}
		return new Mine_FeedbackPage(driver);
	}

	public boolean pushSetting() {
		try {
			pushSetBtn.click();
			String currentStatus = pushToggleBtn.getAttribute("checked");
			String newStatus;
			if (currentStatus.equals("flase")) {
				pushToggleBtn.click();
				newStatus = pushToggleBtn.getAttribute("checked");
			}else{
				pushToggleBtn.click();
				newStatus = pushToggleBtn.getAttribute("checked");
			}
			backBtn.click();
			return !currentStatus.equals(newStatus);
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
	}
	//退出登录
	public boolean logOut(){
		try {
			GoToMinePage();
			GoToMineCenterPage();
			logoutBtn.click();			
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}

}
