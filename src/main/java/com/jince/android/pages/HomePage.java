package com.jince.android.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jince.android.control.GeneralMethod;
import com.jince.android.control.SwipeTo;
import com.jince.android.utility.ConPrint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BasePage{
	MinePage minePage = new MinePage(driver);
	SwipeTo swipeTo = new SwipeTo(driver);
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/home_actionbar_title")
	private WebElement title;
	@AndroidFindBy(name = "热门交易品")
	private WebElement rmjyp;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/textview_home_quote_more")
	private WebElement quoteMoreBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/home_quote_first_name")
	private WebElement quoteFirst;
	@AndroidFindBy(name ="金牌直播")
	private WebElement jpzb;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/textview_home_room_more")
	private WebElement roomMoreBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/textview_home_room_item_title")
	private List<WebElement> roomItemTitles;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/channel_name")
	private List<WebElement> roomChannelNames;
	//**************直播室页面元素**************//
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/home_title")
	private WebElement roomTitle;
	@AndroidFindBy(id ="com.jincehuangjin.jindashi:id/home_left")
	private WebElement roomBackBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_title")
	private WebElement hqTitle;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/iv_arrow_contract")
	private WebElement hqDownBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_cancel")
	private WebElement hqCancelBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/tv_ok")
	private WebElement hqSaveBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/iv_up_arrow")
	private WebElement hqUpBtn;
	@AndroidFindBy(name = "今开: ")
	private WebElement hqJinKai;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/word_zbs_live_menu")
	private WebElement liveMenu;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/word_zbs_interact_menu")
	private WebElement interactMenu;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/etInputKeyWords")
	private WebElement hdField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/send_btn")
	private WebElement hdSendBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/word_zbs_order_menu")
	private WebElement orderMenu;
	@AndroidFindBy(id ="com.jincehuangjin.jindashi:id/order_today")
	private WebElement orderTodayBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/buytype")
	private List<WebElement> buyType;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/order_week")
	private WebElement orderWeekBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/word_zbs_note_menu")
	private WebElement noteMenu;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/note_rg_all")
	private WebElement rgall;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/note_rg_has_reply")
	private WebElement rgHasReply;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/note_rg_not_reply")
	private WebElement rgNotReply;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/note_etInputKeyWords")
	private WebElement noteInputField;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/note_send_btn")
	private WebElement noteSendBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/left_rela")
	private WebElement backBtn;
	//**************************************//
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/textview_home_news_gold")
	private WebElement hjzx;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/textview_home_goldnews_item_title")
	private List<WebElement> newsItems;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/web_title_tv")
	private WebElement newsTitle;
	@AndroidFindBy(id ="com.jincehuangjin.jindashi:id/web_share_btn")
	private WebElement shareBtn;
	@AndroidFindBy(id ="com.jincehuangjin.jindashi:id/custom_share_pane_cancel")
	private WebElement cancelBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/web_back_btn")
	private WebElement newsbackBtn;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/textview_home_news_finance")
	private WebElement cjrl;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/layout_home_finance_calendar")
	private WebElement calendar;
	@AndroidFindBy(id = "com.jincehuangjin.jindashi:id/textview_home_finance_index_item_title")
	private List<WebElement> financeItems;
	public HomePage(AndroidDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}
	public boolean Interface() {
		try {
			if ((title.getAttribute("text").equals("金大师")&&rmjyp.isDisplayed()&&jpzb.isDisplayed())) {
				swipeTo.Up(0);
				 return hjzx.getAttribute("text").equals("黄金资讯")&&cjrl.getAttribute("text").equals("财经日历");
			}else {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("NO Such Element", ex);
			return false;
		}
	}
	public boolean HotMarket() throws InterruptedException {
		try {
			swipeTo.Down(0);
			Thread.sleep(4000);
			HangQingPage hangQingPage = new HangQingPage(driver);
			JiaoYiPage jiaoYiPage = new JiaoYiPage(driver);
			String quoteFirstTx = quoteFirst.getAttribute("text");
			quoteFirst.click();
			String hqTitleTx = hangQingPage.hqTitle.getAttribute("text");
			if (!hqTitleTx.contains(quoteFirstTx)) {
				minePage.GoToHomePage();
				return false;
			}
			hangQingPage.backBtn.click();
			quoteMoreBtn.click();
			hangQingPage.tip.click();
			if (!hangQingPage.title.isDisplayed()) {
				minePage.GoToHomePage();
				return false;
			}
			minePage.GoToHomePage();
			GeneralMethod generalMethod = new GeneralMethod();
			generalMethod.LongPress(driver, quoteFirst);
			if (!jiaoYiPage.tradePwd.isDisplayed()) {
				return false;
			}
			minePage.GoToHomePage();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("NO Such Element", ex);
			return false;		
		}
		return true;
	}
	public boolean LiveRoomEnter1() throws InterruptedException {
		try {
			swipeTo.Down(0);
			swipeTo.Down(0);
			Thread.sleep(5000);
//			swipeTo.HqUp(0);
			String roomNameExp = roomItemTitles.get(0).getAttribute("text");
			roomItemTitles.get(0).click();
			String roomRst = roomTitle.getAttribute("text");
			roomBackBtn.click();
			return roomNameExp.equals(roomRst);
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("NO Such Element", ex);
			return false;
		}
	}
	public boolean LiveRoomEnter2() {
		try {
			roomMoreBtn.click();
			String roomNameExp = roomChannelNames.get(0).getAttribute("text");
			roomChannelNames.get(0).click();
			String roomRst = roomTitle.getAttribute("text");
			return roomNameExp.equals(roomRst);
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("NO Such Element", ex);
			return false;
		}
	}
	public boolean LiveRoom(){
		try {
			hqDownBtn.click();
			swipeTo.WithParms(360, 1250, 360, 1010, 3000);
			hqSaveBtn.click();
			String hqTx = hqTitle.getAttribute("text");//获取当前的行情名称
			hqDownBtn.click();
			swipeTo.WithParms(360, 1010, 360, 1250, 3000);
			hqSaveBtn.click();
			hqDownBtn.click();
			swipeTo.WithParms(360, 1250, 360, 1010, 3000);
			hqSaveBtn.click();
			String hqTxNew = hqTitle.getAttribute("text");//获取当前的行情名称
			if (!hqTx.equals(hqTxNew)) {
				return false;
			}
			hqUpBtn.click();
			if (hqJinKai.isDisplayed()) {
				hqUpBtn.click();
			}else{
				return false;
			}
			interactMenu.click();
			hdField.sendKeys("15002152686");
			hdSendBtn.click();
			hdField.sendKeys("For Auto test");
			hdSendBtn.click();
			driver.findElement(By.name("For Auto test"));
			orderMenu.click();
			if (!buyType.isEmpty()) {
				String handanTx = buyType.get(0).getAttribute("text");
				orderWeekBtn.click();
				String handanTx2 = buyType.get(0).getAttribute("text");
				if (!handanTx.equals(handanTx2)) {
					return false;
				}
			}else {
				orderWeekBtn.click();
			}
			orderTodayBtn.click();
			noteMenu.click();
			rgHasReply.click();
			rgNotReply.click();
			rgall.click();
			noteInputField.sendKeys("For Auto test");
			noteSendBtn.click();
			driver.findElement(By.name("For Auto test"));
			liveMenu.click();
			backBtn.click();
			backBtn.click();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("NO Such Element", ex);
			return false;
		}
		return true;
	}
	public boolean News() throws InterruptedException {
		try {
			swipeTo.Down(0);
			Thread.sleep(4000);
			swipeTo.Up(0);
			String newsTx = newsItems.get(0).getAttribute("text");
			newsItems.get(0).click();
			String newsTitleTx = newsTitle.getAttribute("text");
			if (!newsTx.contains(newsTitleTx)) {
				return false;
			}
			shareBtn.click();
			cancelBtn.click();
			newsbackBtn.click();
			return hjzx.isDisplayed();
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("NO Such Element", ex);
			return false;
		}
	}
	public boolean Finance() throws InterruptedException {
		try {
			swipeTo.Down(0);
			Thread.sleep(4000);
			swipeTo.Up(0);
			cjrl.click();
			if ((!calendar.isDisplayed())&&financeItems.isEmpty()) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			ConPrint.failMessage("NO Such Element", ex);
			return false;
		}
		return true;
	}
}
