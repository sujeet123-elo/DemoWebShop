package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC001_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups= {"Master","DataDriven"})
	public void VerifyLoginData(String email, String pwd, String exp) {
		HomePage h = new HomePage(driver);
		h.clickLogin();
		LoginPage l = new LoginPage(driver);
		l.setEmail(email);
		l.setPassword(pwd);
		l.clickLogin();
		
		boolean status = h.LogoutLink();
		
		if(exp.equalsIgnoreCase("valid")) {
			if(status==true) {
				h.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(false);
			}
			}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(status==true) {	
				h.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				
				Assert.assertTrue(true);
					
			}
		}
	}

}
