package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CheckOutPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountOrdersPage;
import PageObject.OrderInforamationPage;
import PageObject.ShoppingCartPage;
import testBase.BaseClass;

public class TC006_ReOrder extends BaseClass{
	
	@Test(groups= {"Sanity", "Master"}, priority = 1)
	public void LoginInApplicatinon() {
		logger.info("*******TC002_SearchAndClickOnProductOfAutoSuggAndAddIntoCart**********");
		HomePage h = new HomePage(driver);
		h.clickLogin();
		LoginPage l = new LoginPage(driver);
		l.setEmail(p.getProperty("email"));
		l.setPassword(p.getProperty("pass"));
		l.clickLogin();
	}
	@Test(groups= {"Sanity", "Master"}, priority = 2)
	public void ReorderTheProduct() {
		HomePage h = new HomePage(driver);
		h.getOrderslink().click();
		MyAccountOrdersPage my = new MyAccountOrdersPage(driver);
		my.getProductDetails().click();
		my.getReOrderbtn().click();
		
		
	}
	@Test(groups= {"Sanity", "Master"}, priority = 3)
	public void CheckouFromCart() {
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
	public void ReCheckoutAndBillingPaymentDelhivery() throws InterruptedException {
		
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
