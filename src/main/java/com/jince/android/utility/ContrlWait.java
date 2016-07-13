package com.jince.android.utility;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class ContrlWait {
	/**
	 * sleep 1 second
	 */
	public static void sleep()
	{
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("sleep failed");
			e.printStackTrace();
		}
	}
	public static void sleep(Long time)
	{
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			System.out.println("sleep failed");
			e.printStackTrace();
		}
	}
	/**
	 * wait element until element exists and visible
	 * @param element : WebElement , Control and its child-class
	 * @param driver : AndroidDriver<WebElement>
	 * @param second : a number.how long the search will over time
	 * @return boolean
	 * **/
	public static  boolean wait(Object element,AndroidDriver<WebElement> driver,long second)
	{ 
		final WebElement e = (WebElement)element;
		AndroidDriverWait wait = new AndroidDriverWait(driver,second); 
		try{
		    wait.until(new ExpectedCondition<Boolean>()
		    {  
	           public Boolean apply(AndroidDriver<WebElement> d) 
	           {  
	               return e != null && e.isDisplayed() == true;
	           } 
		    });
		    return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	/**
	 * wait element until element exists and visible
	 * @param element : WebElement , Control and its child-class
	 * @param driver : AndroidDriver<WebElement>
	 * @param second : a number.how long the search will over time
	 * @return boolean
	 * **/
	public static  boolean wait(WebElement element,AndroidDriver<WebElement> driver)
	{
		final WebElement e = (WebElement)element;
		AndroidDriverWait wait = new AndroidDriverWait(driver,30); 
		try{
		    wait.until(new ExpectedCondition<Boolean>()
		    {  
	           public Boolean apply(AndroidDriver<WebElement> d) 
	           {  
	               return e != null && e.isDisplayed() == true;
	           } 
		    });
		    return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	/**
	 * wait element until element not exists or hide
	 * @param element : WebElement , Control and its child-class
	 * @param driver : AndroidDriver<WebElement>
	 * @param second : a number.how long the search will over time
	 * @return boolean
	 * **/
	public static boolean waitVanish(Object element,AndroidDriver<WebElement> driver,long second)
	{
		final WebElement e = (WebElement)element;
		AndroidDriverWait wait = new AndroidDriverWait(driver,second);  
		try{
		    wait.until(new ExpectedCondition<Boolean>()
		    {  
	           public Boolean apply(AndroidDriver<WebElement> d) 
	           {  
	        	   return e == null || e.isDisplayed() == false;
	           } 
		    });
		    return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
}
