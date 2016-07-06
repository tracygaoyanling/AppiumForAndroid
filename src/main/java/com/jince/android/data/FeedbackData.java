package com.jince.android.data;

import org.testng.annotations.DataProvider;

import com.jince.android.utility.GenerateData;

/*
 * 功能：数据层，以二维数组的形式返回测试用例的参数数据
 * 作者：Make
 */
public class FeedbackData {
	@DataProvider(name="Feedback")
	public static Object[][] changeName(){
		String content = GenerateData.getRandomString(10);
		return new Object[][]{
			{"wrong","150",""},
			{"wrong","150021526861",""},
			{"wrong","15002152686","测试"},
			{"right","15002152686",content},
		};
	}
}
