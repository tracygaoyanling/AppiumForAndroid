package com.jince.android.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.jince.android.control.SwipeTo;
import com.jince.android.pages.MinePage;

public class APPTestDemo extends BaseTest{
	
	MinePage minePage;
	public void beforeClass(ITestContext context){
    	minePage = new MinePage(driver);
	}
    @Test
    public void Login() throws InterruptedException{
    	SwipeTo swipeTo = new SwipeTo();
    	swipeTo.Left(driver, 0);
    	swipeTo.Left(driver, 0);
    	swipeTo.Left(driver, 0);
    	WebElement enterExperienceBtn = driver.findElementById("com.jincehuangjin.jindashi:id/enter_experience_btn");
    	enterExperienceBtn.click();
    	Thread.sleep(6000);
    	driver.navigate().back();
    	boolean result = minePage.openMinePage();
    	Assert.assertTrue(result);
    	Thread.sleep(6000);	
    }
}
