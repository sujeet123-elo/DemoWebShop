package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListner implements ITestListener
{ 
	
	public  void onStart(ITestContext context) {
    System.out.println("this is onStart method");
      }

	public void onTestStart(ITestResult result) {
		System.out.println("this is onTestStart method");
	  }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("test passed....");
	  }
	
	 public  void onTestFailure(ITestResult result) {
		 System.out.println("test Failure....");
		  }
	 
	
	 public  void onTestSkipped(ITestResult result) {
		 System.out.println("test Skipped");
		  }
	 public void onFinish(ITestContext context) {
		 System.out.println("this is onFinish method");
		  }

	
	
	
	
	
	
	
	

}
