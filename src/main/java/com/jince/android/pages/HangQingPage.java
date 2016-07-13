package com.jince.android.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.jince.android.control.SwipeTo;
import com.jince.android.utility.ConPrint;
import com.jince.android.utility.ContrlWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HangQingPage extends BasePage{
	//行情首页
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tip")
	public WebElement tip;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_left")
	private WebElement editBtn;
	@AndroidFindBy(id ="com.jincehuangjin.jindashi:id/right_bt")
	private WebElement searchBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_title")
	public WebElement title;
	@AndroidFindBy(xpath ="//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
	private List<WebElement> hgTabLists;
	@AndroidFindBy(name = "全部")
	private WebElement all;
	@AndroidFindBy(name = "最新价")
	private WebElement newPrice;
	@AndroidFindBy(name = "涨跌幅")
	private WebElement zdf;
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout")
	public List<WebElement> hgLists;
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.RelativeLayout")
	private List<WebElement> sDataLists;
	//行情详情页面
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_title")
	public WebElement hqTitle;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/ibtn_back")
	public WebElement backBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/web_title_tv")
	public WebElement sDateTitle;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/web_back_btn")
	private WebElement webBackBtn;
	public HangQingPage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10,TimeUnit.SECONDS), this);
	}
	public boolean Interface() {
		try {
			if (!(editBtn.getAttribute("text").equals("编辑")&&title.getAttribute("text").equals("自选")
					&&all.isDisplayed()&&newPrice.isDisplayed()&&zdf.isDisplayed())) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			Reporter.log("No Such Element");
			return false;
		}
		return true;
	}
	public boolean SwitchHqTab() {
		try {
			for (WebElement hgTab : hgTabLists) {
				String hgTabTx = hgTab.getAttribute("text");
				hgTab.click();
				if (!hgTabTx.equals("特色数据")) {
					ConPrint.info("Current Tab is "+hgTabTx);
					String hgTx = hgLists.get(0).findElement(By.id("com.jincehuangjin.jindashi:id/tv_title")).getAttribute("text");
					hgLists.get(0).click();
					String hgExpTx = hqTitle.getAttribute("text");
					ConPrint.info("Current opened Page is "+hgExpTx);
					if (!hgExpTx.contains(hgTx)) {
						backBtn.click();
						return false;
					}
					backBtn.click();
				}else{
					ConPrint.info("Current Tab is "+hgTabTx);
					String hgTx = sDataLists.get(0).findElement(By.id("com.jincehuangjin.jindashi:id/tv_title")).getAttribute("text");
					sDataLists.get(0).click();
					String hgExpTx = sDateTitle.getAttribute("text");
					ConPrint.info("Current opened Page is "+hgExpTx);
					webBackBtn.click();
					return hgExpTx.equals(hgTx);
				}
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	
	public boolean SwipeHqTab() {
		try {
			SwipeTo swipeTo = new SwipeTo(driver);
			hgTabLists.get(0).click();
			for (WebElement hgTab : hgTabLists) {
				String hgTabTx = hgTab.getAttribute("text");
					ConPrint.info("Current Tab is "+hgTabTx);
					String hgExpTx = title.getAttribute("text");
					ConPrint.info("Current Title is "+hgExpTx);
					if (!hgExpTx.equals(hgTabTx)) {
						return false;
					}
					swipeTo.Left(0);
					ContrlWait.sleep((long) 3000);
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}

}
