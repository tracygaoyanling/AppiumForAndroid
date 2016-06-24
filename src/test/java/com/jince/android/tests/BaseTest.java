package com.jince.android.tests;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import com.jince.android.config.UIConfig;
import com.jince.android.pages.GuidePage;
import com.jince.android.utility.ConPrint;
import com.jince.android.config.ConfigSetUp;
/*
 * 功能：基本测试类，其他测试子类都继承于该父类。定义了测试所需的基本属性以及方法
 * 		执行顺序@BeforeSuite->@BeforeTest->@BeforeClass->@BeforeMethod
 * 作者：Make
 */
public abstract class BaseTest {
	
	protected static AndroidDriver<WebElement> driver;
	private ITestContext context;
	private String configFile;
	private AppiumDriverLocalService service = null;
	@BeforeSuite
	public void suiteSetup(){
	}
	
	@AfterSuite
	public void endSuite() {
		
	}
	
	@BeforeTest
	public void setUpDriver(ITestContext context){
		ConPrint.testName(context.getCurrentXmlTest().getName());
		init();
		try{
			if(UIConfig.EnvPaths==null){
				System.setProperty(AppiumServiceBuilder.NODE_PATH ,UIConfig.nodePath);
				System.setProperty(AppiumServiceBuilder.APPIUM_PATH ,UIConfig.appiumPath);
			}else{
				System.setProperty(AppiumServiceBuilder.NODE_PATH ,UIConfig.EnvPaths[0]);
				System.setProperty(AppiumServiceBuilder.APPIUM_PATH ,UIConfig.EnvPaths[1]);
			}
			System.setProperty(AppiumServiceBuilder.NODE_PATH ,UIConfig.nodePath);
			System.setProperty(AppiumServiceBuilder.APPIUM_PATH ,UIConfig.appiumPath);
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
	        if (service == null || !service.isRunning()) {
	            throw new RuntimeException("An appium server node is not started!");
	        }
			this.context = context;
			beforeTest(context);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "apps");
	        File app = new File(appDir, "gm_autotest.apk");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("platformName",UIConfig.platformName);//要测试的手机操作系统
	        capabilities.setCapability("deviceName",UIConfig.deviceName);//使用的手机设备名称
	        capabilities.setCapability("platformVersion", UIConfig.platformVersion);//手机操作系统版本
	        capabilities.setCapability("app", app.getAbsolutePath());//未安装应用时，设置App的路径
	        capabilities.setCapability("appPackage", UIConfig.appPackage);//待测试的app的java package
	        capabilities.setCapability("appActivity", UIConfig.appActivity);//待测试的app的Activity名字
	        capabilities.setCapability("unicodeKeyboard" ,"True");//使用unicode编码
	        capabilities.setCapability("resetKeyboard", "True");//结束后reset设备默认输入法
	        driver = new AndroidDriver<WebElement>(service.getUrl(),capabilities);
	        Thread.sleep(6000);
	        driver.manage().timeouts().implicitlyWait(UIConfig.PageLoadTimeOut, TimeUnit.SECONDS); //设置隐形等待时间
			context.setAttribute("CONTEXT_KEY_DRIVER", driver);
			GuidePage guidePage = new GuidePage(driver);
			guidePage.EnterAPP();
		}catch(Exception ex){
			ConPrint.error("setup error", ex);
		}
	}
	
	@AfterTest
	public void endTest(ITestContext context){
		if(ConPrint.getFoundErrors()!=0){
			ConPrint.warn("ERRORS FOUND: "+ConPrint.getFoundErrors());
		}
		try{
			afterTest();
			quitDriver();
			quitService();
			System.out.println("[**TEST COMPLETED**]\n\n");
		}catch(Exception ex){
			ConPrint.error("Finalizing Test error in BaseTest.");
		}
	}
	
	@BeforeClass
	public void setUp() {
		ConPrint.info("Set up in BaseTest. [Test Class] "+getClass().getSimpleName());			
		beforeClass();
	}
	
	@AfterClass
	public void tearDown(){
		ConPrint.info("Tear Down in BaseTest.[Test Class] "+getClass().getSimpleName());
		afterClass();
	}

	@BeforeMethod
    public void open_Url() throws Exception {
		beforeMethod();
	}
	
	@AfterMethod
	public void afterTestCase() {
		afterMethod();
	}
	
	protected void beforeMethod(){
		ConPrint.info("Running BaseTest BeforeMethod...");
	}
	
	protected void afterMethod(){
		
	}

	protected void beforeClass(){
		
	}

	protected void afterClass(){
	
	}
	
	protected void beforeTest(ITestContext context){
		
	}
	
	protected void afterTest(){
		
	}
	
	protected void quitDriver() {
		ConPrint.info("Quitting out of main WebDriver.");
		if (driver != null) {
			driver.quit();
			context.removeAttribute("CONTEXT_KEY_DRIVER");
		}
	}
	protected void quitService(){
		ConPrint.info("Quitting out of Appium Service.");
		if(service != null){
			service.stop();
		}
	}
	
	public void init(){
		ConPrint.info("Initializing BaseTest...");
		if(!(configFile==null)){
			ConfigSetUp.configSetup(this.configFile);
			ConPrint.info("Config file being used is set to default: "+configFile);
		}else{
			ConfigSetUp.configSetup("mainConfig.properties");
			ConPrint.info("Config file being used is set to default: mainConfig");
		}
		
	}
	
}
