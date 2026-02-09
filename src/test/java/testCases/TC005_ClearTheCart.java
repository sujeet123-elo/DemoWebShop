package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.GiftCardPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.ShoppingCartPage;
import testBase.BaseClass;

public class TC005_ClearTheCart extends BaseClass{
	JavascriptExecutor js;
	@Test(groups= {"Sanity", "Master"}, priority = 1)
	public void LoginTheSite() {
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
		g.clickHomeDefoult();
	}
	@Test(groups= {"Sanity", "Master"}, priority = 3)
	public void GoToCartAndClear() {
		HomePage h = new HomePage(driver);
		h.clicklinkAddTocart();
		h.clickGoToCart();
		ShoppingCartPage sh = new ShoppingCartPage(driver);
		Assert.assertEquals(sh.PageHeading(), "Shopping cart");
		sh.clickAndRemoveProduct();
		sh.updatecart();
		
	}
	

}
