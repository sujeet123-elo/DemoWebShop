package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	JavascriptExecutor js;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	


@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
@FindBy(xpath="//a[normalize-space()='Log in']") WebElement lnkLogIn;
@FindBy(xpath="//span[normalize-space()='Shopping cart']") WebElement lnkShoppingCart;
@FindBy(xpath="//span[normalize-space()='Wishlist']") WebElement lnkWishlist;
@FindBy(xpath="//input[@id='small-searchterms']") WebElement txtSearchStore;
@FindBy(xpath="//input[@value='Search']") WebElement btnSearch;
@FindBy(xpath="//input[@value='Go to cart']") WebElement goToCart;

@FindBy(xpath="//ul[@id='ui-id-1']//li//a") List<WebElement> listOfAutoSuggestProduct;

@FindBy(xpath="//a[normalize-space()='Log out']") WebElement lnklogOut;

public boolean LogoutLink() {
	try {
	return lnklogOut.isDisplayed();
	}
	catch(Exception e) {
		return false;
	}
	
}
public void clickLogin() {
	lnkLogIn.click();
}
public void clickRagister() {
	lnkRegister.click();
}

public void clickLogout() {
	lnklogOut.click();
}

public void SearchItem(String s) throws InterruptedException {
	for(char c:s.toCharArray()) {
		txtSearchStore.sendKeys(String.valueOf(c));
		Thread.sleep(300);
	}
}

public void clicklinkAddTocart() {
	lnkShoppingCart.click();
}
public void clickGoToCart() {
	js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", goToCart);
	//wait.until(ExpectedConditions.elementToBeClickable(goToCart)).click();
	}

public void clickAutoSuggestion(String y) {
	
	js = (JavascriptExecutor) driver;
	
	for(WebElement s:listOfAutoSuggestProduct) {
		if(s.getText().equals(y)) {
		js.executeScript("arguments[0].click();", s);
			break;
		}
	
	
	
	
	}}}
















