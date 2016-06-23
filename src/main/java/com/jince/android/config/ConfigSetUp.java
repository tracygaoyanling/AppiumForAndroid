package com.jince.android.config;
/*
 * 功能：获取 file 作为将要使用的配置文件
 * 参数：String file
 * 作者：Make
 * 
 */
public class ConfigSetUp {
	
	public static String configFile = null;
	
	public static String configSetup(String file){
		configFile = file;
		return configFile;
	}
}
