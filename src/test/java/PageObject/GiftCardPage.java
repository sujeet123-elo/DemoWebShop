package PageObject;

import java.security.PrivateKey;
import java.time.Duration;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftCardPage extends BasePage{

	public GiftCardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindAll(value = { @FindBy(xpath="//h1[normalize-space()='$100 Physical Gift Card']"), @FindBy(id="gift card"), @FindBy(name="GiftCard")}) private WebElement $100PhysicalGiftCard;  	

	
	@FindBy(xpath="//input[@class='recipient-name']") private WebElement txtrecipientName;
	@FindBy(xpath="//textarea[@class='message']")  private WebElement txtMsg;
	@FindBy(xpath="//div[@class='add-to-cart-panel']//input[@class='qty-input valid']") private WebElement txtqty;
	@FindBy(xpath="//input[@id='add-to-cart-button-4']") private WebElement btnaddToCart;
	@FindBy(xpath="//img[@alt='Tricentis Demo Web Shop']") private WebElement hometricentisDemoWebShop;
	JavascriptExecutor js;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	public void setRecipientName(String s) {
		txtrecipientName.sendKeys(s);
	}
	
	public void setMessage(String s) {
		txtMsg.sendKeys(s);
	}
	
	public void setQuantity(String s) {
		txtqty.clear();
		txtqty.sendKeys(s);
	}
	
	public String getProductName() {
		return $100PhysicalGiftCard.getText();
	}
	
	public void AddToCart() {
		js = (JavascriptExecutor) driver;
		
		//js.executeScript("arguments[0].scrollIntoView(true)", btnaddToCart);
		btnaddToCart.click();
		//js.executeScript("window.scrollBy(0, document.body.scrollHeight");
	}
	
	public void clickHomeDefoult() {
		wait.until(ExpectedConditions.elementToBeClickable(hometricentisDemoWebShop)).click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
