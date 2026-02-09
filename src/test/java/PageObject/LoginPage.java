package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='Email']") WebElement txtemail;
	@FindBy(xpath="//input[@id='Password']") WebElement txtpassword;
	@FindBy(xpath="//input[@value='Log in']") WebElement btnlogIn;
	
	public void setEmail(String s) {
		txtemail.clear();
		txtemail.sendKeys(s);
	}
	public void setPassword(String p) {
		txtpassword.sendKeys(p);
	}
	
	public void clickLogin() {
		btnlogIn.click();
	}
	

}
