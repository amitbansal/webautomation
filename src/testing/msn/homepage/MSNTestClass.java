package testing.msn.homepage;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Unit test for simple App.
 */

public class MSNTestClass {
	public WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String testName;
	String fileName;
	Logger log=Logger.getLogger("MSNTestClass.class");
	UtilFunctions util=new UtilFunctions();
	String browsername;
	String testname;
	String imgTag;

	public Constants SuiteConstants=new Constants();	

	
	@BeforeClass
	public void beforeClass(){
	try {
			
			ExcelUtility.setExcelFile(SuiteConstants.File_Path+SuiteConstants.File_Name, SuiteConstants.Sheet_Name);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@DataProvider(name = "markets")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelUtility.getTestData("markets");
		return testData;
	}
	
	
	@Parameters({"browserType"})
	@BeforeMethod
	public void beforeMethod(String browserType, Method method) throws MalformedURLException{	
		driver = util.getDriver(browserType,SuiteConstants.Hub_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	}	
	
	@BeforeTest
	public void beforeTest(ITestContext ctx){
		  testname = ctx.getCurrentXmlTest().getName();
		  
	}
	
	@Test(dataProvider="markets")	
	public void TestOrganicSearch(String URL,String market){		
		driver.get(URL);
	 	HomepageElements.fillSearchBox(driver, "scratch mit");
		HomepageElements.clickSearchButton(driver);
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window		
		driver.switchTo().window(util.getsubWindowHandler(driver));
		Assert.assertTrue((BingSERP.checkElementExist("//*[@id='b_results']/li[@class='b_algo'][1]/h2/a",driver)));
		BingSERP.getFirstSearchResultLink(driver).click();	
		driver.switchTo().window(util.getsubWindowHandler(driver));
		driver.switchTo().window(parentWindowHandler);
		
	}
	
	@Test(dataProvider="markets")	
	public void TestOrganicSearchNew(String URL,String market) {		
		testName=testName+"_"+market;	
		driver.get(URL);
	 	HomepageElements.fillSearchBox(driver, "scratch mit");
		HomepageElements.clickSearchButton(driver);
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window		
		driver.switchTo().window(util.getsubWindowHandler(driver));
		Assert.assertTrue((BingSERP.checkElementExist("//*[@id='b_results']/li[@class='b_algo'][1]/h2/a",driver)));
		BingSERP.getFirstSearchResultLink(driver).click();	
		driver.switchTo().window(util.getsubWindowHandler(driver));
		driver.switchTo().window(parentWindowHandler);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult){
			fileName=SuiteConstants.Screenshot_Path+testName+".png";
		if(testResult.getStatus()==ITestResult.FAILURE){
			util.takeScreenshot(driver, fileName);
			imgTag=test.addScreenCapture(fileName);
			}
			Constants.ImagetagFailTest=imgTag;	
			driver.quit();
			ExcelUtility.closeFile();
		
	}
}