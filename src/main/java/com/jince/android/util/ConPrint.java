package com.jince.android.util;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;


public class ConPrint {
public static int foundErrors = 0;
	
	/**
	 * 
	 * @param str
	 */
	public static void info(String str){
		System.out.println("[*INFO*] "+str);
	}
	
	public static void test(String str){
		System.out.println("[STARTING TESTCASE: "+str+"]");
	}
	
	public static void success(String str){
		System.out.println("[TEST SUCESSFUL: "+str+"]");
	}
	
	public static void success(){
		System.out.println("[TEST SUCESSFUL]");
	}
	
	public static void testName(String str){
		System.out.println("********************************************");
		System.out.println("[STARTING TEST: "+str+"]");
		System.out.println("********************************************");
	}
	
	public static void fail(String str)
	{
		System.out.println("[TEST FAILURE: "+str+"]");
	}
	
	public static void failMessage(String str, Throwable throwable)
	{
		fail(str);
		Assert.fail(throwable.getLocalizedMessage());
	}
	
	
	/**
	 * 
	 * @param str
	 */
	public static void warn(String str){
		System.out.println("[**WARN**] "+str);
	}
	
	/**
	 * 
	 * @param str
	 */
	public static void error(String str){
//		int line = Thread.currentThread().getStackTrace()[3].getLineNumber();
		System.err.println("[**ERROR**] "+str);
		foundErrors += 1;
		
	}
	
	/**
	 * 
	 * @param str
	 * @param throwable
	 */
	public static void error(String str, Throwable throwable){
		error(str);
		throwable.printStackTrace();
		divider();
	}
	
	/**
	 * 
	 * @param str
	 * @param throwable
	 * @param driver
	 */
	public static void error(String str, Throwable throwable, WebDriver driver){
		error(str, driver);
	}
	
	/**
	 * 
	 * @param str
	 * @param driver
	 */
	public static void error(String str, WebDriver driver){
		error(str);
		System.out.println(driver.getCurrentUrl());
	}
	
	/**
	 * 
	 * @param str
	 * @param throwable
	 */
	public static void errorAndSkip(String str, Throwable throwable){
		error(str, throwable);
		throw new SkipException("Skipping Test.");
		
	}
	
	/**
	 * 
	 * @param str
	 * @param throwable
	 */
	public static void errorAndSkip(String str){
		error(str);
		throw new SkipException("Skipping Test.");
		
	}
	
	public static void pageSnapShot(WebDriver driver){
		error("Page Url: "+driver.getCurrentUrl());
		error("Page Title: "+driver.getTitle());
	}
	
	public static void loading(){
		String temp = ".";
		System.out.print(temp);
	}
	
	public static void endLoading(){
		System.out.println("");
	}
	
	public static void divider(){
		System.out.println("************************************************************");
		System.out.println("");
	}
	
	public static int getFoundErrors(){
		return foundErrors;
	}
}
