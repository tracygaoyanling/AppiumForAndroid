package com.jince.android.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jince.android.data.LoginData;
import com.jince.android.pages.MinePage;
import com.jince.android.pages.Mine_LoginPage;
/*
 * 功能：【登录】页面的测试类，调用【登录】页面的方法进行测试
 * 作者：Make
 */
public class LoginPageTest extends BaseTest{
	private Mine_LoginPage loginPage;
	private MinePage minePage;
	public void beforeClass(){
		minePage = new MinePage(driver);
		minePage.GoToMinePage();
		loginPage = minePage.GoToLoginPage();
	}
	
	@Test
	public void InterfaceTest(){
		boolean result = loginPage.InterfaceCheck("请输入账号", "登录金大师","登  录", "快速注册", "忘记密码");
		Assert.assertTrue(result);
	}
	
	@Test
	public void ExitLoginPageTest(){
		boolean result = loginPage.ExitLoginPage();
		Assert.assertTrue(result);
		loginPage.GoToLoginPage();
	}
	
	@Test(dataProvider="login",dataProviderClass=LoginData.class)
	public void LoginTest(String account,String password){
		boolean result = loginPage.LoginTest(account, password);
		Assert.assertTrue(result);
	}
}
