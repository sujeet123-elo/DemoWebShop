package testCases;

import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.RagisterPage;
import testBase.BaseClass;

public class TC001_RegisterToLogOut  extends BaseClass{
	
	@Test
	public void RegisterToLougout() {
		
		HomePage h = new HomePage(driver);
		h.clickRagister();
		RagisterPage r = new RagisterPage(driver);
		r.clickMale();
		r.setFirstname("sujeet");
		r.SetLastName("kumar");
		r.setEmail("sujeetl23ava@gmail.com");
		r.SetPassword("12345qwert");
		r.SetConfirmPassword("12345qwert");
		r.clickregister();
		r.clickContinue();
		h.clickLogout();
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
