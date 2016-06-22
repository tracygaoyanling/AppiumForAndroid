package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jince.android.control.SwipeTo;
import com.jince.android.utility.ConPrint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GuidePage extends BasePage{
	
	MinePage minePage = new MinePage(driver);
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/enter_experience_btn")
	public WebElement enterExperienceBtn;
	
	public GuidePage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		}
	
	public boolean EnterAPP(){
		try {
			SwipeTo swipeTo = new SwipeTo();
	    	swipeTo.Left(driver, 0);
	    	swipeTo.Left(driver, 0);
	    	swipeTo.Left(driver, 0);
	    	enterExperienceBtn.click();
	    	Thread.sleep(6000);
	    	GoBack();
//	    	if(!minePage.homeBtn.isDisplayed()){
//	    		return false;
//	    	}
		} catch (InterruptedException ex) {
			ConPrint.failMessage("InterruptedException", ex);
			return false;
		}
		return true;
	}
}
