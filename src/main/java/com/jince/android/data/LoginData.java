package com.jince.android.data;

import org.testng.annotations.DataProvider;

import com.jince.android.config.UIConfig;

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
