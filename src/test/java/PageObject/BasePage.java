package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	public BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void getScrolling(String s) {
		WebElement scrolltill = driver.findElement(By.xpath(s));
		JavascriptExecutor jd = (JavascriptExecutor) driver;
		
		jd.executeScript("arguments[0].scrollIntoView(true)", scrolltill); //if you pass false as arguments then it will return element in bottom of the window
		
		
		
	}


}
