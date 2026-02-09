package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CheckOutPage;
import PageObject.GiftCardPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.OrderInforamationPage;
import PageObject.ShoppingCartPage;
import testBase.BaseClass;

public class TC002_SearchAndClickOnProductOfAutoSuggAndAddIntoCart extends BaseClass {
	
	JavascriptExecutor js;
	@Test(groups= {"Sanity", "Master"}, priority = 1)
	public void LoginAccount() throws InterruptedException {
		logger.info("*******TC002_SearchAndClickOnProductOfAutoSuggAndAddIntoCart**********");
		HomePage h = new HomePage(driver);
		h.clickLogin();
		LoginPage l = new LoginPage(driver);
		l.setEmail(p.getProperty("email"));
		l.setPassword(p.getProperty("pass"));
		l.clickLogin();
		
	}
	@Test(groups= {"Sanity", "Master"}, priority = 2)
	public void AddToCart() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.SearchItem("gift");
		h.clickAutoSuggestion("$100 Physical Gift Card");
		
		GiftCardPage g = new GiftCardPage(driver);
		Assert.assertEquals(g.getProductName(), "$100 Physical Gift Card");

		g.setRecipientName(p.getProperty("togift"));
		g.setMessage("hi, its for you");
		js=(JavascriptExecutor)driver;
		
		//g.setQuantity("2");
		
		g.AddToCart();
		
		//g.clickHomeDefoult();
	}
	@Test(groups= {"Sanity", "Master"}, priority = 3)
	public void GoToCartAndCheckout() {
		HomePage h = new HomePage(driver);
		h.clicklinkAddTocart();
		//h.clickGoToCart();
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
		c.getOrderdetailsLikn().click();
		OrderInforamationPage o = new OrderInforamationPage(driver);
		o.getPDFInvoicebtn().click();
		c.LogOut();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	

}
