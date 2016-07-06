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
 * 功能：通过PageFactory封装【新手学堂】页面元素以及方法
 * 作者：Make
 */
public class Mine_XinSchoolPage extends BasePage{
	MinePage MinePage = new MinePage(driver);
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/web_title_tv")
	private WebElement title;
	@AndroidFindBy(accessibility = "新手入门")
	private WebElement navBarXin;
	@AndroidFindBy(accessibility = "技术指标MACD Link")
	private WebElement xinLink;
	@AndroidFindBy(xpath = "//android.view.View/android.view.View[contains(@index,1)]")
	private WebElement xinLinkX;
	@AndroidFindBy(accessibility = "高手进阶")
	private WebElement narBarGao;
	@AndroidFindBy(accessibility ="波浪理论三大铁律和两个指南 Link")
	private WebElement gaoLink;
	@AndroidFindBy(accessibility = "波浪理论三大铁路：")
	private WebElement gaoLinkX;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/web_back_btn")
	private WebElement backBtn;
	public Mine_XinSchoolPage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15 , TimeUnit.SECONDS), this);
	}

	public boolean xinLink() {
		try {
			xinLink.click();
			if (!xinLinkX.isDisplayed()) {
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean gaoLink() {
		try {
			gaoLink.click();
			if (!gaoLinkX.isDisplayed()) {
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
