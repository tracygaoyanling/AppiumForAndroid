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
 * 功能：通过PageFactory封装【上金所介绍】页面元素以及方法
 * 作者：Make
 */
public class Mine_SjsIntroPage extends BasePage{
	MinePage MinePage = new MinePage(driver);
	@AndroidFindBy(accessibility = "合约 Link")
	private WebElement heyueLink;
	@AndroidFindBy(accessibility = "延期交收合约与期货合约有何异同？")
	private WebElement heyueLinkX;
	@AndroidFindBy(accessibility = "相同点：")
	private WebElement heyueLinkXX;
	@AndroidFindBy(accessibility = "开户 Link")
	private WebElement kaihuLink;
	@AndroidFindBy(accessibility = "修改密码的时间？")
	private WebElement kaihuLinkX;
	@AndroidFindBy(accessibility = "全天（只要能登录系统就可以）")
	private WebElement kaihuLinkXX;
	@AndroidFindBy(accessibility = "交易 Link")
	private WebElement jiaoyiLink;
	@AndroidFindBy(accessibility = "延期补偿费的概念？")
	private WebElement jiaoyiLinkX;
	@AndroidFindBy(accessibility = "仓支付延期补偿费；")
	private WebElement jiaoyiLinkXX;
	@AndroidFindBy(accessibility = "清算 Link")
	private WebElement qingsuanLink;
	@AndroidFindBy(accessibility = "交易所有多少结算银行？")
	private WebElement qingsuanLinkX;
	@AndroidFindBy(accessibility = "目前金大师支持的上金所签约和结算银行为建设银行。")
	private WebElement qingsuanLinkXX;
	@AndroidFindBy(accessibility = "风控 Link")
	private WebElement fengkongLink;
	@AndroidFindBy(accessibility = "什么情况是账户保证金不足？")
	private WebElement fengkongLinkX;
	@AndroidFindBy(accessibility = "举例如下：")
	private WebElement fengkongLinkXX;
	@AndroidFindBy(accessibility = "交割 Link")
	private WebElement jiaogeLink;
	@AndroidFindBy(accessibility = "个人可以参与的交割品种有哪些？")
	private WebElement jiaogeLinkX;
	@AndroidFindBy(accessibility = "交易所各上市合约与交割品种对应如下：")
	private WebElement jiaogeLinkXX;
	@AndroidFindBy(accessibility = "热点问题 Link")
	private WebElement redianLink;
	@AndroidFindBy(accessibility = "上金所出入金时间和规则？")
	private WebElement redianLinkX;
	@AndroidFindBy(accessibility = "上金所出入金时间和规则：")
	private WebElement redianLinkXX;
	@AndroidFindBy(id="com.jincehuangjin.jindashi:id/web_back_btn")
	private WebElement backBtn;
	public Mine_SjsIntroPage(AndroidDriver<WebElement> driver){
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15 , TimeUnit.SECONDS), this);
	}
	public boolean heYueLink() {
		try {
			heyueLink.click();
			heyueLinkX.click();
			if (!heyueLinkXX.isDisplayed()) {
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean kaiHuLink() {
		try {
			kaihuLink.click();
			kaihuLinkX.click();
			if (!kaihuLinkXX.isDisplayed()) {
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean jiaoYiLink() {
		try {
			jiaoyiLink.click();
			jiaoyiLinkX.click();
			if (!jiaoyiLinkXX.isDisplayed()) {
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean qingSuanLink() {
		try {
			qingsuanLink.click();
			qingsuanLinkX.click();
			if (!qingsuanLinkXX.isDisplayed()) {
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean fengKongLink() {
		try {
			fengkongLink.click();
			fengkongLinkX.click();
			if (!fengkongLinkXX.isDisplayed()) {
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean jiaoGeLink() {
		try {
			jiaogeLink.click();
			jiaogeLinkX.click();
			if (!jiaogeLinkXX.isDisplayed()) {
				return false;
			}
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("No Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean reDianLink() {
		try {
			redianLink.click();
			redianLinkX.click();
			if (!redianLinkXX.isDisplayed()) {
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
