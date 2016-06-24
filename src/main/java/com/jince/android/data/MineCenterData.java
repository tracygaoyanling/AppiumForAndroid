package com.jince.android.data;

import org.testng.annotations.DataProvider;
import com.jince.android.utility.GenerateData;

public class MineCenterData {
	@DataProvider(name="NickName")
	public static Object[][] changeName(){
		return new Object[][]{
			{"wrong",""},
			{"wrong","11111111111111"},
			{"wrong","m@ke"},
			{"wrong","make11111"},
			{"wrong","maken"},
			{"right",GenerateData.getRandomString(4)}
		};
	}
	
	@DataProvider(name="PwdData")
	public static Object[][] changePwd(){
		return new Object[][]{
			{"wrong","8888887","666666","666666"},//原密码错误
			{"wrong","888888","666666","6666667"},//新密码和确认密码不一致
			{"wrong","888888","66666","666666"},//新密码和确认密码不一致
			{"wrong","888888","888888","888888"},//新密码和原密码一致
			{"right","888888","666666","666666"},//更改密码
			{"right","666666","888888","888888"},//重置密码
		};
	}
}
