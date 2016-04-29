package com.jince.android.config;
import com.jince.android.utility.ConfigUtils;
import com.jince.android.config.ConfigSetUp;
public class UIConfig {
	static{
		ConfigUtils.autowireConfig(UIConfig.class,ConfigSetUp.configFile );
	}
	public static String phone;
	public static String password;
	public static int test;

}
