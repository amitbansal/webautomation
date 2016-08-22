package testing.msn.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Win10PageHelper implements IHomePage {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 * 
	 */

	@FindBy(name = "uid")
	WebElement user99GuruName;

	@FindBy(name = "password")
	WebElement password99Guru;

	@Override
	public void verifyWeather() {
		// TODO Auto-generated method stub
		System.out.println("from verify weather of win10 page helper");
	}

	@Override
	public void verifySearch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifySettings() {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyLogo() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

}
