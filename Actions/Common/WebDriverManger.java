package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManger {
	
	public static WebDriver getDriver(String driverName) {
		WebDriver driver = null;

         switch(driverName) {
          case "CHROME":
        	  System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
              driver = new ChromeDriver(); 
               break;
          case "IE":
               System.setProperty("webdriver.ie.driver", "C://IEDriverServer.exe");
               driver = new InternetExplorerDriver();
               break;
          case "FIREFOX":
        	  driver = new FirefoxDriver();

               break;
         }
         return driver;
    }
}