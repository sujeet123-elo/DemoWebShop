package PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends BasePage{
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath="//h1[normalize-space()='Checkout']") private WebElement Heading_checkout;
@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']") private WebElement txtfirstName;
@FindBy(xpath="//input[@id='BillingNewAddress_LastName']")  private WebElement txtlastName;
@FindBy(xpath="//input[@id='BillingNewAddress_Email']") private WebElement txtemail;
@FindBy(xpath="//input[@id='BillingNewAddress_Company']") private WebElement txtcompany;
@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")private WebElement drop_country;
@FindBy(xpath="//input[@id='BillingNewAddress_City']") private WebElement txtcity;
@FindBy(xpath="//input[@id='BillingNewAddress_Address1']") private WebElement txtaddress1;
@FindBy(xpath="//input[@id='BillingNewAddress_Address2']") private WebElement txtaddress2;
@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")private WebElement txtzip_PostalCode;
@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")private WebElement txtphoneNumber;
@FindBy(xpath="//input[@id='BillingNewAddress_FaxNumber']")private WebElement txtfaxNumber;
@FindBy(xpath="//input[@onclick='Billing.save()']") private WebElement btncContinueBillingAddress;
@FindBy(xpath="//input[@onclick='Shipping.save()']")private WebElement btCcontinueShippingAddress;
@FindBy(xpath="//select[@id='billing-address-select']") private WebElement selectABillingAddressFrom;
@FindBy(xpath="//a[normalize-space()='Log out']") private WebElement logOut;
@FindBy(id = "billing-new-address-form") private WebElement newFormText;
JavascriptExecutor js;

public void setSelectABillingAddressFrom(WebElement selectABillingAddressFrom) {
	this.selectABillingAddressFrom = selectABillingAddressFrom;
}


public WebElement getNewFormText() {
	return newFormText;
}


WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
public void LogOut() {
	wait.until(ExpectedConditions.elementToBeClickable(logOut)).click();
}
public void ClickContinueBilling() {
	wait.until(ExpectedConditions.elementToBeClickable(btncContinueBillingAddress)).sendKeys(Keys.ENTER);
}

public void Selectaddress() {
	Select s = new Select(selectABillingAddressFrom);
	s.selectByIndex(0);
}

public String checkHeading() {
	return Heading_checkout.getText();
}

public void automateAddressForm(String firstname, String lastname, String email, String countryName, String cityname,  String address1, String address2, String postalCode, String phonenumber, String faxNumber) {
	
	txtfirstName.clear();
	txtfirstName.sendKeys(firstname);
	txtlastName.clear();
	txtlastName.sendKeys(lastname);
	
	txtemail.clear();
	txtemail.sendKeys(email);
	//txtcompany.sendKeys(setcompnyName);
	
	Select s = new Select(drop_country);
	s.selectByVisibleText(countryName);
	
	txtcity.sendKeys(cityname);
	txtfaxNumber.sendKeys(faxNumber);
	txtaddress1.sendKeys(address1);
	txtaddress2.sendKeys(address2);
	txtzip_PostalCode.sendKeys(postalCode);
	txtphoneNumber.sendKeys(phonenumber);
	
	
}

// shipping  address
@FindBy(xpath="//input[@onclick='Shipping.save()']") private WebElement shippingAddressContinuebtn;

// shipping method
@FindBy(id = "shippingoption_0") private WebElement nextdayAirbtn;
@FindBy(xpath="//input[@onclick='ShippingMethod.save()']") private WebElement ShippingMethodcontinue;

//Payment method 
@FindBy(id = "paymentmethod_2") private WebElement creditcardPaymentMethod;
@FindBy(xpath ="//input[@onclick='PaymentMethod.save()']") private WebElement paymentcontinuebtn;

//payment details

@FindBy(xpath ="//select[@id='CreditCardType']") private WebElement selectcardNetwork;
@FindBy(xpath="//input[@id='CardholderName']") private WebElement cardholderName;
@FindBy(xpath="//input[@id='CardNumber']") private WebElement cardNumber;
@FindBy(xpath="//select[@id='ExpireMonth']") private WebElement expirationDate;
@FindBy(xpath="//select[@id='ExpireYear']") private WebElement expirationYear;
@FindBy(xpath="//input[@id='CardCode']") private WebElement cardCode;
@FindBy(xpath="//input[contains(@class, 'payment-info-next-step-button')]") private WebElement PayementInfocontinueBtn;


//confirm Order
@FindBy(xpath="//input[@value='Confirm']") private WebElement confirmOrderbtn;
@FindBy(xpath = "//input[@value='Continue']") private WebElement thankyoubtnvontinue;

@FindBy(linkText = "Click here for order details.") private WebElement OrderdetailsLikn;



public void automateShipping() {
	wait.until(ExpectedConditions.elementToBeClickable(btncContinueBillingAddress)).sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.elementToBeClickable(shippingAddressContinuebtn)).sendKeys(Keys.ENTER);
    nextdayAirbtn.click();
    wait.until(ExpectedConditions.elementToBeClickable(ShippingMethodcontinue)).sendKeys(Keys.ENTER);
	
}

public void automatePayment(String network, String cardholdername, String cardNum, String date, String year, String cvv ) {
	creditcardPaymentMethod.click();
	wait.until(ExpectedConditions.elementToBeClickable(paymentcontinuebtn)).sendKeys(Keys.ENTER);
	
	Select s = new Select(selectcardNetwork);
	s.selectByVisibleText(network);
	cardholderName.sendKeys(cardholdername);
	cardNumber.sendKeys(cardNum);
	Select d = new Select(expirationDate);
	d.selectByVisibleText(date);
	Select y = new Select(expirationYear);
	y.selectByVisibleText(year);
	cardCode.sendKeys(cvv);
	
	 wait.until(ExpectedConditions.elementToBeClickable(PayementInfocontinueBtn)).sendKeys(Keys.ENTER);
	
	
}




public WebElement getOrderdetailsLikn() {
	return OrderdetailsLikn;
}





public void ConfirmOrder() {
	 wait.until(ExpectedConditions.elementToBeClickable(confirmOrderbtn)).sendKeys(Keys.ENTER);
	 
	}








	






















	

}
