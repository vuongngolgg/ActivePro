package JoomlaEntities;

import org.openqa.selenium.By;
import Common.ElementDefinition;

public class LoginPageEntity {
	
	public static String PageTitle = "joomlatest - Administration";
	
	//-------------------------Interfaces of Login Page------------------------------
	
	public static By txtUsername = ElementDefinition.CssSelector("#mod-login-username");
	public static By txtPassword = ElementDefinition.CssSelector("#mod-login-password");
	public static By btnSignIn = ElementDefinition.Xpath("//button[contains(text()[2],'Log in')]");
	
}

