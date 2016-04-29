package com.jince.android.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jince.android.control.SwipeTo;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
 
public class APPTest {
    private  AndroidDriver  driver;
    
   @BeforeMethod
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "gm_autotest.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","7N3HPX159U019055");
        capabilities.setCapability("platformVersion", "19");
        //if no need install don't add this
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.jincehuangjin.jindashi");
        System.out.println("dsds");
        capabilities.setCapability("appActivity", "com.jince.home.LanuchActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(6000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
        
    }
 
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
 
    @Test
    public void Login() throws InterruptedException{
    	SwipeTo swipeTo = new SwipeTo();
    	swipeTo.Left(driver, 0);
    	swipeTo.Left(driver, 0);
    	swipeTo.Left(driver, 0);
    	WebElement enterExperienceBtn = driver.findElementById("com.jincehuangjin.jindashi:id/enter_experience_btn");
    	enterExperienceBtn.click();
    	Thread.sleep(6000);
    	driver.navigate().back();
    	WebElement mine = driver.findElementById("com.jincehuangjin.jindashi:id/tv_wd");
    	mine.click();
    	WebElement nicknameBtn = driver.findElementById("com.jincehuangjin.jindashi:id/mine_user_nickname_textview");
    	nicknameBtn.click();
    	WebElement userName = driver.findElementById("com.jincehuangjin.jindashi:id/login_account_et");
    	WebElement passWord = driver.findElementById("com.jincehuangjin.jindashi:id/login_password_et");
    	userName.sendKeys("15002152686");
    	passWord.sendKeys("654321");
    	WebElement loginBtn = driver.findElementById("com.jincehuangjin.jindashi:id/user_login_btn");
    	loginBtn.click();
    	
    	        //find login button
//    	List<WebElement> ButtonList = driver.findElements(By.className("android.widget.Button"));
//        ButtonList.get(0).click();
//        //wait for 20s
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        
//        //find login userName and password editText 
//        driver.findElement(By.className("android.widget.EditText")).sendKeys("111@126.com");
//        List<WebElement> textFieldsList=driver.findElements(By.className("android.widget.EditText"));
//        textFieldsList.get(1).sendKeys("123456789");
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        
//        //find ok button byName
//        ButtonList.get(1).click();
//        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
//        
//        //find keyword 首页 and verify it is display
//        Assert.assertTrue( driver.findElement(By.name("首页")).isDisplayed());
        
        System.out.println("dsds");
    }
}
