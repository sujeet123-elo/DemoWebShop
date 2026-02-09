package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@SuppressWarnings("deprecation")
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"Sanity","Master","DataDriven","Regression"})
	public void setup(String os, String br) throws IOException {
		
		FileReader f = new FileReader("./src/test/resources/config1.properties");
		p=new Properties();
		p.load(f);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equals("remote")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			//OS
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else {
				System.out.println("no matching OS");
				return;
			}
			//Browser
			switch (br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome"); break;
			case "edge":cap.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("no matching browser"); return;
			}
			driver=new RemoteWebDriver(new URL("http://10.201.24.38:4444/wd/hub"), cap);
						}
			
			 
	
		
		
		if(p.getProperty("execution_env").equals("local")) {
			switch (br.toLowerCase()) {
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default: System.out.println("there is no such type of browser"); return;
			}
		}
		
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		
	}
	@AfterClass(groups= {"Sanity","Master","DataDriven","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomeString() {
		String rs =RandomStringUtils.randomAlphabetic(5);
		return rs;
	}
	
	public String randomeNumber() {
		String rs =RandomStringUtils.randomNumeric(10);
		return rs;
	}
	
	public String RandomAlphaNumeric() {
		String rs1 =RandomStringUtils.randomAlphabetic(5);
		String rs2 =RandomStringUtils.randomNumeric(10);
		return (rs1+"@"+rs2);
		
	}
	
	public String captureScreen(String tname) throws IOException {

	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss")
	            .format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir")
	            + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}
	
	


}
