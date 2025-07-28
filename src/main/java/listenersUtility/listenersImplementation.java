package listenersUtility;

import BaseClass.baseClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listenersImplementation implements ITestListener , ISuiteListener{

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	
	@Override
	public void onStart(ISuite suite) {
		Reporter.log("report configuration",true);
		Date d = new Date();
		String newdate = d.toString().replace(" ", "_").replace(":","_");
		
		spark = new ExtentSparkReporter("./AdvanceReport/report"+newdate+".html");
		spark.config().setDocumentTitle("NinzaCRM");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window10");
		report.setSystemInfo("Browser","Edge");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("Report Backup",true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"======"+result.getMethod().getMethodName()+"execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testcase = result.getMethod().getMethodName();
		Reporter.log("===========Failure"+testcase+"===========",true);
			Date d = new Date();
			String newdate = d.toString().replace(" ", "_").replace(":", "_");
			
			
			TakesScreenshot ts = (TakesScreenshot)baseClass.sdriver;
			 String temp = ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(temp,testcase+newdate);
			test.log(Status.FAIL, "==========="+testcase+"Failure");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	
	

}
