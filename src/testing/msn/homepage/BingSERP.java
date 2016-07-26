package testing.msn.homepage;
import org.openqa.selenium.*;
import org.testng.log4testng.Logger;

public class BingSERP {
	public static WebElement element = null;
	static Logger log = Logger.getLogger(BingSERP.class);
	
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static Boolean checkElementExist(String value, WebDriver driver) {
		Boolean present=false;
		element=driver.findElement(By.xpath(value));
		present=true;
		
		return present;
	}
	
	public static WebElement getFirstSearchResultLink(WebDriver driver){
		element=driver.findElement(By.xpath("//*[@id='b_results']/li[@class='b_algo'][1]/h2/a"));
		return element;
		
	}
	
}
