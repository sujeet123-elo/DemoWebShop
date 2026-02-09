package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleComputerPage extends BasePage{

	public SimpleComputerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[normalize-space()='Simple Computer']") WebElement heading_simpleComputer;
	@FindBy(xpath="//input[@id='product_attribute_75_5_31_96']") WebElement radio_btn_Processor_slow;
	//RAM
	@FindBy(xpath="//label[contains(text(),'8 GB')]") WebElement radio_btn_8gb_RAM;
	@FindBy(xpath="//label[normalize-space()='2 GB']") WebElement radio_btn_2GB_RAM;
	@FindBy(xpath="//label[contains(text(),'4 GB')]") WebElement radio_btn_4GB_RAM;
	//HDD
	@FindBy(xpath="//label[normalize-space()='320 GB']") WebElement radio_btn_320GB_hdd;
	@FindBy(xpath="//label[contains(text(),'400 GB')]") WebElement radio_btn_400GB_hdd;
	
	//SoftWare
	@FindBy(xpath="//label[normalize-space()='Image Viewer']") WebElement radio_btn_imageViewer;
	@FindBy(xpath="//label[normalize-space()='Office Suite']") WebElement radio_btn_officeSuite;
	
	@FindBy(xpath="//input[@id='add-to-cart-button-75']") WebElement btnaddToCart;
	
	@FindBy(xpath="//img[@alt='Tricentis Demo Web Shop']") WebElement btntricentisDemoWebShop;
	
	public void clickToGoHomePage() {
		btntricentisDemoWebShop.click();
	}
	public void selectprocessor() {
		radio_btn_Processor_slow.click();
	}
	public String getHeading() {
		
		return heading_simpleComputer.getText() ;
		}
	
	public void SelectsoftwareOfficeSuite() {
		radio_btn_officeSuite.click();
	}
	public void SelectSoftwareImageViewer() {
		radio_btn_imageViewer.click();
	}
	
	public void clickOnAddTocartButton() {
		btnaddToCart.click();
	}
	
	
	
	
	
	
	
	
	
	public void SelectHDD(String s) {
		if(s.equals("320")) {
			radio_btn_320GB_hdd.click();
		}
		else if(s.equals("400")) {
			radio_btn_400GB_hdd.click();
		}
		else {
			System.out.println("enetr correct HDD ");
				
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void SelectRam(String s) {
		if(s.equals("8")) {
			radio_btn_8gb_RAM.click();
		}
		else if(s.equals("2")) {
			radio_btn_2GB_RAM.click();
		}
		else if(s.equals("4")) {
			radio_btn_4GB_RAM.click();
		}
		else {
			System.out.println("plese enter right RAM");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
