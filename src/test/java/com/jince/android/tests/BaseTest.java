package com.jince.android.tests;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;
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
import com.jince.android.utility.ConPrint;
import com.jince.android.config.ConfigSetUp;

public abstract class BaseTest {
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	private ITestContext context;
	public String configFile;
	public AppiumDriverLocalService service = null;
	@BeforeSuite
	public void suiteSetup(){
	}
	
	@AfterSuite
	public void endSuite() {
		
	}
	
	@SuppressWarnings("rawtypes")
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
	        capabilities.setCapability("platformName",UIConfig.platformName);
	        capabilities.setCapability("deviceName",UIConfig.deviceName);
	        capabilities.setCapability("platformVersion", UIConfig.platformVersion);
	        capabilities.setCapability("app", app.getAbsolutePath());
	        capabilities.setCapability("appPackage", UIConfig.appPackage);
	        capabilities.setCapability("appActivity", UIConfig.appActivity);
	        driver = new AndroidDriver(service.getUrl(),capabilities);
	        Thread.sleep(6000);
	        driver.manage().timeouts().implicitlyWait(UIConfig.PageLoadTimeOut, TimeUnit.SECONDS); 
			context.setAttribute("CONTEXT_KEY_DRIVER", driver);
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
	public void setUp(ITestContext context) {
		ConPrint.info("Set up in BaseTest. [Test Class] "+getClass().getSimpleName());			
		beforeClass(context);
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

	protected void beforeClass(ITestContext context){
		
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
