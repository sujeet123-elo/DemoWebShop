package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage  extends BasePage{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[normalize-space()='Shopping cart']") WebElement heading_shoppingCart;
	@FindBy(className="qty-input") WebElement txtitemquantity;
	@FindBy(xpath="//input[@id='termsofservice']") WebElement checkbox_termsofservice;
	@FindBy(xpath="//button[@id='checkout']") WebElement btncheckout;
	@FindBy(xpath="//select[@id='CountryId']") WebElement dropdown_country;
	@FindBy(xpath="//select[@id='StateProvinceId']") WebElement state_Province;
	@FindBy(xpath="//input[@id='ZipPostalCode']") WebElement zip_PostalCode;
	@FindBy(xpath="//form[@action='/cart']//tbody//tr[@class='cart-item-row']") List<WebElement> num_of_product;
	@FindBy(xpath="//form[@action='/cart']//tbody//tr[@class='cart-item-row']//td//input[@type='checkbox']") List<WebElement> removefromcart;
	@FindBy(xpath="//input[@name='updatecart']") WebElement updatecart;
	int num;
	public int GetNumOfProductInCart() {
		num = num_of_product.size();
		return num;
	}
	public void clickAndRemoveProduct() {
		for(WebElement c:removefromcart) {
			c.click();
		}
	}
	public void updatecart() {
		updatecart.click();
	}
	
	
	
	public String PageHeading() {
		return heading_shoppingCart.getText();
	}
			
	public void setQ(String s) {
		txtitemquantity.sendKeys(s);
	}
	public void SelectCountry(String s) {
		Select se = new Select(dropdown_country);
		se.selectByVisibleText(s);
	}
	
	public void selectState(String s) {
		Select se = new Select(state_Province);
		se.selectByVisibleText(s);
		}
	public void setPostalCode(String s) {
		zip_PostalCode.sendKeys(s);
	}
	
	public void ChekboxPrivecy() {
		checkbox_termsofservice.click();
	}
	
	public void clickOnCheckOut() {
		btncheckout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
