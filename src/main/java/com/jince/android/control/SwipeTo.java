package com.jince.android.control;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class SwipeTo {
	
	public void Up(AndroidDriver<WebElement> driver,int during){
		int windth = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		try{
			driver.swipe(windth/2, height*3/4, windth/2, height/4, during);	
		}
		catch(Exception e){
			System.out.println("Exception"+e);
		}
		
	}
	
	public void Down(AndroidDriver<WebElement> driver,int during){
		int windth = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		try{
			driver.swipe(windth/2, height/4, windth/2, height*3/4, during);
		}catch(Exception e){
			System.out.println("Exception"+e);
		}
	}
	
	public void Left(AndroidDriver<WebElement> driver,int during){
		int windth = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		try{
			driver.swipe(windth*3/4, height/2, windth/4, height/2, during);
		}catch(Exception e){
			System.out.println("Exception"+e);
		}	
	}
	
	public void Right(AndroidDriver<WebElement> driver,int during){
		int windth = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		try{
			driver.swipe(windth/4, height/2, windth*3/4, height/2, during);
		}catch(Exception e){
			System.out.println("Exception"+e);
		}		
	}
	
	
}
