package testing.msn.homepage;

public interface IHomePage {

	public String pageName = "";
	public String pageTitle = "";
	// public List<WebElement> listOfWebElements;

	public void verifyWeather();

	public void verifySearch();

	public void verifySettings();

	public void verifyLogo();

	public String getName();

	public void setName(String name);

}
