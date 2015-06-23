package Common;
import org.openqa.selenium.By;

public class ElementDefinition {
	    
	public static By Id(String id)
	{
	return By.id(id);
	}
	public static By Name(String name)
	{
	return By.name(name);
	}
	public static By Xpath(String xpath)
	{
	return By.xpath(xpath);
	}
	public static By CssSelector (String selector)
	{
	return By.cssSelector(selector);
	}
	public static By LinkText (String linkText)
	{
	return By.linkText(linkText);
    }
  
	}


