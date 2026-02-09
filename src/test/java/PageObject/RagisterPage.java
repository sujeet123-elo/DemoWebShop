package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RagisterPage extends BasePage {

	public RagisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	


@FindBy(xpath="//h1[normalize-space()='Register']") WebElement headingRegister;
@FindBy(xpath="//input[@id='gender-male']") WebElement radmale;
@FindBy(xpath="//input[@id='gender-female']") WebElement radfemale;
@FindBy(xpath="//input[@id='FirstName']") WebElement txtfirstName;
@FindBy(xpath="//input[@id='LastName']") WebElement txtlastName;

@FindBy(xpath="//input[@id='Email']") WebElement txtemail;
@FindBy(xpath="//input[@id='Password']") WebElement txtpassword;
@FindBy(xpath="//input[@id='ConfirmPassword']") WebElement txtconfirmPassword;
@FindBy(xpath="//input[@id='register-button']") WebElement btnregister_button;
@FindBy(xpath="//input[@value='Continue']") WebElement btncontinue;
public void checkRegisterPage() {
	
}
public void clickMale() {
	radmale.click();
}

public void clickFemale() {
	radfemale.click();
}

public void setFirstname(String s) {
	txtfirstName.sendKeys(s);
}

public void SetLastName(String s) {
	txtlastName.sendKeys(s);
}

public void setEmail(String s) {
	txtemail.sendKeys(s);
}

public void SetPassword(String s) {
	txtpassword.sendKeys(s);
}

public void SetConfirmPassword(String s) {
	txtconfirmPassword.sendKeys(s);
}

public void clickregister() {
	btnregister_button.click();
}
public void clickContinue() {
	btncontinue.click();
}


















}
