package com.jince.android.config;

import com.jince.android.utility.ConfigUtils;
import com.jince.android.utility.InitEnvPaths;
import com.jince.android.config.ConfigSetUp;
/*
 * 功能：定义框架中使用的配置项参数,通过静态代码块对参数进行复制
 * 作者：Make
 */
public class UIConfig {
	
	static{
		ConfigUtils.autowireConfig(UIConfig.class,ConfigSetUp.configFile );
		EnvPaths = InitEnvPaths.FindEnvPaths();
	}
	public static String account;
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
