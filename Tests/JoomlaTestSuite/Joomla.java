package JoomlaTestSuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Automation;
import Common.Common;
import Common.Constants;
import JoomlaActions.*;



public class Joomla {
	
	private LoginPage _loginPage;
//	private HomePage _homePage;
	
	public Joomla (){
		
		this._loginPage = new LoginPage();
	//	this._homePage = new HomePage();
	}

	@BeforeClass
	public void set_up() throws Exception {
    	Common.config();
 	}

	
	@AfterMethod()
	public void after_test_case_execution() throws Exception {
		Automation.close();
	}
	
	
	@Test(description = "Verify control on Home page")
	public void TC001_Verify_HomePage() throws Exception {
		_loginPage.NavigateToURL();
		_loginPage.Login(Constants.Username,Constants.Password);
		
	//	Common.navigateMenuBar("Menus>Menu Manager");
		
		}

	/*@AfterClass
	public void tear_down() {
		
		Automation.close();
	}*/

}
