package testing.msn.homepage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class HomepageElements {
	public static WebElement element = null;
	static Logger log = Logger.getLogger(HomepageElements.class);

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement searchBoxBing(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
		log.info("Search on Bing search box element found");
		return element;
	}

	/**
	 * 
	 * @param driver
	 * @param searchString
	 */
	public static void fillSearchBox(WebDriver driver, String searchString) {
		element = searchBoxBing(driver);
		element.sendKeys(searchString);
		log.info("Enter origin city as " + searchString);
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */

	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.id("sb_form_go"));
		log.info("Search button on MSN found");
		return element;

	}

	/**
	 * 
	 * @param driver
	 */
	public static void clickSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
		log.info("Search button clicked");
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement marketDropdown(WebDriver driver) {
		element = driver.findElement(By.id("site-market"));
		log.info("Market dropdown found");
		return element;

	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement settingsIcon(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='settings']/a"));
		log.info("Settings icon found");
		return element;

	}

	/**
	 * 
	 * @param marketName
	 * @param driver
	 */
	public static void selectMarket(String marketName, WebDriver driver) {
		// element=settingsIcon(driver);
		// element.click();
		// Select select=new Select(marketDropdown(driver));
		// select.deselectAll();
		// select.selectByVisibleText(marketName);
		log.info("Market" + marketName + " selected");
	}

}
