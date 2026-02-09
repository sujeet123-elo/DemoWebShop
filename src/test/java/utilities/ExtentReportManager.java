package utilities;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test; // creating test case entries in the report
    String repName;

    @Override
    public void onStart(ITestContext context) {
    	
    	
    	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
    	repName="Test-Report-"+timeStamp+".html";
    	
    	

        sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);
              

        sparkReporter.config().setDocumentTitle("OpenCart Automation Report"); // Title of report
        sparkReporter.config().setReportName("OpenCart Functional Testing");   // Name of report
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Module", "admin");
        extent.setSystemInfo("Sub-Module", "Customer");
        extent.setSystemInfo("User Nname", System.getProperty("user.name"));
        
       
		String os1 =context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os1);
		
		String browser1 =context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser1);
        
	    List<String> includegroups1 = context.getCurrentXmlTest().getIncludedGroups();
	    if(!includegroups1.isEmpty()){
	    extent.setSystemInfo("Groups", includegroups1.toString());
	    }
        
        
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName()); // create entry in report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS,
                "Test case PASSED is: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	 test = extent.createTest(result.getMethod().getMethodName());// create entry in report
         test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL,"Test case FAILED is: " + result.getName());
        test.log(Status.INFO,"Test case FAILED cause is: " + result.getThrowable().getMessage());
        try {
        	String imgPath=new BaseClass().captureScreen(result.getName());
        	test.addScreenCaptureFromPath(imgPath);
        }
        catch(IOException e1) {
        	e1.getStackTrace();
        }
        
      
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    	test = extent.createTest(result.getMethod().getMethodName()); // create entry in report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP,"Test case SKIPPED is: " + result.getName());
        test.log(Status.INFO,"Test case FAILED cause is: " + result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
        String pathOfExtentReport =System.getProperty("user.dir") + "\\reports\\" + repName;

        File extentReport = new File(pathOfExtentReport);

        try {
            if (extentReport.exists()) {
                Desktop.getDesktop().browse(extentReport.toURI());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}	
