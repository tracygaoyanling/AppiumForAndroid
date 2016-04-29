package com.jince.android.util;

public class ConPrint {
	public static int foundErrors = 0;
	public static void info(String str){
		System.out.println("[**INFO**] "+str);
	}
	
	public static void error(String str){
		System.out.println("[**ERROR**] "+str);
		foundErrors += 1;
	}
}
