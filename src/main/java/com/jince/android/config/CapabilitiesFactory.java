package com.jince.android.config;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesFactory {
	 protected static DesiredCapabilities capabilities;

	    public static DesiredCapabilities getCapabilities() throws Exception {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("platformName",UIConfig.platformName);//要测试的手机操作系统
	        capabilities.setCapability("deviceName",UIConfig.deviceName);//使用的手机设备名称
	        capabilities.setCapability("platformVersion", UIConfig.platformVersion);//手机操作系统版本
	        if (UIConfig.needInstall) {
	        	File classpathRoot = new File(System.getProperty("user.dir"));
		        File appDir = new File(classpathRoot, "apps");
		        File app = new File(appDir, "gm_autotest.apk");
		        capabilities.setCapability("app", app.getAbsolutePath());//未安装应用时，设置App的路径
			}
	        capabilities.setCapability("appPackage", UIConfig.appPackage);//待测试的app的java package
	        capabilities.setCapability("appActivity", UIConfig.appActivity);//待测试的app的Activity名字
	        capabilities.setCapability("unicodeKeyboard" ,"True");//使用unicode编码
	        capabilities.setCapability("resetKeyboard", "True");//结束后reset设备默认输入法
	    	return capabilities;
	    }
}
