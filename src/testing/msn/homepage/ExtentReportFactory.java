package testing.msn.homepage;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		Constants SuiteConstants=new Constants();
		String Path = SuiteConstants.Reportfile_Path;
		extent = new ExtentReports(Path, true);
		extent
	     .addSystemInfo("Selenium Version", "2.53")
	     .addSystemInfo("Platform", "Windows");

		return extent;
	}
}
