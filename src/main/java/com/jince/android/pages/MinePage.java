package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.jince.android.utility.ConPrint;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_home")
	public WebElement homeBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_hq")
	public WebElement hangqingBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_jy")
	public WebElement jiaoyiBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_customer")
	public WebElement kefuBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_wd")
	public WebElement mineBtn;
	
	public MinePage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	public boolean GoToMinePage() {
		try {
			mineBtn.click();
			if(!title.isDisplayed()){
				return false;
			}
			
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean InterfaceCheck(String tx1,String tx2,String tx3,String tx4,
			String tx5,String tx6,String tx7,String tx8,String tx9,String tx10){
		try {
			String titleText = title.getAttribute("text");
			String nicknameText = nicknameBtn.getAttribute("text");
			String sjsIntroText = sjsIntroBtn.getAttribute("text");
			String xinSchoolText = xinSchoolBtn.getAttribute("text");
			String feedbackText = feedbackBtn.getAttribute("text");
			String hotlineText = hotlineBtn.getAttribute("text");
			String pushText = pushSetBtn.getAttribute("text");
			String clearText = clearCacheBtn.getAttribute("text");
			String shareText = shareBtn.getAttribute("text");
			String aboutText = aboutBtn.getAttribute("text");
			if (!(titleText.equals(tx1)
					&&nicknameText.equals(tx2)
					&&sjsIntroText.equals(tx3)
					&&xinSchoolText.equals(tx4)
					&&feedbackText.equals(tx5)
					&&hotlineText.equals(tx6)
					&&pushText.equals(tx7)
					&&clearText.equals(tx8)
					&&shareText.equals(tx9)
					&&aboutText.equals(tx10)
					)) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
//	public boolean openMinePage(){
//		mineBtn.click();
//		nicknameBtn.click();
//		clearCacheBtn
//		loginPage.accountField.sendKeys(UIConfig.phone);
//		loginPage.passwordField.sendKeys(UIConfig.password);
//		loginPage.loginBtn.click();
//		String myName = nicknameBtn.getText();
//		if(myName.contentEquals("make")){
//			return true;
//		}else{
//			return false;
//		}
//	}

}
