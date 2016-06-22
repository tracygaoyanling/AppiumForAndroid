package com.jince.android.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Mine_SjsIntroPage extends BasePage{
	MinePage MinePage = new MinePage(driver);
	@AndroidFindBy(accessibility = "合约 Link")
	public WebElement heyueLink;
	@AndroidFindBy(accessibility = "延期交收合约与期货合约有何异同？")
	public WebElement heyueLinkX;
	@AndroidFindBy(accessibility = "相同点：")
	public WebElement heyueLinkXX;
	@AndroidFindBy(accessibility = "开户 Link")
	public WebElement kaihuLink;
	@AndroidFindBy(accessibility = "修改密码的时间？")
	public WebElement kaihuLinkX;
	@AndroidFindBy(accessibility = "全天（只要能登录系统就可以）")
	public WebElement kaihuLinkXX;
	@AndroidFindBy(accessibility = "交易 Link")
	public WebElement jiaoyiLink;
	@AndroidFindBy(accessibility = "延期补偿费的概念？")
	public WebElement jiaoyiLinkX;
	@AndroidFindBy(accessibility = "仓支付延期补偿费；")
	public WebElement jiaoyiLinkXX;
	@AndroidFindBy(accessibility = "清算 Link")
	public WebElement qingsuanLink;
	@AndroidFindBy(accessibility = "交易所有多少结算银行？")
	public WebElement qingsuanLinkX;
	@AndroidFindBy(accessibility = "目前金大师支持的上金所签约和结算银行为建设银行。")
	public WebElement qingsuanLinkXX;
	@AndroidFindBy(accessibility = "风控 Link")
	public WebElement fengkongLink;
	@AndroidFindBy(accessibility = "什么情况是账户保证金不足？")
	public WebElement fengkongLinkX;
	@AndroidFindBy(accessibility = "举例如下：")
	public WebElement fengkongLinkXX;
	@AndroidFindBy(accessibility = "交割 Link")
	public WebElement jiaogeLink;
	@AndroidFindBy(accessibility = "个人可以参与的交割品种有哪些？")
	public WebElement jiaogeLinkX;
	@AndroidFindBy(accessibility = "交易所各上市合约与交割品种对应如下：")
	public WebElement jiaogeLinkXX;
	@AndroidFindBy(accessibility = "热点问题 Link")
	public WebElement redianLink;
	@AndroidFindBy(accessibility = "上金所出入金时间和规则？")
	public WebElement redianLinkX;
	@AndroidFindBy(accessibility = "上金所出入金时间和规则：")
	public WebElement redianLinkXX;
	
	public Mine_SjsIntroPage(AndroidDriver<WebElement> driver){
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5 , TimeUnit.SECONDS), this);
	}
	public boolean GoToSjsIntroPage(){
		MinePage.sjsIntroBtn.click();
		if (heyueLink.isDisplayed()) {
			return true;
		}else{
			return false;
		}
	}
}
