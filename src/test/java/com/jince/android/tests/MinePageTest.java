package com.jince.android.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.pages.MinePage;

public class MinePageTest extends BaseTest{
	MinePage minePage;
	public void beforeClass(){
		minePage = new MinePage(driver);
	}
	@Test
	public void GoToMinePageTest(){
		boolean result = minePage.GoToMinePage();
		Assert.assertTrue(result);
	}
	
	@Test
	public void InterfaceTest(){
		String tx1 = "我的";
		String tx2 = "登录/注册";
		String tx3 = "上金所介绍";
		String tx4 = "新手学堂";
		String tx5 = "意见反馈";
		String tx6 = "电话服务";
		String tx7 = "推送设置";
		String tx8 = "清除缓存";
		String tx9 = "分享APP";
		String tx10 = "关于";
		boolean result = minePage.InterfaceCheck(tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9,tx10);
		Assert.assertTrue(result);
	}
}
