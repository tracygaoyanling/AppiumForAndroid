package com.jince.android.control;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
/*
 * 功能：滑动手机页面，包括上滑、下滑、左滑和右滑
 * 作者：Make
 */
public class SwipeTo {
	private AndroidDriver<WebElement> driver;
	private int windth;
	private int height;
	public SwipeTo(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		this.windth = driver.manage().window().getSize().width;
		this.height = driver.manage().window().getSize().height;
	}
	
	
	public void HqUp(int during){
		try{
			driver.swipe(windth/2, height*5/10, windth/2, height*2/10, during);	
		}
		catch(Exception e){
			System.out.println("Exception"+e);
		}		
	}
	
	public void WithParms(int startX, int startY, int endX, int endY, int during){
		try{
			driver.swipe(startX,startY,endX,endY,during);	
		}
		catch(Exception e){
			System.out.println("Exception"+e);
		}		
	}
	public void Up(int during){
		try{
			driver.swipe(windth/2, height*3/4, windth/2, height/4, during);	
		}
		catch(Exception e){
			System.out.println("Exception"+e);
		}		
	}
	
	public void Down(int during){
		try{
			driver.swipe(windth/2, height/4, windth/2, height*3/4, during);
		}catch(Exception e){
			System.out.println("Exception"+e);
		}
	}
	
	public void Left(int during){
		try{
			driver.swipe(windth*3/4, height/2, windth/4, height/2, during);
		}catch(Exception e){
			System.out.println("Exception"+e);
		}	
	}
	
	public void Right(int during){
		try{
			driver.swipe(windth/4, height/2, windth*3/4, height/2, during);
		}catch(Exception e){
			System.out.println("Exception"+e);
		}		
	}
	
}
