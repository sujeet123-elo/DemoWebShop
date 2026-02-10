package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CheckOutPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.ShoppingCartPage;
import PageObject.SimpleComputerPage;
import testBase.BaseClass;

public class TC003_SearchToSimpleComputerToPurachaseOrder  extends BaseClass{
	@Test(groups= {"Sanity", "Master"}, priority = 1)
	public void LoginPage() {
		HomePage h = new HomePage(driver);
		h.clickLogin();
		LoginPage l = new LoginPage(driver);
		l.setEmail(p.getProperty("email1"));
		l.setPassword(p.getProperty("pass1"));
		l.clickLogin();
		
	}
	@Test(groups= {"Sanity", "Master"}, priority = 2)
	public void SearchProduct() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.SearchItem("Simple");
		h.clickAutoSuggestion("Simple Computer");
		
		SimpleComputerPage s =new SimpleComputerPage(driver);
		Assert.assertEquals(s.getHeading(), "Simple Computer");
		s.selectprocessor();
		s.SelectRam("4");
		
		s.SelectHDD("320");
		s.SelectSoftwareImageViewer();
		s.clickOnAddTocartButton();
		//s.clickToGoHomePage();
		h.clicklinkAddTocart();
		h.clickGoToCart();
		}
	@Test(groups= {"Sanity", "Master"}, priority = 3)
	public void GoToCartAndCheckout() {
		
		ShoppingCartPage sh = new ShoppingCartPage(driver);
		Assert.assertEquals(sh.PageHeading(), "Shopping cart");
		//sh.setQ("2");
		sh.SelectCountry("India");
		//sh.selectState("Other (Non US)");
		sh.setPostalCode(p.getProperty("zip_code"));
		sh.ChekboxPrivecy();
		sh.clickOnCheckOut();
		
	}
	@Test(groups= {"Sanity", "Master"}, priority = 4)
	public void CheckoutAndBillingPaymentDelhivery() throws InterruptedException {
		
		CheckOutPage c = new CheckOutPage(driver);
		String ch=c.checkHeading();
		Assert.assertEquals(ch, "Checkout");
		if(c.getNewFormText().isDisplayed()==true) {
			c.automateAddressForm(p.getProperty("firstname"), p.getProperty("lastname"), p.getProperty("email"), p.getProperty("Country"), p.getProperty("city"), p.getProperty("address1"), p.getProperty("address2"), p.getProperty("zip_code"), p.getProperty("phone"), p.getProperty("fax"));
		}
		
		c.automateShipping();
		c.automatePayment(p.getProperty("cardNetwork"), p.getProperty("cardholdername"), p.getProperty("cardNumber"), p.getProperty("expDate"), p.getProperty("expYear"), p.getProperty("cvv"));
        c.ConfirmOrder();
		
	

		
	}
	

}
