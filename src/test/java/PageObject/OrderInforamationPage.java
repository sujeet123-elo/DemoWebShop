package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInforamationPage extends BasePage {

	public OrderInforamationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getPDFInvoicebtn() {
		return PDFInvoicebtn;
	}

	@FindBy(linkText = "PDF Invoice") private WebElement PDFInvoicebtn;
	

}
