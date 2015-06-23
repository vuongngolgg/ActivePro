package Common;

public class Common {
	
	public static void config() {
		Settings.setObjecWait(60);
		Automation.setDriver(WebDriverManger.getDriver(RunConfig.FIREFOX_BROWSER));
	}

}
