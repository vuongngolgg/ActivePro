package JoomlaActions;

import Common.Automation;
import Common.Constants;
import JoomlaEntities.LoginPageEntity;


public class LoginPage {
	
	private static LoginPage instance = null;

	
	
	public static synchronized LoginPage getLoginPage()
	{
		if(instance == null)
			instance = new LoginPage();
		return instance;
	}
		
	//----------------------------------- business actions -----------------------------------

	public void NavigateToURL(String URL) throws Exception {
		Automation.open(URL);
	}
	
	public void FillLoginInfor(String userName, String password){
		Automation.enter(LoginPageEntity.txtUsername, userName);
		Automation.enter(LoginPageEntity.txtPassword, password);		
	}
	
	public void Login(String userName, String password){
		FillLoginInfor(userName, password);
		Automation.click(LoginPageEntity.btnSignIn);
	}

	public void checkTitle(){
		String title = Automation.getTitle();
		System.out.println(title);
		
	}

}

