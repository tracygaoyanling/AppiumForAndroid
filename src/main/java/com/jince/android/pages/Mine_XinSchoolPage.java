package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
/*
 * 功能：通过PageFactory封装【新手学堂】页面元素以及方法
 * 作者：Make
 */
public class Mine_XinSchoolPage extends BasePage{
	MinePage MinePage = new MinePage(driver);
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/web_title_tv")
	public WebElement title;
	@AndroidFindBy(accessibility = "新手入门")
	public WebElement navBarXin;
	@AndroidFindBy(accessibility = "技术指标MACD Link")
	public WebElement xinLink;
	@AndroidFindBy(xpath = "\\android.view.View[contains(@contend-desc,'计算公式')]")
	public WebElement xinLinkX;
	@AndroidFindBy(accessibility = "高手进阶")
	public WebElement narBarGao;
	@AndroidFindBy(accessibility ="波浪理论三大铁律和两个指南 Link")
	public WebElement laoLink;
	@AndroidFindBy(accessibility = "波浪理论三大铁路：")
	public WebElement laoLinkX;
	public Mine_XinSchoolPage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15 , TimeUnit.SECONDS), this);
	}
	public boolean GoToNewbieSchoolPage() {
		MinePage.xinSchoolBtn.click();
		if(xinLink.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
}
