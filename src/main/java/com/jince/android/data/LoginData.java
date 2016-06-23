package com.jince.android.data;

import org.testng.annotations.DataProvider;

import com.jince.android.config.UIConfig;
/*
 * 功能：数据层，以二维数组的形式返回测试用例的参数数据
 * 作者：Make
 */
public class LoginData {
	@DataProvider(name="login")
	public static Object[][] login(){
		return new Object[][]{
			{"",""},
			{UIConfig.account,""},
			{"",UIConfig.password},
			{UIConfig.account+"1",UIConfig.password},
			{UIConfig.account,UIConfig.password+"1"},
			{UIConfig.account,UIConfig.password}
		};
	}
}
