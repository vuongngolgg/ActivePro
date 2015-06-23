package Common;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Automation {
   private static WebElement webElement;
   public static WebDriver driver = null;
   //WebDriverManger.getDriver(RunConfig.CHROME_BROWSER); 
 
   
public static boolean waitForControl(By element, long timeout) {
		boolean isExist = false;
		try {
			driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
			driver.findElement(element);
			isExist = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			isExist = false;
		}
		return isExist;
	}
	
public static boolean waitForControl(By element) {
	
	int timeout = Settings.getObjecWait();
	return waitForControl(element, timeout);
	
}


public static void waitForControlClose(By element) {
	int timeout = Settings.getObjecWait();
	try {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

public static void waitForControlClose(By element, long timeout) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

public static boolean isPageDisplayed(String pageTitle) {
	
	boolean isExist = false;
	long timeout = Settings.getObjecWait()*1000;
	try {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		String title = driver.getTitle();			
		long getTickCount = System.currentTimeMillis();
		while (!title.equals(pageTitle)) {
			Thread.sleep(50);
			title = driver.getTitle();
			if ((System.currentTimeMillis()-getTickCount) > timeout) {
				break;
			}
		}
			
		if (title.equals(pageTitle)) isExist = true;
	} catch (Exception e) {
		isExist = false;
	}
	return isExist;
	
}

public static void type(CharSequence... keys){
	webElement.sendKeys(keys);
	
}

public static void enter(By element, String value) {
	waitForControl(element);
	webElement = driver.findElement(element);
	webElement.clear();
	webElement.sendKeys(value);
}

public static boolean isElementExists(By element)
{
	return waitForControl(element);
}

public static boolean isElementDisplayed(By element) {
	boolean isDisplayed = false;
	boolean isExists = waitForControl(element);
	if(isExists)
	{
		try {
			isDisplayed = driver.findElement(element).isDisplayed();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	return isDisplayed;
}

public static void bringIntoView(By element)
{
	waitForControl(element);
	webElement = driver.findElement(element);		
	
}
public static void clickByJS(By element)
{
	waitForControl(element);
	((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(element));
}
public static void click(By element) {
	waitForControl(element);
	webElement = driver.findElement(element);
	try
	{
		webElement.click();
	}
	catch(ElementNotVisibleException ex)
	{			
		clickByJS(element);
	}
}

public static void setCheckbox(By element,boolean isCheck){
	if(!isChecked(element) && isCheck){
		click(element);
	}
}

public static void select(By element, String value) {
	waitForControl(element);
	Select select = new Select(driver.findElement(element));
	select.selectByValue(value);		
}
public static void selectByVisibleText(By element, String text) {
	waitForControl(element);
	Select select = new Select(driver.findElement(element));
	select.selectByVisibleText(text);		
}
public static WebElement findElement(By element) {
	waitForControl(element);
	return driver.findElement(element);
}

public static List<WebElement> findElements(By element) {
	waitForControl(element);
	return driver.findElements(element);
}

public static String getTableCellValue(By element, int rowIndex,int colIndex) {
	String sResult = "";
	rowIndex = rowIndex - 1;
	colIndex = colIndex - 1;
	waitForControl(element);
	WebElement tableElement = findElement(element);
	List<WebElement> rows = tableElement.findElements(By.xpath("tbody/tr"));
	if (rowIndex > rows.size())
		return sResult;
	for (int i = 0; i < rows.size(); i++) {
		if (i == rowIndex) {
			WebElement row = rows.get(i);
			List<WebElement> cols = row.findElements(By.xpath("td"));
			if (colIndex > cols.size())
				return sResult;
			for (int j = 0; j < cols.size(); j++) {
				if (j == colIndex) {
					WebElement col = cols.get(j);
					sResult = col.getText();
					break;
				}
			}
			break;
		}
	}

	return sResult;
}

public static void getTableCellContaining(By element,String text){
//	int [] a = new int[2];
	WebElement tableElement = driver.findElement(element);
	List<WebElement> rows = tableElement.findElements(By.xpath("tbody/tr"));
	
	for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			List<WebElement> cols = row.findElements(By.xpath("td"));
	
			for (int j = 0; j < cols.size(); j++) {
				
				WebElement col = cols.get(j);
			 if(text.equalsIgnoreCase(col.getText()))
				 System.out.println(j);
					break;
				}
			System.out.println(i);
			break;
			
	}	
 
}

public static boolean isChecked(By element) {
	waitForControl(element);
	webElement = driver.findElement(element);
	return webElement.isSelected();
}

public static String getSelectedComboboxItemText(By element)
{
	String text = "";
	WebElement webElement = findElement(element);
	Select selectedValue = new Select(webElement);
	text = selectedValue.getFirstSelectedOption().getText();
	
	return text;
	
}
public static String getText(By element)
{
	return findElement(element).getText();
}

public static void set(By element, boolean isCheck) {
	boolean check = isChecked(element);
	webElement = findElement(element);
	if ((isCheck && !check) || (!isCheck && check)) {
		webElement.click();
	}
}

public static void set(By element, boolean isCheck, boolean realState) {
	webElement = driver.findElement(element);
	if ((isCheck && !realState) || (!isCheck && realState)) {
		webElement.click();
	}
}

public static String getAttribute(By element, String att) {
	waitForControl(element);
	webElement = driver.findElement(element);
	return webElement.getAttribute(att);
}

public static void logReport(String report,Class<?> cls) {
	Log log = LogFactory.getLog(cls);
	log.info(report);
}

public static WebDriver getDriver() {
	return driver;
}

public static void setDriver(WebDriver _driver){
	
	driver = _driver;
}
public static void focusElement(By element){
	if(waitForControl(element)){
		driver.findElement(element).sendKeys(Keys.NULL);
	}

}
public static void open(String url) {
	driver.get(url);
	maximizeWindow();
}
public static void close() {		
	if(driver != null)
	{
		driver.quit();
	}
}
public static void maximizeWindow(){
	
	driver.manage().window().maximize();
	
}
public static String getCurrentURL(){
	
	return driver.getCurrentUrl();
}
public static String getTitle(){
	return driver.getTitle();
}

// Select dynamic menubar as Home/User/Add User
public static void navigateMenuBar(String strMenuBar)
{
Actions  hold = new Actions(Automation.getDriver());
String linkName = ".//*[@id='menu']//a[contains(text(),\"{0}\")]";
String [] names = strMenuBar.split(">");

for(int i = 0; i<=names.length;i++)
{
	String link = linkName.replace("{0}", names[i]);
	if(i ==1){
		hold.moveToElement(Automation.getDriver().findElement(ElementDefinition.Xpath(link))).perform();		
	}
	Automation.click(ElementDefinition.Xpath(link));
	
}
	
}
public static boolean isTextContains(String strActual, String strExpected)
{
	 if(strExpected.contains(strActual))
	return true;
	return false;
}
}