package com.jince.android.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
//using Android UI selectors, accessibility, id, name, class name, tag and xpath to findElement
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.jince.android.config.UIConfig;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class MinePage extends BasePage {
	
	LoginPage loginPage = new LoginPage(driver);
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/customer_actionbar_title")
	public WebElement title;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_user_nickname_textview")
	public WebElement nicknameBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_segdetails")
	public WebElement sjsIntroBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/mine_newbie")
	public WebElement newbieSchoolBtn;
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
	
	public MinePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	public boolean openMinePage(){
		mineBtn.click();
		nicknameBtn.click();
		loginPage.accountField.sendKeys(UIConfig.phone);
		loginPage.passwordField.sendKeys(UIConfig.password);
		loginPage.loginBtn.click();
		String myName = nicknameBtn.getText();
		if(myName.contentEquals("make")){
			return true;
		}else{
			return false;
		}
	}

}
