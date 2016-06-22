package com.jince.android.tests;

import org.testng.Assert;

import com.jince.android.config.ConfigSetUp;
import com.jince.android.config.UIConfig;

public class Test{
	public static void main(String[] args) {
		ConfigSetUp.configSetup("mainConfig.properties");
		String testString = UIConfig.account+"1";
		String excepText = "150021526861";
		Assert.assertTrue(excepText==testString);
	}
	
}
