package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountOrdersPage  extends BasePage{

	public MyAccountOrdersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public WebElement getProductDetails() {
		return productDetails;
	}
	public WebElement getReOrderbtn() {
		return reOrderbtn;
	}


	@FindBy(xpath = "//strong[normalize-space()='Order Number: 2216505']/../..//input[@value='Details']") private WebElement productDetails;
	@FindBy(xpath = "//input[@value='Re-order']") private WebElement reOrderbtn;
	
	
	
}
