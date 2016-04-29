package com.jince.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
 
public class App {
    private  AndroidDriver  driver;
    
   @BeforeMethod
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "GM_kaihu");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","7N3HPX159U019055");
        capabilities.setCapability("platformVersion", "19");
        //if no need install don't add this
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.jincehuangjin.jindashi");
        //support Chinese 
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        //no need sign
        capabilities.setCapability("noSign", "True");
        capabilities.setCapability("appActivity", "com.jince.home.LanuchActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        
    }
 
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
 
    //@Test
    public void Login(){
        //find login button
    	List<WebElement> ButtonList = driver.findElements(By.className("android.widget.Button"));
        ButtonList.get(0).click();
        //wait for 20s
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //find login userName and password editText 
        driver.findElement(By.className("android.widget.EditText")).sendKeys("111@126.com");
        List<WebElement> textFieldsList=driver.findElements(By.className("android.widget.EditText"));
        textFieldsList.get(1).sendKeys("123456789");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //find ok button byName
        ButtonList.get(1).click();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        
        //find keyword 首页 and verify it is display
        Assert.assertTrue( driver.findElement(By.name("首页")).isDisplayed());
        
        
    }
}
