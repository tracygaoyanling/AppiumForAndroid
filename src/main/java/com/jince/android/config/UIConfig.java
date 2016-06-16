package com.jince.android.config;

import com.jince.android.utility.ConfigUtils;
import com.jince.android.utility.InitEnvPaths;
import com.jince.android.config.ConfigSetUp;

public class UIConfig {
	
	static{
		ConfigUtils.autowireConfig(UIConfig.class,ConfigSetUp.configFile );
		EnvPaths = InitEnvPaths.FindEnvPaths();
	}
	public static String phone;
	public static String password;
	public static String[] EnvPaths;
	public static String nodePath;
	public static String appiumPath;
	public static String platformName;
	public static String deviceName;
	public static String platformVersion;
	public static String appPackage;
	public static String appActivity;
	public static long PageLoadTimeOut;
}
