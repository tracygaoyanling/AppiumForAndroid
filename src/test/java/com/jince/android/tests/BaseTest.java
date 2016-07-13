package com.jince.android.tests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
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
import com.jince.android.config.CapabilitiesFactory;
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
		ConPrint.info("Running BaseTest BeforeSuite...");
	}
	
	@AfterSuite
	public void endSuite() {
		ConPrint.info("Running BaseTest AfterSuite...");
	}
	
	@BeforeTest
	public void setUpDriver(ITestContext context){
		ConPrint.testName(context.getCurrentXmlTest().getName());
		init();
		try{
			if(UIConfig.EnvPaths.length<2){
				ConPrint.info("Use Path Config in Properties...");
				System.setProperty(AppiumServiceBuilder.NODE_PATH ,UIConfig.nodePath);
				System.setProperty(AppiumServiceBuilder.APPIUM_PATH ,UIConfig.appiumPath);
			}else{
				ConPrint.info("Use Path found by code...");
				System.setProperty(AppiumServiceBuilder.NODE_PATH ,UIConfig.EnvPaths[0]);
				System.setProperty(AppiumServiceBuilder.APPIUM_PATH ,UIConfig.EnvPaths[1]);
			}
			service = new AppiumServiceBuilder().usingAnyFreePort().withArgument(GeneralServerFlag.LOG_LEVEL, "error").build();
			service.start();
	        if (service == null || !service.isRunning()) {
	            throw new RuntimeException("An appium server node is not started!");
	        }
			this.context = context;
	        driver = new AndroidDriver<WebElement>(service.getUrl(),CapabilitiesFactory.getCapabilities());
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
    public void beforeTestCase() throws Exception {
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
		ConPrint.info("Running BaseTest AfterMethod...");
	}

	protected void beforeClass(){
		ConPrint.info("Running BaseTest BeforeClass...");
	}

	protected void afterClass(){
		ConPrint.info("Running BaseTest AfterClass...");
	}
	
	protected void beforeTest(){
		ConPrint.info("Running BaseTest BeforeTest...");
	}
	
	protected void afterTest(){
		ConPrint.info("Running BaseTest AfterTest...");
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
