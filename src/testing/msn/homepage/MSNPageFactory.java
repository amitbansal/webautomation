package testing.msn.homepage;

public class MSNPageFactory {

	public static IHomePage getHomePageHelper(String DeviceType) {
		switch (DeviceType) {
		case "Mobile":
			System.out.println("return mobile helper");
			return new MobilePageHelper();
		case "Win10":
			System.out.println("return win10 helper");
			return new Win10PageHelper();
		case "DownLevel":
			System.out.println("return downlevel helper");
			return new DownLevelPageHelper();
		default:
			return null;
		}
	}
}
