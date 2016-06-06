package com.jince.android.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.config.UIConfig;
import com.jince.android.control.SwipeTo;
//import com.jince.android.tests.BaseTest;
public class APPTest extends BaseTest{
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
    	WebElement mine = driver.findElementById("com.jincehuangjin.jindashi:id/tv_wd");
    	Assert.assertTrue(mine.isDisplayed());
    	mine.click();
    	WebElement nicknameBtn = driver.findElementById("com.jincehuangjin.jindashi:id/mine_user_nickname_textview");
    	Assert.assertTrue(nicknameBtn.isDisplayed());
    	nicknameBtn.click();
    	WebElement userName = driver.findElementById("com.jincehuangjin.jindashi:id/login_account_et");
    	WebElement passWord = driver.findElementById("com.jincehuangjin.jindashi:id/login_password_et");
    	userName.sendKeys(UIConfig.phone);
    	passWord.sendKeys(UIConfig.password);
    	WebElement loginBtn = driver.findElementById("com.jincehuangjin.jindashi:id/user_login_btn");
    	Assert.assertTrue(loginBtn.isDisplayed());
    	loginBtn.click();
    	
        
        System.out.println("dsds");
    }
}